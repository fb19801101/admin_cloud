package com.provider_curve_element.controller;

import com.provider_curve_element.dateutil.CoordinateCalculate;
import com.provider_curve_element.dateutil.DateConverter;
import com.provider_curve_element.excelkit.ExcelKit;
import com.provider_curve_element.excelkit.handler.ExcelReadHandler;
import com.provider_curve_element.excelkit.pojo.ExcelErrorField;
import com.google.common.collect.Lists;
import com.provider_curve_element.entity.CurveElement;
import com.provider_curve_element.service.CurveElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-10-30 7:56
 */
@RestController
@RequestMapping("/curve-element")
public class CurveElementController {
    @Autowired
    private CurveElementService curveElementService;

    @PostMapping("/insertCurveElement")
    public int insertCurveElement(CurveElement curveElement) {
        Integer id = curveElementService.getPrimaryKeyByQxAndJd(curveElement.getCeQx(), curveElement.getCeJd());
        if(id == null) {
            Integer ceId = 0;
            CurveElement _curveElement = curveElementService.getCurveElementByMaxId();
            if (_curveElement != null) {
                ceId = _curveElement.getCeId() + 1;
            } else {
                ceId = 1;
            }

            curveElement.setCeId(ceId);
            return curveElementService.insertCurveElement(curveElement);
        }

        return -1;
    }

    @PostMapping("/modifyCurveElement")
    public int modifyCurveElement(CurveElement curveElement) {
        Integer id = curveElementService.getPrimaryKeyByQxAndJd(curveElement.getCeQx(), curveElement.getCeJd());
        if(id != null) {
            curveElement.setCeId(id);
            return curveElementService.setCurveElementById(curveElement);
        }

        return -1;
    }

    @GetMapping("/deleteCurveElement")
    public int deleteCurveElement(String ceQx, String ceJd) {
        Integer id = curveElementService.getPrimaryKeyByQxAndJd(ceQx, ceJd);

        if(id != null) {
            return curveElementService.delCurveElementById(id);
        }

        return -1;
    }

    @GetMapping("/clearCurveElement")
    public int clearCurveElement() {
        return curveElementService.delAllCurveElement();
    }

    @GetMapping("/countCurveElement")
    public long countCurveElement() {
        return curveElementService.countAllCurveElement();
    }

    @GetMapping("/selectCurveLine")
    public List<String> selectCurveLine() {
        return curveElementService.getCurveLine();
    }

    @GetMapping("/selectCurveElement")
    public List<CurveElement> selectCurveElement() {
        return curveElementService.getAllCurveElement();
    }

    @GetMapping("/searchCurveElement")
    public List<CurveElement> searchCurveElement(String field, String value, Integer page, Integer limit) {
        return curveElementService.queryCurveElementByCondition(field, value, page, limit);
    }

    @GetMapping("/initCurveElement")
    public List<CurveElement> initCurveElement(String ceQx, Double dk_begin, Double dk_end) {
        List<CurveElement>  list = curveElementService.getCurveElementByQx(ceQx);
        long count = curveElementService.countAllCurveElement();
        CoordinateCalculate.calculate_Point_DK(list, dk_begin, dk_end);
        CoordinateCalculate.calculate_Point_XY(list, dk_begin, dk_end);
        CoordinateCalculate.calculate_fwj_pj(list);
        CoordinateCalculate.calculate_A_E_L(list);
        for(CurveElement x:list) {
            curveElementService.setCurveElementById(x);
        }

        return list;
    }

    @GetMapping("/calculateCoordinate")
    public List<Map> calculateCoordinate(Integer action, String ceQx, Double dk_begin_break, Double dk_end_break, String dk_label_break,
                                          Double dk_begin, Double dk_end, Double dk_gap, Double dk_dist,
                                          Integer xy_Tp, Double xy_L0, Double xy_H0) {
        List<CurveElement>  list = curveElementService.getCurveElementByQx(ceQx);
        List<Map> maps = CoordinateCalculate.calculate_Curve_XYS(list, dk_begin, dk_end, dk_gap, dk_dist, dk_begin_break, dk_end_break);
        for(Map x:maps) {
            String prefix = ceQx.substring(0,ceQx.indexOf("K"));
            double _dk = Double.parseDouble(x.get("dk").toString());
            x.put("dkS", DateConverter.formatStat(_dk,1,prefix,_dk>dk_end_break?dk_label_break:""));
            double _x = Double.parseDouble(x.get("x").toString());
            double _y = Double.parseDouble(x.get("y").toString());
            x.put("dkX", String.format("%.4f",_x));
            x.put("dkY", String.format("%.4f",_y));
            if(action == 0) {
                x.put("dkD", dk_dist);
            } else if(action==1) {
                double[] xys = CoordinateCalculate.transform_Curve_XY(_x, _y, xy_Tp==null?1:xy_Tp, xy_L0==null?0:xy_L0, xy_H0==null?0:xy_H0);
                x.put("dkL", String.format("%.10f",xys[0]));
                x.put("dkN", String.format("%.10f",xys[1]));
            }
        }
        return maps;
    }

    @GetMapping("/exportExcelCurveElement")
    public int exportExcelCurveElement() {
        List<CurveElement> list = curveElementService.getAllCurveElement();

        ExcelKit.$Export(CurveElement.class, null).downXlsx(list, false);
        return 0;
    }

    @GetMapping("/importExcelCurveElement")
    public int importExcelCurveElement(String file) throws IOException {
        if(file == null) {
            return -1;
        }

        InputStream iStream = new FileInputStream(file);

        List<CurveElement> successList = Lists.newArrayList();
        List<Map<String, Object>> errorList = Lists.newArrayList();

        ExcelKit.$Import(CurveElement.class)
                .readXlsx(iStream, new ExcelReadHandler<CurveElement>() {

                    @Override
                    public void onSuccess(int sheetIndex, int rowIndex, CurveElement entity) {
                        successList.add(entity); // 单行读取成功，加入入库队列。
                    }

                    @Override
                    public void onError(int sheetIndex, int rowIndex, List<ExcelErrorField> errorFields) {
                        // 读取数据失败，记录了当前行所有失败的数据
                        Map map = new HashMap<>();
                        map.put("sheetIndex", sheetIndex);
                        map.put("rowIndex", rowIndex);
                        map.put("errorFields", errorFields);
                        errorList.add(map);
                    }
                });

        for(int i=0; i<successList.size(); i++) {
            CurveElement entity = successList.get(i);
            Integer id = curveElementService.getPrimaryKeyByQxAndJd(entity.getCeQx(), entity.getCeJd());
            if(id == null) {
                Integer ceId = 0;
                CurveElement curveElement = curveElementService.getCurveElementByMaxId();
                if (curveElement != null) {
                    ceId = curveElement.getCeId() + 1;
                } else {
                    ceId = 1;
                }

                entity.setCeId(ceId);

                curveElementService.insertCurveElement(entity);
            }
        }

        return 0;
    }

    @GetMapping("/getCurveElementByCeQxAndCeJd")
    public CurveElement getCurveElementByCeQxAndCeJd(String ceQx, String ceJd) {
        Integer id = curveElementService.getPrimaryKeyByQxAndJd(ceQx, ceJd);
        return id!=null?curveElementService.getCurveElementById(id):null;
    }
}
