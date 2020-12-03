package com.consumer_curve_element.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * 
 */
public class CurveElement implements Serializable {
    /**
     * 交点ID
     */
    private Integer ceId;

    /**
     * 曲线标识
     */
    private String ceQx;

    /**
     * 交点编号
     */
    private String ceJd;

    /**
     * 交点里程
     */
    private Double ceDk;

    /**
     * 交点坐标X
     */
    private Double ceEx;

    /**
     * 交点坐标Y
     */
    private Double ceNy;

    /**
     * 前切线长
     */
    private Double ceT1;

    /**
     * 后切线长
     */
    private Double ceT2;

    /**
     * 前缓和曲线半径
     */
    private Double ceR1;

    /**
     * 后缓和曲线半径
     */
    private Double ceR2;

    /**
     * 圆曲线半径
     */
    private Double ceRc;

    /**
     * 前缓和曲线参数
     */
    private Double ceA1;

    /**
     * 后缓和曲线参数
     */
    private Double ceA2;

    /**
     * 前缓和曲线长
     */
    private Double ceLs1;

    /**
     * 后缓和曲线长
     */
    private Double ceLs2;

    /**
     * 圆曲线长
     */
    private Double ceLc;

    /**
     * 夹直线长
     */
    private Double ceLz;

    /**
     * 曲线总长
     */
    private Double ceL;

    /**
     * 外失距
     */
    private Double ceE;

    /**
     * 偏角
     */
    private Double cePj;

    /**
     * 方位角
     */
    private Double ceFwj;

    /**
     * 起点里程
     */
    private Double ceQd;

    /**
     * 直缓里程
     */
    private Double ceZh;

    /**
     * 缓圆里程
     */
    private Double ceHy;

    /**
     * 曲中里程
     */
    private Double ceQz;

    /**
     * 圆缓里程
     */
    private Double ceYh;

    /**
     * 缓直里程
     */
    private Double ceHz;

    /**
     * 终点里程
     */
    private Double ceZd;

    /**
     * 起点坐标X
     */
    private Double ceQdX;

    /**
     * 起点坐标Y
     */
    private Double ceQdY;

    /**
     * 直缓坐标X
     */
    private Double ceZhX;

    /**
     * 直缓坐标Y
     */
    private Double ceZhY;

    /**
     * 缓圆坐标X
     */
    private Double ceHyX;

    /**
     * 缓圆坐标Y
     */
    private Double ceHyY;

    /**
     * 曲中坐标X
     */
    private Double ceQzX;

    /**
     * 曲中坐标Y
     */
    private Double ceQzY;

    /**
     * 圆缓坐标X
     */
    private Double ceYhX;

    /**
     * 圆缓坐标Y
     */
    private Double ceYhY;

    /**
     * 缓直坐标X
     */
    private Double ceHzX;

    /**
     * 缓直坐标Y
     */
    private Double ceHzY;

    /**
     * 终点坐标X
     */
    private Double ceZdX;

    /**
     * 终点坐标Y
     */
    private Double ceZdY;

    private static final long serialVersionUID = 1L;

    /**
     * 默认构造方法
     */
    public CurveElement() {
    }

    /**
     * 部分构造方法
     */
    public CurveElement(Integer ceId, String ceQx, String ceJd, Double ceDk, Double ceEx, Double ceNy, Double ceT1, Double ceT2, Double ceR1, Double ceR2, Double ceRc, Double ceLs1, Double ceLs2, Double ceLc, Double ceLz, Double ceE, Double cePj) {
        this.ceId = ceId;
        this.ceQx = ceQx;
        this.ceJd = ceJd;
        this.ceDk = ceDk;
        this.ceEx = ceEx;
        this.ceNy = ceNy;
        this.ceT1 = ceT1;
        this.ceT2 = ceT2;
        this.ceR1 = ceR1;
        this.ceR2 = ceR2;
        this.ceRc = ceRc;
        this.ceLs1 = ceLs1;
        this.ceLs2 = ceLs2;
        this.ceLc = ceLc;
        this.ceLz = ceLz;
        this.ceE = ceE;
        this.cePj = cePj;
    }

