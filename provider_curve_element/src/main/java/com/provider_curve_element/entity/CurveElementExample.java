package com.provider_curve_element.entity;

import java.util.ArrayList;
import java.util.List;

public class CurveElementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CurveElementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCeJdIsNull() {
            addCriterion("ce_JD is null");
            return (Criteria) this;
        }

        public Criteria andCeJdIsNotNull() {
            addCriterion("ce_JD is not null");
            return (Criteria) this;
        }

        public Criteria andCeJdEqualTo(String value) {
            addCriterion("ce_JD =", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdNotEqualTo(String value) {
            addCriterion("ce_JD <>", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdGreaterThan(String value) {
            addCriterion("ce_JD >", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdGreaterThanOrEqualTo(String value) {
            addCriterion("ce_JD >=", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdLessThan(String value) {
            addCriterion("ce_JD <", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdLessThanOrEqualTo(String value) {
            addCriterion("ce_JD <=", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdLike(String value) {
            addCriterion("ce_JD like", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdNotLike(String value) {
            addCriterion("ce_JD not like", value, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdIn(List<String> values) {
            addCriterion("ce_JD in", values, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdNotIn(List<String> values) {
            addCriterion("ce_JD not in", values, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdBetween(String value1, String value2) {
            addCriterion("ce_JD between", value1, value2, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeJdNotBetween(String value1, String value2) {
            addCriterion("ce_JD not between", value1, value2, "ceJd");
            return (Criteria) this;
        }

        public Criteria andCeDkIsNull() {
            addCriterion("ce_DK is null");
            return (Criteria) this;
        }

        public Criteria andCeDkIsNotNull() {
            addCriterion("ce_DK is not null");
            return (Criteria) this;
        }

        public Criteria andCeDkEqualTo(Double value) {
            addCriterion("ce_DK =", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkNotEqualTo(Double value) {
            addCriterion("ce_DK <>", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkGreaterThan(Double value) {
            addCriterion("ce_DK >", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_DK >=", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkLessThan(Double value) {
            addCriterion("ce_DK <", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkLessThanOrEqualTo(Double value) {
            addCriterion("ce_DK <=", value, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkIn(List<Double> values) {
            addCriterion("ce_DK in", values, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkNotIn(List<Double> values) {
            addCriterion("ce_DK not in", values, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkBetween(Double value1, Double value2) {
            addCriterion("ce_DK between", value1, value2, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeDkNotBetween(Double value1, Double value2) {
            addCriterion("ce_DK not between", value1, value2, "ceDk");
            return (Criteria) this;
        }

        public Criteria andCeNxIsNull() {
            addCriterion("ce_NX is null");
            return (Criteria) this;
        }

        public Criteria andCeNxIsNotNull() {
            addCriterion("ce_NX is not null");
            return (Criteria) this;
        }

        public Criteria andCeNxEqualTo(Double value) {
            addCriterion("ce_NX =", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxNotEqualTo(Double value) {
            addCriterion("ce_NX <>", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxGreaterThan(Double value) {
            addCriterion("ce_NX >", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_NX >=", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxLessThan(Double value) {
            addCriterion("ce_NX <", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxLessThanOrEqualTo(Double value) {
            addCriterion("ce_NX <=", value, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxIn(List<Double> values) {
            addCriterion("ce_NX in", values, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxNotIn(List<Double> values) {
            addCriterion("ce_NX not in", values, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxBetween(Double value1, Double value2) {
            addCriterion("ce_NX between", value1, value2, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeNxNotBetween(Double value1, Double value2) {
            addCriterion("ce_NX not between", value1, value2, "ceNx");
            return (Criteria) this;
        }

        public Criteria andCeEyIsNull() {
            addCriterion("ce_EY is null");
            return (Criteria) this;
        }

        public Criteria andCeEyIsNotNull() {
            addCriterion("ce_EY is not null");
            return (Criteria) this;
        }

        public Criteria andCeEyEqualTo(Double value) {
            addCriterion("ce_EY =", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyNotEqualTo(Double value) {
            addCriterion("ce_EY <>", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyGreaterThan(Double value) {
            addCriterion("ce_EY >", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_EY >=", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyLessThan(Double value) {
            addCriterion("ce_EY <", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyLessThanOrEqualTo(Double value) {
            addCriterion("ce_EY <=", value, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyIn(List<Double> values) {
            addCriterion("ce_EY in", values, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyNotIn(List<Double> values) {
            addCriterion("ce_EY not in", values, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyBetween(Double value1, Double value2) {
            addCriterion("ce_EY between", value1, value2, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeEyNotBetween(Double value1, Double value2) {
            addCriterion("ce_EY not between", value1, value2, "ceEy");
            return (Criteria) this;
        }

        public Criteria andCeT1IsNull() {
            addCriterion("ce_T1 is null");
            return (Criteria) this;
        }

        public Criteria andCeT1IsNotNull() {
            addCriterion("ce_T1 is not null");
            return (Criteria) this;
        }

        public Criteria andCeT1EqualTo(Double value) {
            addCriterion("ce_T1 =", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1NotEqualTo(Double value) {
            addCriterion("ce_T1 <>", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1GreaterThan(Double value) {
            addCriterion("ce_T1 >", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_T1 >=", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1LessThan(Double value) {
            addCriterion("ce_T1 <", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1LessThanOrEqualTo(Double value) {
            addCriterion("ce_T1 <=", value, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1In(List<Double> values) {
            addCriterion("ce_T1 in", values, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1NotIn(List<Double> values) {
            addCriterion("ce_T1 not in", values, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1Between(Double value1, Double value2) {
            addCriterion("ce_T1 between", value1, value2, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT1NotBetween(Double value1, Double value2) {
            addCriterion("ce_T1 not between", value1, value2, "ceT1");
            return (Criteria) this;
        }

        public Criteria andCeT2IsNull() {
            addCriterion("ce_T2 is null");
            return (Criteria) this;
        }

        public Criteria andCeT2IsNotNull() {
            addCriterion("ce_T2 is not null");
            return (Criteria) this;
        }

        public Criteria andCeT2EqualTo(Double value) {
            addCriterion("ce_T2 =", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2NotEqualTo(Double value) {
            addCriterion("ce_T2 <>", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2GreaterThan(Double value) {
            addCriterion("ce_T2 >", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_T2 >=", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2LessThan(Double value) {
            addCriterion("ce_T2 <", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2LessThanOrEqualTo(Double value) {
            addCriterion("ce_T2 <=", value, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2In(List<Double> values) {
            addCriterion("ce_T2 in", values, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2NotIn(List<Double> values) {
            addCriterion("ce_T2 not in", values, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2Between(Double value1, Double value2) {
            addCriterion("ce_T2 between", value1, value2, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeT2NotBetween(Double value1, Double value2) {
            addCriterion("ce_T2 not between", value1, value2, "ceT2");
            return (Criteria) this;
        }

        public Criteria andCeR1IsNull() {
            addCriterion("ce_R1 is null");
            return (Criteria) this;
        }

        public Criteria andCeR1IsNotNull() {
            addCriterion("ce_R1 is not null");
            return (Criteria) this;
        }

        public Criteria andCeR1EqualTo(Double value) {
            addCriterion("ce_R1 =", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1NotEqualTo(Double value) {
            addCriterion("ce_R1 <>", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1GreaterThan(Double value) {
            addCriterion("ce_R1 >", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_R1 >=", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1LessThan(Double value) {
            addCriterion("ce_R1 <", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1LessThanOrEqualTo(Double value) {
            addCriterion("ce_R1 <=", value, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1In(List<Double> values) {
            addCriterion("ce_R1 in", values, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1NotIn(List<Double> values) {
            addCriterion("ce_R1 not in", values, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1Between(Double value1, Double value2) {
            addCriterion("ce_R1 between", value1, value2, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR1NotBetween(Double value1, Double value2) {
            addCriterion("ce_R1 not between", value1, value2, "ceR1");
            return (Criteria) this;
        }

        public Criteria andCeR2IsNull() {
            addCriterion("ce_R2 is null");
            return (Criteria) this;
        }

        public Criteria andCeR2IsNotNull() {
            addCriterion("ce_R2 is not null");
            return (Criteria) this;
        }

        public Criteria andCeR2EqualTo(Double value) {
            addCriterion("ce_R2 =", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2NotEqualTo(Double value) {
            addCriterion("ce_R2 <>", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2GreaterThan(Double value) {
            addCriterion("ce_R2 >", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_R2 >=", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2LessThan(Double value) {
            addCriterion("ce_R2 <", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2LessThanOrEqualTo(Double value) {
            addCriterion("ce_R2 <=", value, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2In(List<Double> values) {
            addCriterion("ce_R2 in", values, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2NotIn(List<Double> values) {
            addCriterion("ce_R2 not in", values, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2Between(Double value1, Double value2) {
            addCriterion("ce_R2 between", value1, value2, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeR2NotBetween(Double value1, Double value2) {
            addCriterion("ce_R2 not between", value1, value2, "ceR2");
            return (Criteria) this;
        }

        public Criteria andCeRcIsNull() {
            addCriterion("ce_Rc is null");
            return (Criteria) this;
        }

        public Criteria andCeRcIsNotNull() {
            addCriterion("ce_Rc is not null");
            return (Criteria) this;
        }

        public Criteria andCeRcEqualTo(Double value) {
            addCriterion("ce_Rc =", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcNotEqualTo(Double value) {
            addCriterion("ce_Rc <>", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcGreaterThan(Double value) {
            addCriterion("ce_Rc >", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Rc >=", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcLessThan(Double value) {
            addCriterion("ce_Rc <", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcLessThanOrEqualTo(Double value) {
            addCriterion("ce_Rc <=", value, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcIn(List<Double> values) {
            addCriterion("ce_Rc in", values, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcNotIn(List<Double> values) {
            addCriterion("ce_Rc not in", values, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcBetween(Double value1, Double value2) {
            addCriterion("ce_Rc between", value1, value2, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeRcNotBetween(Double value1, Double value2) {
            addCriterion("ce_Rc not between", value1, value2, "ceRc");
            return (Criteria) this;
        }

        public Criteria andCeA1IsNull() {
            addCriterion("ce_A1 is null");
            return (Criteria) this;
        }

        public Criteria andCeA1IsNotNull() {
            addCriterion("ce_A1 is not null");
            return (Criteria) this;
        }

        public Criteria andCeA1EqualTo(Double value) {
            addCriterion("ce_A1 =", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1NotEqualTo(Double value) {
            addCriterion("ce_A1 <>", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1GreaterThan(Double value) {
            addCriterion("ce_A1 >", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_A1 >=", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1LessThan(Double value) {
            addCriterion("ce_A1 <", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1LessThanOrEqualTo(Double value) {
            addCriterion("ce_A1 <=", value, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1In(List<Double> values) {
            addCriterion("ce_A1 in", values, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1NotIn(List<Double> values) {
            addCriterion("ce_A1 not in", values, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1Between(Double value1, Double value2) {
            addCriterion("ce_A1 between", value1, value2, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA1NotBetween(Double value1, Double value2) {
            addCriterion("ce_A1 not between", value1, value2, "ceA1");
            return (Criteria) this;
        }

        public Criteria andCeA2IsNull() {
            addCriterion("ce_A2 is null");
            return (Criteria) this;
        }

        public Criteria andCeA2IsNotNull() {
            addCriterion("ce_A2 is not null");
            return (Criteria) this;
        }

        public Criteria andCeA2EqualTo(Double value) {
            addCriterion("ce_A2 =", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2NotEqualTo(Double value) {
            addCriterion("ce_A2 <>", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2GreaterThan(Double value) {
            addCriterion("ce_A2 >", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_A2 >=", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2LessThan(Double value) {
            addCriterion("ce_A2 <", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2LessThanOrEqualTo(Double value) {
            addCriterion("ce_A2 <=", value, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2In(List<Double> values) {
            addCriterion("ce_A2 in", values, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2NotIn(List<Double> values) {
            addCriterion("ce_A2 not in", values, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2Between(Double value1, Double value2) {
            addCriterion("ce_A2 between", value1, value2, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeA2NotBetween(Double value1, Double value2) {
            addCriterion("ce_A2 not between", value1, value2, "ceA2");
            return (Criteria) this;
        }

        public Criteria andCeLs1IsNull() {
            addCriterion("ce_Ls1 is null");
            return (Criteria) this;
        }

        public Criteria andCeLs1IsNotNull() {
            addCriterion("ce_Ls1 is not null");
            return (Criteria) this;
        }

        public Criteria andCeLs1EqualTo(Double value) {
            addCriterion("ce_Ls1 =", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1NotEqualTo(Double value) {
            addCriterion("ce_Ls1 <>", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1GreaterThan(Double value) {
            addCriterion("ce_Ls1 >", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Ls1 >=", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1LessThan(Double value) {
            addCriterion("ce_Ls1 <", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1LessThanOrEqualTo(Double value) {
            addCriterion("ce_Ls1 <=", value, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1In(List<Double> values) {
            addCriterion("ce_Ls1 in", values, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1NotIn(List<Double> values) {
            addCriterion("ce_Ls1 not in", values, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1Between(Double value1, Double value2) {
            addCriterion("ce_Ls1 between", value1, value2, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs1NotBetween(Double value1, Double value2) {
            addCriterion("ce_Ls1 not between", value1, value2, "ceLs1");
            return (Criteria) this;
        }

        public Criteria andCeLs2IsNull() {
            addCriterion("ce_Ls2 is null");
            return (Criteria) this;
        }

        public Criteria andCeLs2IsNotNull() {
            addCriterion("ce_Ls2 is not null");
            return (Criteria) this;
        }

        public Criteria andCeLs2EqualTo(Double value) {
            addCriterion("ce_Ls2 =", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2NotEqualTo(Double value) {
            addCriterion("ce_Ls2 <>", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2GreaterThan(Double value) {
            addCriterion("ce_Ls2 >", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2GreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Ls2 >=", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2LessThan(Double value) {
            addCriterion("ce_Ls2 <", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2LessThanOrEqualTo(Double value) {
            addCriterion("ce_Ls2 <=", value, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2In(List<Double> values) {
            addCriterion("ce_Ls2 in", values, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2NotIn(List<Double> values) {
            addCriterion("ce_Ls2 not in", values, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2Between(Double value1, Double value2) {
            addCriterion("ce_Ls2 between", value1, value2, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLs2NotBetween(Double value1, Double value2) {
            addCriterion("ce_Ls2 not between", value1, value2, "ceLs2");
            return (Criteria) this;
        }

        public Criteria andCeLcIsNull() {
            addCriterion("ce_Lc is null");
            return (Criteria) this;
        }

        public Criteria andCeLcIsNotNull() {
            addCriterion("ce_Lc is not null");
            return (Criteria) this;
        }

        public Criteria andCeLcEqualTo(Double value) {
            addCriterion("ce_Lc =", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcNotEqualTo(Double value) {
            addCriterion("ce_Lc <>", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcGreaterThan(Double value) {
            addCriterion("ce_Lc >", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Lc >=", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcLessThan(Double value) {
            addCriterion("ce_Lc <", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcLessThanOrEqualTo(Double value) {
            addCriterion("ce_Lc <=", value, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcIn(List<Double> values) {
            addCriterion("ce_Lc in", values, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcNotIn(List<Double> values) {
            addCriterion("ce_Lc not in", values, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcBetween(Double value1, Double value2) {
            addCriterion("ce_Lc between", value1, value2, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLcNotBetween(Double value1, Double value2) {
            addCriterion("ce_Lc not between", value1, value2, "ceLc");
            return (Criteria) this;
        }

        public Criteria andCeLzIsNull() {
            addCriterion("ce_Lz is null");
            return (Criteria) this;
        }

        public Criteria andCeLzIsNotNull() {
            addCriterion("ce_Lz is not null");
            return (Criteria) this;
        }

        public Criteria andCeLzEqualTo(Double value) {
            addCriterion("ce_Lz =", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzNotEqualTo(Double value) {
            addCriterion("ce_Lz <>", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzGreaterThan(Double value) {
            addCriterion("ce_Lz >", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Lz >=", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzLessThan(Double value) {
            addCriterion("ce_Lz <", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzLessThanOrEqualTo(Double value) {
            addCriterion("ce_Lz <=", value, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzIn(List<Double> values) {
            addCriterion("ce_Lz in", values, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzNotIn(List<Double> values) {
            addCriterion("ce_Lz not in", values, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzBetween(Double value1, Double value2) {
            addCriterion("ce_Lz between", value1, value2, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLzNotBetween(Double value1, Double value2) {
            addCriterion("ce_Lz not between", value1, value2, "ceLz");
            return (Criteria) this;
        }

        public Criteria andCeLhIsNull() {
            addCriterion("ce_Lh is null");
            return (Criteria) this;
        }

        public Criteria andCeLhIsNotNull() {
            addCriterion("ce_Lh is not null");
            return (Criteria) this;
        }

        public Criteria andCeLhEqualTo(Double value) {
            addCriterion("ce_Lh =", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhNotEqualTo(Double value) {
            addCriterion("ce_Lh <>", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhGreaterThan(Double value) {
            addCriterion("ce_Lh >", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_Lh >=", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhLessThan(Double value) {
            addCriterion("ce_Lh <", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhLessThanOrEqualTo(Double value) {
            addCriterion("ce_Lh <=", value, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhIn(List<Double> values) {
            addCriterion("ce_Lh in", values, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhNotIn(List<Double> values) {
            addCriterion("ce_Lh not in", values, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhBetween(Double value1, Double value2) {
            addCriterion("ce_Lh between", value1, value2, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeLhNotBetween(Double value1, Double value2) {
            addCriterion("ce_Lh not between", value1, value2, "ceLh");
            return (Criteria) this;
        }

        public Criteria andCeEIsNull() {
            addCriterion("ce_E is null");
            return (Criteria) this;
        }

        public Criteria andCeEIsNotNull() {
            addCriterion("ce_E is not null");
            return (Criteria) this;
        }

        public Criteria andCeEEqualTo(Double value) {
            addCriterion("ce_E =", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeENotEqualTo(Double value) {
            addCriterion("ce_E <>", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeEGreaterThan(Double value) {
            addCriterion("ce_E >", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeEGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_E >=", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeELessThan(Double value) {
            addCriterion("ce_E <", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeELessThanOrEqualTo(Double value) {
            addCriterion("ce_E <=", value, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeEIn(List<Double> values) {
            addCriterion("ce_E in", values, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeENotIn(List<Double> values) {
            addCriterion("ce_E not in", values, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeEBetween(Double value1, Double value2) {
            addCriterion("ce_E between", value1, value2, "ceE");
            return (Criteria) this;
        }

        public Criteria andCeENotBetween(Double value1, Double value2) {
            addCriterion("ce_E not between", value1, value2, "ceE");
            return (Criteria) this;
        }

        public Criteria andCePjIsNull() {
            addCriterion("ce_PJ is null");
            return (Criteria) this;
        }

        public Criteria andCePjIsNotNull() {
            addCriterion("ce_PJ is not null");
            return (Criteria) this;
        }

        public Criteria andCePjEqualTo(Double value) {
            addCriterion("ce_PJ =", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjNotEqualTo(Double value) {
            addCriterion("ce_PJ <>", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjGreaterThan(Double value) {
            addCriterion("ce_PJ >", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_PJ >=", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjLessThan(Double value) {
            addCriterion("ce_PJ <", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjLessThanOrEqualTo(Double value) {
            addCriterion("ce_PJ <=", value, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjIn(List<Double> values) {
            addCriterion("ce_PJ in", values, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjNotIn(List<Double> values) {
            addCriterion("ce_PJ not in", values, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjBetween(Double value1, Double value2) {
            addCriterion("ce_PJ between", value1, value2, "cePj");
            return (Criteria) this;
        }

        public Criteria andCePjNotBetween(Double value1, Double value2) {
            addCriterion("ce_PJ not between", value1, value2, "cePj");
            return (Criteria) this;
        }

        public Criteria andCeFwjIsNull() {
            addCriterion("ce_FWJ is null");
            return (Criteria) this;
        }

        public Criteria andCeFwjIsNotNull() {
            addCriterion("ce_FWJ is not null");
            return (Criteria) this;
        }

        public Criteria andCeFwjEqualTo(Double value) {
            addCriterion("ce_FWJ =", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjNotEqualTo(Double value) {
            addCriterion("ce_FWJ <>", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjGreaterThan(Double value) {
            addCriterion("ce_FWJ >", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_FWJ >=", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjLessThan(Double value) {
            addCriterion("ce_FWJ <", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjLessThanOrEqualTo(Double value) {
            addCriterion("ce_FWJ <=", value, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjIn(List<Double> values) {
            addCriterion("ce_FWJ in", values, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjNotIn(List<Double> values) {
            addCriterion("ce_FWJ not in", values, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjBetween(Double value1, Double value2) {
            addCriterion("ce_FWJ between", value1, value2, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeFwjNotBetween(Double value1, Double value2) {
            addCriterion("ce_FWJ not between", value1, value2, "ceFwj");
            return (Criteria) this;
        }

        public Criteria andCeQdIsNull() {
            addCriterion("ce_QD is null");
            return (Criteria) this;
        }

        public Criteria andCeQdIsNotNull() {
            addCriterion("ce_QD is not null");
            return (Criteria) this;
        }

        public Criteria andCeQdEqualTo(Double value) {
            addCriterion("ce_QD =", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdNotEqualTo(Double value) {
            addCriterion("ce_QD <>", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdGreaterThan(Double value) {
            addCriterion("ce_QD >", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_QD >=", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdLessThan(Double value) {
            addCriterion("ce_QD <", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdLessThanOrEqualTo(Double value) {
            addCriterion("ce_QD <=", value, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdIn(List<Double> values) {
            addCriterion("ce_QD in", values, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdNotIn(List<Double> values) {
            addCriterion("ce_QD not in", values, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdBetween(Double value1, Double value2) {
            addCriterion("ce_QD between", value1, value2, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeQdNotBetween(Double value1, Double value2) {
            addCriterion("ce_QD not between", value1, value2, "ceQd");
            return (Criteria) this;
        }

        public Criteria andCeZhIsNull() {
            addCriterion("ce_ZH is null");
            return (Criteria) this;
        }

        public Criteria andCeZhIsNotNull() {
            addCriterion("ce_ZH is not null");
            return (Criteria) this;
        }

        public Criteria andCeZhEqualTo(Double value) {
            addCriterion("ce_ZH =", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhNotEqualTo(Double value) {
            addCriterion("ce_ZH <>", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhGreaterThan(Double value) {
            addCriterion("ce_ZH >", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_ZH >=", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhLessThan(Double value) {
            addCriterion("ce_ZH <", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhLessThanOrEqualTo(Double value) {
            addCriterion("ce_ZH <=", value, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhIn(List<Double> values) {
            addCriterion("ce_ZH in", values, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhNotIn(List<Double> values) {
            addCriterion("ce_ZH not in", values, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhBetween(Double value1, Double value2) {
            addCriterion("ce_ZH between", value1, value2, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeZhNotBetween(Double value1, Double value2) {
            addCriterion("ce_ZH not between", value1, value2, "ceZh");
            return (Criteria) this;
        }

        public Criteria andCeHyIsNull() {
            addCriterion("ce_HY is null");
            return (Criteria) this;
        }

        public Criteria andCeHyIsNotNull() {
            addCriterion("ce_HY is not null");
            return (Criteria) this;
        }

        public Criteria andCeHyEqualTo(Double value) {
            addCriterion("ce_HY =", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyNotEqualTo(Double value) {
            addCriterion("ce_HY <>", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyGreaterThan(Double value) {
            addCriterion("ce_HY >", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_HY >=", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyLessThan(Double value) {
            addCriterion("ce_HY <", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyLessThanOrEqualTo(Double value) {
            addCriterion("ce_HY <=", value, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyIn(List<Double> values) {
            addCriterion("ce_HY in", values, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyNotIn(List<Double> values) {
            addCriterion("ce_HY not in", values, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyBetween(Double value1, Double value2) {
            addCriterion("ce_HY between", value1, value2, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeHyNotBetween(Double value1, Double value2) {
            addCriterion("ce_HY not between", value1, value2, "ceHy");
            return (Criteria) this;
        }

        public Criteria andCeQzIsNull() {
            addCriterion("ce_QZ is null");
            return (Criteria) this;
        }

        public Criteria andCeQzIsNotNull() {
            addCriterion("ce_QZ is not null");
            return (Criteria) this;
        }

        public Criteria andCeQzEqualTo(Double value) {
            addCriterion("ce_QZ =", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzNotEqualTo(Double value) {
            addCriterion("ce_QZ <>", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzGreaterThan(Double value) {
            addCriterion("ce_QZ >", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_QZ >=", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzLessThan(Double value) {
            addCriterion("ce_QZ <", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzLessThanOrEqualTo(Double value) {
            addCriterion("ce_QZ <=", value, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzIn(List<Double> values) {
            addCriterion("ce_QZ in", values, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzNotIn(List<Double> values) {
            addCriterion("ce_QZ not in", values, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzBetween(Double value1, Double value2) {
            addCriterion("ce_QZ between", value1, value2, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeQzNotBetween(Double value1, Double value2) {
            addCriterion("ce_QZ not between", value1, value2, "ceQz");
            return (Criteria) this;
        }

        public Criteria andCeYhIsNull() {
            addCriterion("ce_YH is null");
            return (Criteria) this;
        }

        public Criteria andCeYhIsNotNull() {
            addCriterion("ce_YH is not null");
            return (Criteria) this;
        }

        public Criteria andCeYhEqualTo(Double value) {
            addCriterion("ce_YH =", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhNotEqualTo(Double value) {
            addCriterion("ce_YH <>", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhGreaterThan(Double value) {
            addCriterion("ce_YH >", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_YH >=", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhLessThan(Double value) {
            addCriterion("ce_YH <", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhLessThanOrEqualTo(Double value) {
            addCriterion("ce_YH <=", value, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhIn(List<Double> values) {
            addCriterion("ce_YH in", values, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhNotIn(List<Double> values) {
            addCriterion("ce_YH not in", values, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhBetween(Double value1, Double value2) {
            addCriterion("ce_YH between", value1, value2, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeYhNotBetween(Double value1, Double value2) {
            addCriterion("ce_YH not between", value1, value2, "ceYh");
            return (Criteria) this;
        }

        public Criteria andCeHzIsNull() {
            addCriterion("ce_HZ is null");
            return (Criteria) this;
        }

        public Criteria andCeHzIsNotNull() {
            addCriterion("ce_HZ is not null");
            return (Criteria) this;
        }

        public Criteria andCeHzEqualTo(Double value) {
            addCriterion("ce_HZ =", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzNotEqualTo(Double value) {
            addCriterion("ce_HZ <>", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzGreaterThan(Double value) {
            addCriterion("ce_HZ >", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_HZ >=", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzLessThan(Double value) {
            addCriterion("ce_HZ <", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzLessThanOrEqualTo(Double value) {
            addCriterion("ce_HZ <=", value, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzIn(List<Double> values) {
            addCriterion("ce_HZ in", values, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzNotIn(List<Double> values) {
            addCriterion("ce_HZ not in", values, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzBetween(Double value1, Double value2) {
            addCriterion("ce_HZ between", value1, value2, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeHzNotBetween(Double value1, Double value2) {
            addCriterion("ce_HZ not between", value1, value2, "ceHz");
            return (Criteria) this;
        }

        public Criteria andCeZdIsNull() {
            addCriterion("ce_ZD is null");
            return (Criteria) this;
        }

        public Criteria andCeZdIsNotNull() {
            addCriterion("ce_ZD is not null");
            return (Criteria) this;
        }

        public Criteria andCeZdEqualTo(Double value) {
            addCriterion("ce_ZD =", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdNotEqualTo(Double value) {
            addCriterion("ce_ZD <>", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdGreaterThan(Double value) {
            addCriterion("ce_ZD >", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdGreaterThanOrEqualTo(Double value) {
            addCriterion("ce_ZD >=", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdLessThan(Double value) {
            addCriterion("ce_ZD <", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdLessThanOrEqualTo(Double value) {
            addCriterion("ce_ZD <=", value, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdIn(List<Double> values) {
            addCriterion("ce_ZD in", values, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdNotIn(List<Double> values) {
            addCriterion("ce_ZD not in", values, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdBetween(Double value1, Double value2) {
            addCriterion("ce_ZD between", value1, value2, "ceZd");
            return (Criteria) this;
        }

        public Criteria andCeZdNotBetween(Double value1, Double value2) {
            addCriterion("ce_ZD not between", value1, value2, "ceZd");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}