package com.consumer_curve_element.controller;

import com.alibaba.fastjson.JSONObject;
import com.consumer_curve_element.ResponseParam;
import com.consumer_curve_element.entity.CurveElement;
import com.consumer_curve_element.entity.ResultData;
import com.consumer_curve_element.service.CurveElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-10-30 7:56
 */
//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/curve-element")
public class CurveElementController {
    @Autowired
    private CurveElementService curveElementService;

    @PostMapping("/insertCurveElement")
    public ResultData insertCurveElement(@RequestBody CurveElement curveElement) {
        if(curveElementService.insertCurveElement(curveElement) > 0) {
            String ceQx = curveElement.getCeQx();
            String ceJd = curveElement.getCeJd();
            CurveElement _curveElement = curveElementService.getCurveElementByCeQxAndCeJd(ceQx, ceJd);
            return new ResultData(0, "添加成功", _curveElement, 1);
        }

        return new ResultData(-1, "添加失败", curveElement, 1);
    }

    @PostMapping("/modifyCurveElement")
    public ResultData modifyCurveElement(@RequestBody CurveElement curveElement) {
        if(curveElementService.modifyCurveElement(curveElement) > 0) {
            String ceQx = curveElement.getCeQx();
            String ceJd = curveElement.getCeJd();
            CurveElement _curveElement = curveElementService.getCurveElementByCeQxAndCeJd(ceQx, ceJd);
            return new ResultData(0, "更新成功", _curveElement, 1);
        }

        return new ResultData(-1, "更新失败", curveElement, 1);
    }

    @PostMapping("/deleteCurveElement")
    public ResultData deleteCurveElement(@RequestBody JSONObject params) {
        String ceQx = params.getString("ceQx");
        String ceJd = params.getString("ceJd");
        CurveElement _curveElement = curveElementService.getCurveElementByCeQxAndCeJd(ceQx, ceJd);
        if(_curveElement != null) {
            curveElementService.deleteCurveElement(ceQx, ceJd);
            return new ResultData(0, "删除成功", null, 0);
        }

        return new ResultData(-1, "删除失败", _curveElement, 1);
    }

    @GetMapping("/clearCurveElement")
    public ResultData clearCurveElement() {
        List<CurveElement> list = curveElementService.selectCurveElement();
        long count = curveElementService.countCurveElement();
        if(curveElementService.clearCurveElement() == 0) {
            return new ResultData(0, "清空成功", null, 0);
        }

        return new ResultData(-1, "清空失败", list, count);
    }

    @GetMapping("/countCurveElement")
    public ResultData countCurveElement() {
        long count = curveElementService.countCurveElement();
        if(count > 0) {
            return new ResultData(0, "统计成功", count, 1);
        }

        return new ResultData(-1, "统计失败", null, 0);
    }

    @GetMapping("/selectCurveLine")
    public ResultData selectCurveLine() {
        List<String> list = curveElementService.selectCurveLine();
        if(list != null) {
            return new ResultData(0, "获取成功", list, list.size());
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    @GetMapping("/selectCurveElement")
    public ResultData selectCurveElement() {
        List<CurveElement> list = curveElementService.selectCurveElement();
        long count = curveElementService.countCurveElement();
        if(list != null) {
            return new ResultData(0, "获取成功", list, count);
        }

        return new ResultData(-1, "获取失败", null, 0);
    }

    @PostMapping("/searchCurveElement")
    public ResultData searchCurveElement(@ResponseParam JSONObject params) {
        String field = params.getString("field");
        String value = params.getString("value");
        Integer page = params.getInteger("page");
        Integer limit = params.getInteger("limit");

        List<CurveElement> list = curveElementService.searchCurveElement(field, value, page, limit);
        if(list != null) {
            return new ResultData(0, "查询成功", list, list.size());
        }

        return new ResultData(-1, "查询失败", null, 0);
    }

    @PostMapping("/initCurveElement")
    public ResultData initCurveElement(@ResponseParam JSONObject params) {
        String ceQx = params.getString("ceQx");
        Double dk_begin = params.getDouble("dk_begin");
        Double dk_end = params.getDouble("dk_end");

        List<CurveElement> list = curveElementService.initCurveElement(ceQx, dk_begin, dk_end);
        if(list != null) {
            return new ResultData(0, "初始化成功", list, list.size());
        }

        return new ResultData(-1, "初始化失败", null, 0);
    }

    @PostMapping("/calculateCoordinate")
    public ResultData calculateCoordinate(@ResponseParam JSONObject params) {
        Integer action = params.getInteger("action");
        String ceQx = params.getString("ceQx");
        Double dk_begin_break = params.getDouble("dk_begin_break");
        Double dk_end_break = params.getDouble("dk_end_break");
        String dk_label_break = params.getString("dk_label_break");
        Double dk_begin = params.getDouble("dk_begin");
        Double dk_end = params.getDouble("dk_end");
        Double dk_gap = params.getDouble("dk_gap");
        Double dk_dist = params.getDouble("dk_dist");
        Integer xy_Tp = params.getInteger("xy_Tp");
        Double xy_L0 = params.getDouble("xy_L0");
        Double xy_H0 = params.getDouble("xy_H0");

        List<Map> maps = curveElementService.calculateCoordinate(action, ceQx, dk_begin_break, dk_end_break, dk_label_break,
                dk_begin, dk_end, dk_gap, dk_dist,
                xy_Tp, xy_L0, xy_H0);

        if(maps != null) {
            return new ResultData(0, "计算成功", maps, maps.size());
        }

        return new ResultData(-1, "计算失败", null, 0);
    }

    @GetMapping("/exportExcelCurveElement")
    public ResultData exportExcelCurveElement() {
        if(curveElementService.exportExcelCurveElement() == 0) {
            return new ResultData(0, "导出成功", null, 0);
        }

        return new ResultData(-1, "导出失败", null, 0);
    }

    @PostMapping("/importExcelCurveElement")
    public ResultData importExcelCurveElement(@ResponseParam String file) throws IOException {
        if(curveElementService.importExcelCurveElement(file) == 0) {
            return new ResultData(0, "导入成功", null, 0);
        }

        return new ResultData(-1, "导入失败", null, 0);
    }
}