    /**
     * 完整构造方法
     */
    public CurveElement(Integer ceId, String ceQx, String ceJd, Double ceDk, Double ceEx, Double ceNy, Double ceT1, Double ceT2, Double ceR1, Double ceR2, Double ceRc, Double ceA1, Double ceA2, Double ceLs1, Double ceLs2, Double ceLc, Double ceLz, Double ceL, Double ceE, Double cePj, Double ceFwj, Double ceQd, Double ceZh, Double ceHy, Double ceQz, Double ceYh, Double ceHz, Double ceZd, Double ceQdX, Double ceQdY, Double ceZhX, Double ceZhY, Double ceHyX, Double ceHyY, Double ceQzX, Double ceQzY, Double ceYhX, Double ceYhY, Double ceHzX, Double ceHzY, Double ceZdX, Double ceZdY) {
        this.ceId = ceId;
        this.ceQx = ceQx;
        this.ceJd = ceJd;
        this.ceDk = ceDk;
        this.ceEx = ceEx;
        this.ceNy = ceNy;
        this.ceT1 = ceT1;
        this.ceT2 = ceT2;
        this.ceR1 = ceR1;
        this.ceR2 = ceR2;
        this.ceRc = ceRc;
        this.ceA1 = ceA1;
        this.ceA2 = ceA2;
        this.ceLs1 = ceLs1;
        this.ceLs2 = ceLs2;
        this.ceLc = ceLc;
        this.ceLz = ceLz;
        this.ceL = ceL;
        this.ceE = ceE;
        this.cePj = cePj;
        this.ceFwj = ceFwj;
        this.ceQd = ceQd;
        this.ceZh = ceZh;
        this.ceHy = ceHy;
        this.ceQz = ceQz;
        this.ceYh = ceYh;
        this.ceHz = ceHz;
        this.ceZd = ceZd;
        this.ceQdX = ceQdX;
        this.ceQdY = ceQdY;
        this.ceZhX = ceZhX;
        this.ceZhY = ceZhY;
        this.ceHyX = ceHyX;
        this.ceHyY = ceHyY;
        this.ceQzX = ceQzX;
        this.ceQzY = ceQzY;
        this.ceYhX = ceYhX;
        this.ceYhY = ceYhY;
        this.ceHzX = ceHzX;
        this.ceHzY = ceHzY;
        this.ceZdX = ceZdX;
        this.ceZdY = ceZdY;
    }

//    @JsonCreator
//    public CurveElement(@JsonProperty("ceId") Integer ceId, @JsonProperty("ceQx") String ceQx, @JsonProperty("ceJd") String ceJd, @JsonProperty("ceDk") Double ceDk, @JsonProperty("ceEx") Double ceEx, @JsonProperty("ceNy") Double ceNy, @JsonProperty("ceT1") Double ceT1, @JsonProperty("ceT2") Double ceT2,
//                        @JsonProperty("ceR1") Double ceR1, @JsonProperty("ceR2") Double ceR2, @JsonProperty("ceRc") Double ceRc, @JsonProperty("ceA1") Double ceA1, @JsonProperty("ceA2") Double ceA2, @JsonProperty("ceLs1") Double ceLs1,
//                        @JsonProperty("ceLs2") Double ceLs2, @JsonProperty("ceLc") Double ceLc, @JsonProperty("ceLz") Double ceLz, @JsonProperty("ceL") Double ceL, @JsonProperty("ceE") Double ceE, @JsonProperty("cePj") Double cePj,
//                        @JsonProperty("ceFwj") Double ceFwj, @JsonProperty("ceQd") Double ceQd, @JsonProperty("ceZh") Double ceZh, @JsonProperty("ceHy,") Double ceHy, @JsonProperty("ceQz") Double ceQz, @JsonProperty("ceYh") Double ceYh,
//                        @JsonProperty("ceHz") Double ceHz, @JsonProperty("ceZd") Double ceZd, @JsonProperty("ceQdX") Double ceQdX, @JsonProperty("ceZhX") Double ceZhX, @JsonProperty("ceHyX,") Double ceHyX, @JsonProperty("ceQzX") Double ceQzX, @JsonProperty("ceYhX") Double ceYhX,
//                        @JsonProperty("ceHzX") Double ceHzX, @JsonProperty("ceZdX") Double ceZdX,@JsonProperty("ceQdY") Double ceQdY, @JsonProperty("ceZhY") Double ceZhY, @JsonProperty("ceHyY,") Double ceHyY, @JsonProperty("ceQzY") Double ceQzY, @JsonProperty("ceYhY") Double ceYhY,
//                        @JsonProperty("ceHzY") Double ceHzY, @JsonProperty("ceZdY") Double ceZdY) {
//        this.ceId = ceId;
//        this.ceQx = ceQx;
//        this.ceJd = ceJd;
//        this.ceDk = ceDk;
//        this.ceEx = ceEx;
//        this.ceNy = ceNy;
//        this.ceT1 = ceT1;
//        this.ceT2 = ceT2;
//        this.ceR1 = ceR1;
//        this.ceR2 = ceR2;
//        this.ceRc = ceRc;
//        this.ceA1 = ceA1;
//        this.ceA2 = ceA2;
//        this.ceLs1 = ceLs1;
//        this.ceLs2 = ceLs2;
//        this.ceLc = ceLc;
//        this.ceLz = ceLz;
//        this.ceL = ceL;
//        this.ceE = ceE;
//        this.cePj = cePj;
//        this.ceFwj = ceFwj;
//        this.ceQd = ceQd;
//        this.ceZh = ceZh;
//        this.ceHy = ceHy;
//        this.ceQz = ceQz;
//        this.ceYh = ceYh;
//        this.ceHz = ceHz;
//        this.ceZd = ceZd;
//        this.ceQdX = ceQdX;
//        this.ceQdY = ceQdY;
//        this.ceZhX = ceZhX;
//        this.ceZhY = ceZhY;
//        this.ceHyX = ceHyX;
//        this.ceHyY = ceHyY;
//        this.ceQzX = ceQzX;
//        this.ceQzY = ceQzY;
//        this.ceYhX = ceYhX;
//        this.ceYhY = ceYhY;
//        this.ceHzX = ceHzX;
//        this.ceHzY = ceHzY;
//        this.ceZdX = ceZdX;
//        this.ceZdY = ceZdY;
//    }

