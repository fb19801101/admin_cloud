package com.provider_curve_element.controller;

import com.provider_curve_element.dateutil.CoordinateCalculate;
import com.provider_curve_element.dateutil.DateConverter;
import com.provider_curve_element.excelkit.ExcelKit;
import com.provider_curve_element.excelkit.handler.ExcelReadHandler;
import com.provider_curve_element.excelkit.pojo.ExcelErrorField;
import com.google.common.collect.Lists;
import com.provider_curve_element.entity.CurveElement;
import com.provider_curve_element.entity.LayuiData;
import com.provider_curve_element.service.CurveElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-10-30 7:56
 */
@Controller
@RequestMapping("/software")
public class SoftwareController {
    @Autowired
    private CurveElementService curveElementService;

    @RequestMapping("/toolMeasure")
    public ModelAndView toMeasure(HttpServletRequest request, HttpServletResponse response) {
        Map mapMsg = new HashMap<>();
        Map elem = new HashMap<>();
        elem.put("JD","JD001");
        elem.put("DK","DK000");
        elem.put("NX","123456.1234");
        elem.put("EY","123456.1234");
        mapMsg.put("elem", elem);
        return new ModelAndView("software/measure", "message",mapMsg);
    }

    @RequestMapping("/insertCurveElementBody")
    public @ResponseBody LayuiData insertCurveElementBody(CurveElement curveElement) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        int code = 0;
        String jd = curveElement.getCeJd();
        if(jd != null && jd.length() > 0) {
            List list = curveElementService.getCurveElementByCondition("ce_JD", jd);

            if (list.size() == 0) {
                CurveElement _curveElement = curveElementService.getCurveElementByMaxJd();
                curveElement.setCeJd("newJD");
                code = curveElementService.insertCurveElement(curveElement);
            }
        }
        return new LayuiData(code, curveElement, 1);
    }

    @RequestMapping("/modifyCurveElementBody")
    public @ResponseBody LayuiData modifyCurveElementBody(CurveElement curveElement) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        CurveElement _curveElement = curveElementService.getCurveElementByJd(curveElement.getCeJd());
        return new LayuiData(curveElementService.setCurveElementByJd(curveElement), _curveElement, 1);
    }

    @RequestMapping("/deleteCurveElementBody")
    public @ResponseBody LayuiData deleteCurveElementBody(String jd) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        return new LayuiData(curveElementService.delCurveElementByJd(jd),null,0);
    }

    @RequestMapping("/clearCurveElementBody")
    public @ResponseBody LayuiData clearCurveElementBody() {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        curveElementService.clearCurveElement();
        List list = curveElementService.getAllCurveElement();
        long count = curveElementService.countAllCurveElement();
        return new LayuiData(0, list, count);
    }

    @RequestMapping("/searchCurveElement")
    public @ResponseBody LayuiData searchCurveElement() {
        List list = curveElementService.getAllCurveElement();
        long count = curveElementService.countAllCurveElement();
        return new LayuiData(0, list, count);
    }

    @RequestMapping("/searchCurveElementBody")
    public @ResponseBody LayuiData searchCurveElementBody(String field, String value, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List list = curveElementService.queryCurveElementByCondition(field, value, page, limit);
        long count = curveElementService.countCurveElementByQueryCondition(field, value);
        return new LayuiData(0, list, count);
    }

    @RequestMapping("/initCurveElementBody")
    public @ResponseBody LayuiData initCurveElementBody(Double dk_begin, Double dk_end) {
        //        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);
        double len = dk_end!=null&&dk_begin!=null ? dk_end-dk_begin : 0;
        double dk = dk_end!=null ? dk_end:0;

        List<CurveElement>  list = curveElementService.getAllCurveElement();
        for (CurveElement x:list) {
            if(x.getCeDk() > dk) {
                x.setCeDk(x.getCeDk()-len);
            }
        }

        for (int i = 1; i < list.size() - 1; i++) {
            CurveElement ce = list.get(i);
            CurveElement ce1 = list.get(i-1);
            CurveElement ce2 = list.get(i+1);
            ce.setCeZh(ce.getCeDk()-ce.getCeT1());
            ce.setCeHy(ce.getCeZh()+ce.getCeLs1());
            ce.setCeQz(ce.getCeZh()+ce.getCeLc()/2);
            ce.setCeYh(ce.getCeHy()+ce.getCeLc());
            ce.setCeHz(ce.getCeYh()+ce.getCeLs2());
            ce1.setCeZd(ce.getCeZh());
            ce2.setCeQd(ce.getCeHz());
            if(i==1) {
                CurveElement _ce = list.get(0);
                _ce.setCeQd(_ce.getCeDk());
                _ce.setCeZh(_ce.getCeQd());
                _ce.setCeHy(_ce.getCeQd());
                _ce.setCeQz((_ce.getCeQd()+_ce.getCeZd())/2);
                _ce.setCeYh(_ce.getCeZd());
                _ce.setCeHz(_ce.getCeZd());
                ce.setCeQd(_ce.getCeQd());
            }
            if(i == list.size() - 2) {
                CurveElement _ce = list.get(list.size() - 1);
                _ce.setCeZd(_ce.getCeDk());
                _ce.setCeZh(_ce.getCeQd());
                _ce.setCeHy(_ce.getCeQd());
                _ce.setCeQz((_ce.getCeQd()+_ce.getCeZd())/2);
                _ce.setCeYh(_ce.getCeZd());
                _ce.setCeHz(_ce.getCeZd());
                ce.setCeZd(_ce.getCeZd());
            }
        }

        for(CurveElement x:list){
            if(x.getCeQd() > dk) {
                x.setCeDk(x.getCeDk()+len);
                x.setCeQd(x.getCeQd()+len);
                x.setCeZh(x.getCeZh()+len);
                x.setCeHy(x.getCeHy()+len);
                x.setCeQz(x.getCeQz()+len);
                x.setCeYh(x.getCeYh()+len);
                x.setCeHz(x.getCeHz()+len);
                x.setCeZd(x.getCeZd()+len);
            }

            curveElementService.setCurveElementByJd(x);
        }
        long count = curveElementService.countAllCurveElement();

        return new LayuiData(0, list, count);
    }

    @RequestMapping("/calculateCoordinateBody")
    public @ResponseBody LayuiData calculateCoordinateBody(Integer action, Double dk_begin_break, Double dk_end_break, String dk_label_break,
                                                           Double dk_begin, Double dk_end, Double dk_gap, Double dk_dist,
                                                           Integer xy_Tp, Double xy_L0, Double xy_H0) {
        //        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);
        double len = dk_begin_break!=null&&dk_end_break!=null ? dk_end_break-dk_begin_break : 0;
        double dk0 = dk_end_break!=null ? dk_end_break:0;
        double dk1 = dk_begin!=null ? dk_begin:0;
        double dk2 = dk_end!=null ? dk_end:0;

        List<CurveElement>  list = curveElementService.getAllCurveElement();
        for (CurveElement x:list) {
            if(x.getCeQd() > dk0) {
                x.setCeDk(x.getCeDk()-len);
                x.setCeQd(x.getCeQd()-len);
                x.setCeZh(x.getCeZh()-len);
                x.setCeHy(x.getCeHy()-len);
                x.setCeQz(x.getCeQz()-len);
                x.setCeYh(x.getCeYh()-len);
                x.setCeHz(x.getCeHz()-len);
                x.setCeZd(x.getCeZd()-len);
            }
        }

        double gap = dk_gap!=null ? dk_gap:0;
        double dist = dk_dist!=null ? dk_dist:0;

        double _dk=dk1;
        List<Map> maps = new ArrayList<>();
        while (_dk<dk2) {
            double dk = _dk>dk0 ? _dk-len:_dk;
            for(int i=0; i<list.size(); i++) {
                if(dk>list.get(i).getCeZh() && dk<list.get(i+1).getCeZh()) {
                    CurveElement ce1 = list.get(i);
                    CurveElement ce2 = list.get(i);
                    CurveElement ce3 = list.get(i);
                    if(i>0) {
                        ce1 = list.get(i-1);
                    }
                    if(i<list.size()-1) {
                        ce3 = list.get(i+1);
                    }

                    double[] xys = new double[2];
                    if(ce2.inDkPart(dk) > -1) {
                        switch (ce2.inDkPart(dk)) {
                            case 1:
                                xys = CoordinateCalculate.coordinate_Line_XY(dk, dist, ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy());
                                break;
                            case 5:
                                xys = CoordinateCalculate.coordinate_Line_XY(dk, dist, ce3.getCeDk(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeNx(), ce2.getCeEy());
                                break;
                            case 2:
                                if(ce2.getCeR1().compareTo(0.000000) > 0) {
                                    xys = CoordinateCalculate.coordinate_Trans_XY(dk, dist, ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeRc(), ce2.getCeLc(), ce2.getCeR1(), ce2.getCeR2(), ce2.getCeT1(), ce2.getCeT2(), ce2.getCeLs1(), ce2.getCeLs2());
                                } else {
                                    xys = CoordinateCalculate.coordinate_Trans_XY(dk, dist, ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeRc(), ce2.getCeLc(), ce2.getCeT1(), ce2.getCeT2(), ce2.getCeLs1(), ce2.getCeLs2());
                                }
                                break;
                            case 4:
                                if(ce2.getCeR2().compareTo(0.000000) > 0) {
                                    xys = CoordinateCalculate.coordinate_Trans_XY(dk, dist, ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeRc(), ce2.getCeLc(), ce2.getCeR1(), ce2.getCeR2(), ce2.getCeT1(), ce2.getCeT2(), ce2.getCeLs1(), ce2.getCeLs2());
                                } else {
                                    xys = CoordinateCalculate.coordinate_Trans_XY(dk, dist, ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeRc(), ce2.getCeLc(), ce2.getCeT1(), ce2.getCeT2(), ce2.getCeLs1(), ce2.getCeLs2());
                                }
                                break;
                            case 3:
                                double[] _xys = CoordinateCalculate.coordinate_HY_YH(ce2.getCeDk(), ce2.getCeNx(), ce2.getCeEy(), ce1.getCeNx(), ce1.getCeEy(), ce3.getCeNx(), ce3.getCeEy(), ce2.getCeRc(), ce2.getCeLc(), ce2.getCeR1(), ce2.getCeR2(), ce2.getCeT1(), ce2.getCeT2(), ce2.getCeLs1(), ce2.getCeLs2());
                                xys = CoordinateCalculate.coordinate_Circle_XY(dk, dist, ce2.getCeHy(), _xys[0], _xys[1], _xys[2], _xys[3], ce2.getCeNx(), ce2.getCeEy(), ce2.getCeRc());
                                break;
                        }

                        Map map = new HashMap();
                        map.put("dkS", DateConverter.formatStat(_dk,1,"",_dk>dk0?dk_label_break:""));
                        map.put("dkX", String.format("%.4f",xys[0]));
                        map.put("dkY", String.format("%.4f",xys[1]));
                        if(action == 0) {
                            map.put("dkD", dist);
                        } else if(action==1) {
                            xys = CoordinateCalculate.coordinateTransform(xys[0], xys[1], xy_Tp==null?1:xy_Tp, xy_L0==null?0:xy_L0, xy_H0==null?0:xy_H0);
                            map.put("dkL", String.format("%.10f",xys[0]));
                            map.put("dkN", String.format("%.10f",xys[1]));
                        }
                        maps.add(map);
                    }

                    break;
                }
            }

            _dk = _dk+gap;
        }

        return new LayuiData(0, maps, maps.size());
    }

    @RequestMapping("/exportExcelCurveElement")
    public void exportExcelCurveElement(HttpServletResponse response) {
        List<CurveElement> list = curveElementService.getAllCurveElement();

        ExcelKit.$Export(CurveElement.class, response).downXlsx(list, true);
    }

    @RequestMapping(value="/importExcelCurveElement")
    public ResponseEntity<?> importExcelCurveElement(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        long beginMillis = System.currentTimeMillis();
        InputStream iStream = file.getInputStream();

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

        String path = request.getServletContext().getRealPath("/")+"res/upload/";
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File(path,originalFilename));

        for(int i=0; i<successList.size(); i++) {
            CurveElement entity = successList.get(i);
            CurveElement curveElement = curveElementService.getCurveElementByJd(entity.getCeJd());
            if(curveElement == null) {
                curveElementService.insertCurveElement(entity);
            }
        }

        Map map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "上传成功");
        map.put("data", successList);
        map.put("count", successList.size());
        map.put("filePath", path+originalFilename);
        map.put("haveError", errorList.size() > 0);
        map.put("error", errorList);
        map.put("timeConsuming", (System.currentTimeMillis() - beginMillis) / 1000L);

        return ResponseEntity.ok(map);
    }
}
