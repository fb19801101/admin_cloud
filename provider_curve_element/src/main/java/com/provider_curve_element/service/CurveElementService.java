package com.provider_curve_element.service;

import com.provider_curve_element.entity.CurveElement;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:09
 */
public interface CurveElementService {
    List<CurveElement> getAllCurveElement();

    List<CurveElement> getAllCurveElement(Integer page, Integer limit);

    CurveElement getCurveElementByJd(String jd);

    CurveElement getCurveElementByMinJd();

    CurveElement getCurveElementByMaxJd();

    List<CurveElement> getCurveElementByParam(CurveElement record);

    List<CurveElement> queryCurveElementByParam(CurveElement record);

    List<CurveElement> getCurveElementByCondition(String field, Object value);

    long countCurveElementBySelectCondition(String field, Object value);

    List<CurveElement> getCurveElementByCondition(String field, Object value, Integer page, Integer limit);

    List<CurveElement> queryCurveElementByCondition(String field, Object value);

    long countCurveElementByQueryCondition(String field, Object value);

    List<CurveElement> queryCurveElementByCondition(String field, Object value, Integer page, Integer limit);

    List<CurveElement> getCurveElementFieldsByCondition(String fields, String field, Object value);

    List<CurveElement> getCurveElementFieldsByCondition(String fields, String field, Object value, Integer page, Integer limit);

    List<CurveElement> queryCurveElementFieldsByCondition(String fields, String field, Object value);

    List<CurveElement> queryCurveElementFieldsByCondition(String fields, String field, Object value, Integer page, Integer limit);

    List<CurveElement> getCurveElementBySql(String sql);

    List<CurveElement> getCurveElementFieldsBySql(String fields, String sql);

    int insertCurveElement(CurveElement record);

    int setCurveElementByJd(CurveElement record);

    int delCurveElementByJd(String jd);

    long countAllCurveElement();

    void clearCurveElement();
}