    public Integer getCeId() {
        return ceId;
    }

    public void setCeId(Integer ceId) {
        this.ceId = ceId;
    }

    public String getCeQx() {
        return ceQx;
    }

    public void setCeQx(String ceQx) {
        this.ceQx = ceQx;
    }

    public String getCeJd() {
        return ceJd;
    }

    public void setCeJd(String ceJd) {
        this.ceJd = ceJd;
    }

    public Double getCeDk() {
        return ceDk;
    }

    public void setCeDk(Double ceDk) {
        this.ceDk = ceDk;
    }

    public Double getCeEx() {
        return ceEx;
    }

    public void setCeEx(Double ceEx) {
        this.ceEx = ceEx;
    }

    public Double getCeNy() {
        return ceNy;
    }

    public void setCeNy(Double ceNy) {
        this.ceNy = ceNy;
    }

    public Double getCeT1() {
        return ceT1;
    }

    public void setCeT1(Double ceT1) {
        this.ceT1 = ceT1;
    }

    public Double getCeT2() {
        return ceT2;
    }

    public void setCeT2(Double ceT2) {
        this.ceT2 = ceT2;
    }

    public Double getCeR1() {
        return ceR1;
    }

    public void setCeR1(Double ceR1) {
        this.ceR1 = ceR1;
    }

    public Double getCeR2() {
        return ceR2;
    }

    public void setCeR2(Double ceR2) {
        this.ceR2 = ceR2;
    }

    public Double getCeRc() {
        return ceRc;
    }

    public void setCeRc(Double ceRc) {
        this.ceRc = ceRc;
    }

