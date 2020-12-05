package com.consumer_curve_element.service;

import com.consumer_curve_element.ResponseParam;
import com.consumer_curve_element.entity.CurveElement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-11-06 11:40
 */
@Component
@FeignClient(value = "provider-curve-element")
public interface CurveElementService {
    @PostMapping("/curve-element/insertCurveElement")
    int insertCurveElement(@RequestBody CurveElement curveElement);

    @PostMapping("/curve-element/modifyCurveElement")
    int modifyCurveElement(@RequestBody  CurveElement curveElement);

    @GetMapping("/curve-element/deleteCurveElement")
    int deleteCurveElement(@RequestParam("ceQx") String ceQx, @RequestParam("ceJd") String ceJd);

    @GetMapping("/curve-element/clearCurveElement")
    int clearCurveElement();

    @GetMapping("/curve-element/countCurveElement")
    long countCurveElement();

    @GetMapping("/curve-element/selectCurveLine")
    List<String> selectCurveLine();

    @GetMapping("/curve-element/selectCurveElement")
    List<CurveElement> selectCurveElement();

    @GetMapping("/curve-element/searchCurveElement")
    List<CurveElement> searchCurveElement(@RequestParam("field") String field, @RequestParam("value") String value, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit);

    @GetMapping("/curve-element/initCurveElement")
    List<CurveElement> initCurveElement(@RequestParam("ceQx") String ceQx, @RequestParam("dk_begin")Double dk_begin, @RequestParam("dk_end") Double dk_end);

    @GetMapping("/curve-element/calculateCoordinate")
    List<Map> calculateCoordinate(@RequestParam("action") Integer action, @RequestParam("ceQx") String ceQx, @RequestParam("dk_begin_break") Double dk_begin_break, @RequestParam("dk_end_break") Double dk_end_break, @RequestParam("dk_label_break") String dk_label_break,
                                  @RequestParam("dk_begin") Double dk_begin, @RequestParam("dk_end") Double dk_end, @RequestParam("dk_gap") Double dk_gap, @RequestParam("dk_dist") Double dk_dist,
                                  @RequestParam("xy_Tp") Integer xy_Tp, @RequestParam("xy_L0") Double xy_L0, @RequestParam("xy_H0") Double xy_H0);

    @GetMapping("/curve-element/exportExcelCurveElement")
    int exportExcelCurveElement();

    @GetMapping("/curve-element/importExcelCurveElement")
    int importExcelCurveElement(@RequestParam("file") String file) throws IOException;

    @GetMapping("/curve-element/getCurveElementByCeQxAndCeJd")
    CurveElement getCurveElementByCeQxAndCeJd(@RequestParam("ceQx") String ceQx, @RequestParam("ceJd") String ceJd);
}
