package com.provider_curve_element.mapper;

import com.provider_curve_element.entity.CurveElement;
import com.provider_curve_element.entity.CurveElementExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * CurveElementMapper继承基类
 */
@Mapper
public interface CurveElementMapper extends MyBatisBaseMapper<CurveElement, String, CurveElementExample> {
    @Delete("delete from tb_curveElement")
    void clearCurveElement();
}