    public Double getCeA1() {
        return ceA1;
    }

    public void setCeA1(Double ceA1) {
        this.ceA1 = ceA1;
    }

    public Double getCeA2() {
        return ceA2;
    }

    public void setCeA2(Double ceA2) {
        this.ceA2 = ceA2;
    }

    public Double getCeLs1() {
        return ceLs1;
    }

    public void setCeLs1(Double ceLs1) {
        this.ceLs1 = ceLs1;
    }

    public Double getCeLs2() {
        return ceLs2;
    }

    public void setCeLs2(Double ceLs2) {
        this.ceLs2 = ceLs2;
    }

    public Double getCeLc() {
        return ceLc;
    }

    public void setCeLc(Double ceLc) {
        this.ceLc = ceLc;
    }

    public Double getCeLz() {
        return ceLz;
    }

    public void setCeLz(Double ceLz) {
        this.ceLz = ceLz;
    }

    public Double getCeL() {
        return ceL;
    }

    public void setCeL(Double ceL) {
        this.ceL = ceL;
    }

    public Double getCeE() {
        return ceE;
    }

    public void setCeE(Double ceE) {
        this.ceE = ceE;
    }

    public Double getCePj() {
        return cePj;
    }

    public void setCePj(Double cePj) {
        this.cePj = cePj;
    }

    public Double getCeFwj() {
        return ceFwj;
    }

    public void setCeFwj(Double ceFwj) {
        this.ceFwj = ceFwj;
    }

    public Double getCeQd() {
        return ceQd;
    }

    public void setCeQd(Double ceQd) {
        this.ceQd = ceQd;
    }

    public Double getCeZh() {
        return ceZh;
    }

    public void setCeZh(Double ceZh) {
        this.ceZh = ceZh;
    }

    public Double getCeHy() {
        return ceHy;
    }

    public void setCeHy(Double ceHy) {
        this.ceHy = ceHy;
    }

    public Double getCeQz() {
        return ceQz;
    }

    public void setCeQz(Double ceQz) {
        this.ceQz = ceQz;
    }

    public Double getCeYh() {
        return ceYh;
    }

    public void setCeYh(Double ceYh) {
        this.ceYh = ceYh;
    }

    public Double getCeHz() {
        return ceHz;
    }

    public void setCeHz(Double ceHz) {
        this.ceHz = ceHz;
    }

    public Double getCeZd() {
        return ceZd;
    }

    public void setCeZd(Double ceZd) {
        this.ceZd = ceZd;
    }

    public Double getCeQdX() {
        return ceQdX;
    }

    public void setCeQdX(Double ceQdX) {
        this.ceQdX = ceQdX;
    }

    public Double getCeQdY() {
        return ceQdY;
    }

    public void setCeQdY(Double ceQdY) {
        this.ceQdY = ceQdY;
    }

    public Double getCeZhX() {
        return ceZhX;
    }

    public void setCeZhX(Double ceZhX) {
        this.ceZhX = ceZhX;
    }

    public Double getCeZhY() {
        return ceZhY;
    }

    public void setCeZhY(Double ceZhY) {
        this.ceZhY = ceZhY;
    }

    public Double getCeHyX() {
        return ceHyX;
    }

    public void setCeHyX(Double ceHyX) {
        this.ceHyX = ceHyX;
    }

    public Double getCeHyY() {
        return ceHyY;
    }

    public void setCeHyY(Double ceHyY) {
        this.ceHyY = ceHyY;
    }

    public Double getCeQzX() {
        return ceQzX;
    }

    public void setCeQzX(Double ceQzX) {
        this.ceQzX = ceQzX;
    }

    public Double getCeQzY() {
        return ceQzY;
    }

    public void setCeQzY(Double ceQzY) {
        this.ceQzY = ceQzY;
    }

    public Double getCeYhX() {
        return ceYhX;
    }

    public void setCeYhX(Double ceYhX) {
        this.ceYhX = ceYhX;
    }

    public Double getCeYhY() {
        return ceYhY;
    }

