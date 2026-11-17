package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        setMakeModel(makeModel);
        setYear(year);
        setOdometer(odometer);
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = LocalDate.now().getYear() - year;
        BigDecimal value;

        if (age > 10) {
            value = new BigDecimal("1000.00");
        } else {
            BigDecimal ratePerYear;

            if (age <= 3) {
                ratePerYear = new BigDecimal("0.03");
            } else if (age <= 6) {
                ratePerYear = new BigDecimal("0.06");
            } else {
                ratePerYear = new BigDecimal("0.08");
            }

            BigDecimal totalReduction = ratePerYear.multiply(BigDecimal.valueOf(age));
            value = getOriginalCost().multiply(BigDecimal.ONE.subtract(totalReduction));
        }

        boolean exempt = getMakeModel().contains("Honda") || getMakeModel().contains("Toyota");

        if (getOdometer() > 100000 && !exempt) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
}
