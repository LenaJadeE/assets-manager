package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        setAddress(address);
        setCondition(condition);
        setSquareFoot(squareFoot);
        setLotSize(lotSize);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSquareFoot;


        if (getCondition() == 1) {
            pricePerSquareFoot = new BigDecimal("180");
        } else if (getCondition() == 2) {
            pricePerSquareFoot = new BigDecimal("130");
        } else if (getCondition() == 3) {
            pricePerSquareFoot = new BigDecimal("90");
        } else {
            pricePerSquareFoot = new BigDecimal("80");
        }

        BigDecimal lotPricePerSquareFoot = new BigDecimal("0.25");
        BigDecimal lotValue = lotPricePerSquareFoot.multiply(BigDecimal.valueOf(getLotSize()));

        return houseValue.add(lotValue);
    }
}