    public void setCeYhY(Double ceYhY) {
        this.ceYhY = ceYhY;
    }

    public Double getCeHzX() {
        return ceHzX;
    }

    public void setCeHzX(Double ceHzX) {
        this.ceHzX = ceHzX;
    }

    public Double getCeHzY() {
        return ceHzY;
    }

    public void setCeHzY(Double ceHzY) {
        this.ceHzY = ceHzY;
    }

    public Double getCeZdX() {
        return ceZdX;
    }

    public void setCeZdX(Double ceZdX) {
        this.ceZdX = ceZdX;
    }

    public Double getCeZdY() {
        return ceZdY;
    }

    public void setCeZdY(Double ceZdY) {
        this.ceZdY = ceZdY;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CurveElement other = (CurveElement) that;
        return (this.getCeId() == null ? other.getCeId() == null : this.getCeId().equals(other.getCeId()))
            && (this.getCeJd() == null ? other.getCeJd() == null : this.getCeJd().equals(other.getCeJd()))
            && (this.getCeDk() == null ? other.getCeDk() == null : this.getCeDk().equals(other.getCeDk()))
            && (this.getCeEx() == null ? other.getCeEx() == null : this.getCeEx().equals(other.getCeEx()))
            && (this.getCeNy() == null ? other.getCeNy() == null : this.getCeNy().equals(other.getCeNy()))
            && (this.getCeT1() == null ? other.getCeT1() == null : this.getCeT1().equals(other.getCeT1()))
            && (this.getCeT2() == null ? other.getCeT2() == null : this.getCeT2().equals(other.getCeT2()))
            && (this.getCeR1() == null ? other.getCeR1() == null : this.getCeR1().equals(other.getCeR1()))
            && (this.getCeR2() == null ? other.getCeR2() == null : this.getCeR2().equals(other.getCeR2()))
            && (this.getCeRc() == null ? other.getCeRc() == null : this.getCeRc().equals(other.getCeRc()))
            && (this.getCeA1() == null ? other.getCeA1() == null : this.getCeA1().equals(other.getCeA1()))
            && (this.getCeA2() == null ? other.getCeA2() == null : this.getCeA2().equals(other.getCeA2()))
            && (this.getCeLs1() == null ? other.getCeLs1() == null : this.getCeLs1().equals(other.getCeLs1()))
            && (this.getCeLs2() == null ? other.getCeLs2() == null : this.getCeLs2().equals(other.getCeLs2()))
            && (this.getCeLc() == null ? other.getCeLc() == null : this.getCeLc().equals(other.getCeLc()))
            && (this.getCeLz() == null ? other.getCeLz() == null : this.getCeLz().equals(other.getCeLz()))
            && (this.getCeL() == null ? other.getCeL() == null : this.getCeL().equals(other.getCeL()))
            && (this.getCeE() == null ? other.getCeE() == null : this.getCeE().equals(other.getCeE()))
            && (this.getCePj() == null ? other.getCePj() == null : this.getCePj().equals(other.getCePj()))
            && (this.getCeFwj() == null ? other.getCeFwj() == null : this.getCeFwj().equals(other.getCeFwj()))
            && (this.getCeQd() == null ? other.getCeQd() == null : this.getCeQd().equals(other.getCeQd()))
            && (this.getCeZh() == null ? other.getCeZh() == null : this.getCeZh().equals(other.getCeZh()))
            && (this.getCeHy() == null ? other.getCeHy() == null : this.getCeHy().equals(other.getCeHy()))
            && (this.getCeQz() == null ? other.getCeQz() == null : this.getCeQz().equals(other.getCeQz()))
            && (this.getCeYh() == null ? other.getCeYh() == null : this.getCeYh().equals(other.getCeYh()))
            && (this.getCeHz() == null ? other.getCeHz() == null : this.getCeHz().equals(other.getCeHz()))
            && (this.getCeZd() == null ? other.getCeZd() == null : this.getCeZd().equals(other.getCeZd()))
            && (this.getCeQdX() == null ? other.getCeQdX() == null : this.getCeQdX().equals(other.getCeQdX()))
            && (this.getCeQdY() == null ? other.getCeQdY() == null : this.getCeQdY().equals(other.getCeQdY()))
            && (this.getCeZhX() == null ? other.getCeZhX() == null : this.getCeZhX().equals(other.getCeZhX()))
            && (this.getCeZhY() == null ? other.getCeZhY() == null : this.getCeZhY().equals(other.getCeZhY()))
            && (this.getCeHyX() == null ? other.getCeHyX() == null : this.getCeHyX().equals(other.getCeHyX()))
            && (this.getCeHyY() == null ? other.getCeHyY() == null : this.getCeHyY().equals(other.getCeHyY()))
            && (this.getCeQzX() == null ? other.getCeQzX() == null : this.getCeQzX().equals(other.getCeQzX()))
            && (this.getCeQzY() == null ? other.getCeQzY() == null : this.getCeQzY().equals(other.getCeQzY()))
            && (this.getCeYhX() == null ? other.getCeYhX() == null : this.getCeYhX().equals(other.getCeYhX()))
            && (this.getCeYhY() == null ? other.getCeYhY() == null : this.getCeYhY().equals(other.getCeYhY()))
            && (this.getCeHzX() == null ? other.getCeHzX() == null : this.getCeHzX().equals(other.getCeHzX()))
            && (this.getCeHzY() == null ? other.getCeHzY() == null : this.getCeHzY().equals(other.getCeHzY()))
            && (this.getCeZdX() == null ? other.getCeZdX() == null : this.getCeZdX().equals(other.getCeZdX()))
            && (this.getCeZdY() == null ? other.getCeZdY() == null : this.getCeZdY().equals(other.getCeZdY()))
            && (this.getCeQx() == null ? other.getCeQx() == null : this.getCeQx().equals(other.getCeQx()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCeId() == null) ? 0 : getCeId().hashCode());
        result = prime * result + ((getCeJd() == null) ? 0 : getCeJd().hashCode());
        result = prime * result + ((getCeDk() == null) ? 0 : getCeDk().hashCode());
        result = prime * result + ((getCeEx() == null) ? 0 : getCeEx().hashCode());
        result = prime * result + ((getCeNy() == null) ? 0 : getCeNy().hashCode());
        result = prime * result + ((getCeT1() == null) ? 0 : getCeT1().hashCode());
        result = prime * result + ((getCeT2() == null) ? 0 : getCeT2().hashCode());
        result = prime * result + ((getCeR1() == null) ? 0 : getCeR1().hashCode());
        result = prime * result + ((getCeR2() == null) ? 0 : getCeR2().hashCode());
        result = prime * result + ((getCeRc() == null) ? 0 : getCeRc().hashCode());
        result = prime * result + ((getCeA1() == null) ? 0 : getCeA1().hashCode());
        result = prime * result + ((getCeA2() == null) ? 0 : getCeA2().hashCode());
        result = prime * result + ((getCeLs1() == null) ? 0 : getCeLs1().hashCode());
        result = prime * result + ((getCeLs2() == null) ? 0 : getCeLs2().hashCode());
        result = prime * result + ((getCeLc() == null) ? 0 : getCeLc().hashCode());
        result = prime * result + ((getCeLz() == null) ? 0 : getCeLz().hashCode());
        result = prime * result + ((getCeL() == null) ? 0 : getCeL().hashCode());
        result = prime * result + ((getCeE() == null) ? 0 : getCeE().hashCode());
        result = prime * result + ((getCePj() == null) ? 0 : getCePj().hashCode());
        result = prime * result + ((getCeFwj() == null) ? 0 : getCeFwj().hashCode());
        result = prime * result + ((getCeQd() == null) ? 0 : getCeQd().hashCode());
        result = prime * result + ((getCeZh() == null) ? 0 : getCeZh().hashCode());
        result = prime * result + ((getCeHy() == null) ? 0 : getCeHy().hashCode());
        result = prime * result + ((getCeQz() == null) ? 0 : getCeQz().hashCode());
        result = prime * result + ((getCeYh() == null) ? 0 : getCeYh().hashCode());
        result = prime * result + ((getCeHz() == null) ? 0 : getCeHz().hashCode());
        result = prime * result + ((getCeZd() == null) ? 0 : getCeZd().hashCode());
        result = prime * result + ((getCeQdX() == null) ? 0 : getCeQdX().hashCode());
        result = prime * result + ((getCeQdY() == null) ? 0 : getCeQdY().hashCode());
        result = prime * result + ((getCeZhX() == null) ? 0 : getCeZhX().hashCode());
        result = prime * result + ((getCeZhY() == null) ? 0 : getCeZhY().hashCode());
        result = prime * result + ((getCeHyX() == null) ? 0 : getCeHyX().hashCode());
        result = prime * result + ((getCeHyY() == null) ? 0 : getCeHyY().hashCode());
        result = prime * result + ((getCeQzX() == null) ? 0 : getCeQzX().hashCode());
        result = prime * result + ((getCeQzY() == null) ? 0 : getCeQzY().hashCode());
        result = prime * result + ((getCeYhX() == null) ? 0 : getCeYhX().hashCode());
        result = prime * result + ((getCeYhY() == null) ? 0 : getCeYhY().hashCode());
        result = prime * result + ((getCeHzX() == null) ? 0 : getCeHzX().hashCode());
        result = prime * result + ((getCeHzY() == null) ? 0 : getCeHzY().hashCode());
        result = prime * result + ((getCeZdX() == null) ? 0 : getCeZdX().hashCode());
        result = prime * result + ((getCeZdY() == null) ? 0 : getCeZdY().hashCode());
        result = prime * result + ((getCeQx() == null) ? 0 : getCeQx().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ceId=").append(ceId);
        sb.append(", ceJd=").append(ceJd);
        sb.append(", ceDk=").append(ceDk);
        sb.append(", ceEx=").append(ceEx);
        sb.append(", ceNy=").append(ceNy);
        sb.append(", ceT1=").append(ceT1);
        sb.append(", ceT2=").append(ceT2);
        sb.append(", ceR1=").append(ceR1);
        sb.append(", ceR2=").append(ceR2);
        sb.append(", ceRc=").append(ceRc);
        sb.append(", ceA1=").append(ceA1);
        sb.append(", ceA2=").append(ceA2);
        sb.append(", ceLs1=").append(ceLs1);
        sb.append(", ceLs2=").append(ceLs2);
        sb.append(", ceLc=").append(ceLc);
        sb.append(", ceLz=").append(ceLz);
        sb.append(", ceL=").append(ceL);
        sb.append(", ceE=").append(ceE);
        sb.append(", cePj=").append(cePj);
        sb.append(", ceFwj=").append(ceFwj);
        sb.append(", ceQd=").append(ceQd);
        sb.append(", ceZh=").append(ceZh);
        sb.append(", ceHy=").append(ceHy);
        sb.append(", ceQz=").append(ceQz);
        sb.append(", ceYh=").append(ceYh);
        sb.append(", ceHz=").append(ceHz);
        sb.append(", ceZd=").append(ceZd);
        sb.append(", ceQdX=").append(ceQdX);
        sb.append(", ceQdY=").append(ceQdY);
        sb.append(", ceZhX=").append(ceZhX);
        sb.append(", ceZhY=").append(ceZhY);
        sb.append(", ceHyX=").append(ceHyX);
        sb.append(", ceHyY=").append(ceHyY);
        sb.append(", ceQzX=").append(ceQzX);
        sb.append(", ceQzY=").append(ceQzY);
        sb.append(", ceYhX=").append(ceYhX);
        sb.append(", ceYhY=").append(ceYhY);
        sb.append(", ceHzX=").append(ceHzX);
        sb.append(", ceHzY=").append(ceHzY);
        sb.append(", ceZdX=").append(ceZdX);
        sb.append(", ceZdY=").append(ceZdY);
        sb.append(", ceQx=").append(ceQx);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}