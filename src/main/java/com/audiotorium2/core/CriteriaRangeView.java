package com.audiotorium2.core;

import lombok.Data;

@Data
public class CriteriaRangeView {

    public String criteriaName;
    public String rangeName;

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }
}
