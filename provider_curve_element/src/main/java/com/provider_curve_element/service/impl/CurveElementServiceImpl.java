package com.provider_curve_element.service.impl;

import com.provider_curve_element.mapper.CurveElementMapper;
import com.provider_curve_element.entity.CurveElement;
import com.provider_curve_element.service.CurveElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:11
 */
@Service
public class CurveElementServiceImpl implements CurveElementService {
    @Resource
    private CurveElementMapper curveElementMapper;

    @Override
    public List<CurveElement> getAllCurveElement() {
        return curveElementMapper.selectAllModel();
    }

    @Override
    public List<CurveElement> getAllCurveElement(Integer page, Integer limit) {
        return curveElementMapper.selectAllModel((page-1)*limit,limit);
    }

    @Override
    public CurveElement getCurveElementByJd(String jd) {
        return curveElementMapper.selectByPrimaryKey(jd);
    }

    @Override
    public CurveElement getCurveElementByMinJd() {
        return curveElementMapper.selectByMinPrimaryKey();
    }

    @Override
    public CurveElement getCurveElementByMaxJd() {
        return curveElementMapper.selectByMaxPrimaryKey();
    }

    @Override
    public List<CurveElement> getCurveElementByParam(CurveElement record) {
        return curveElementMapper.selectByParam(record);
    }

    @Override
    public List<CurveElement> queryCurveElementByParam(CurveElement record) {
        return curveElementMapper.queryByParam(record);
    }

    @Override
    public List<CurveElement> getCurveElementByCondition(String field, Object value) {
        return curveElementMapper.selectByCondition(field,value);
    }

    @Override
    public long countCurveElementBySelectCondition(String field, Object value) {
        return curveElementMapper.countBySelectCondition(field,value);
    }

    @Override
    public List<CurveElement> getCurveElementByCondition(String field, Object value, Integer page, Integer limit) {
        return curveElementMapper.selectByCondition(field,value,(page-1)*limit,limit);
    }

    @Override
    public List<CurveElement> queryCurveElementByCondition(String field, Object value) {
        return curveElementMapper.queryByCondition(field,value);
    }

    @Override
    public long countCurveElementByQueryCondition(String field, Object value) {
        return curveElementMapper.countByQueryCondition(field,value);
    }

    @Override
    public List<CurveElement> queryCurveElementByCondition(String field, Object value, Integer page, Integer limit) {
        return curveElementMapper.queryByCondition(field,value,(page-1)*limit,limit);
    }

    @Override
    public List<CurveElement> getCurveElementFieldsByCondition(String fields, String field, Object value) {
        return curveElementMapper.selectFieldsByCondition(fields,field,value);
    }

    @Override
    public List<CurveElement> getCurveElementFieldsByCondition(String fields, String field, Object value, Integer page, Integer limit) {
        return curveElementMapper.selectFieldsByCondition(fields,field,value,(page-1)*limit,limit);
    }

    @Override
    public List<CurveElement> queryCurveElementFieldsByCondition(String fields, String field, Object value) {
        return curveElementMapper.queryFieldsByCondition(fields,field,value);
    }

    @Override
    public List<CurveElement> queryCurveElementFieldsByCondition(String fields, String field, Object value, Integer page, Integer limit) {
        return curveElementMapper.queryFieldsByCondition(fields,field,value,(page-1)*limit,limit);
    }

    @Override
    public List<CurveElement> getCurveElementBySql(String sql) {
        return curveElementMapper.selectBySql(sql);
    }

    @Override
    public List<CurveElement> getCurveElementFieldsBySql(String field, String sql) {
        return curveElementMapper.selectFieldsBySql(field,sql);
    }

    @Override
    public int insertCurveElement(CurveElement record) {
        return curveElementMapper.insert(record);
    }

    @Override
    public int setCurveElementByJd(CurveElement record) {
        return curveElementMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delCurveElementByJd(String jd) {
        return curveElementMapper.deleteByPrimaryKey(jd);
    }

    @Override
    public long countAllCurveElement() {
        return curveElementMapper.countAllModel();
    }

    @Override
    public void clearCurveElement() {
        curveElementMapper.clearCurveElement();
    }
}