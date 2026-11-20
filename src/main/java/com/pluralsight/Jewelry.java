package com.pluralsight;

import java.math.BigDecimal;

public class Jewelry extends Asset {

    private BigDecimal appraisedValue;

    public Jewelry(String description, String dateAcquired, BigDecimal originalCost,
                   BigDecimal appraisedValue) {
        super(description, dateAcquired, originalCost);
        setAppraisedValue(appraisedValue);
    }

    public BigDecimal getAppraisedValue() {
        return appraisedValue;
    }

    public void setAppraisedValue(BigDecimal appraisedValue) {
        this.appraisedValue = appraisedValue;
    }

    @Override
    public BigDecimal getValue() {
        return getAppraisedValue();
    }
}

