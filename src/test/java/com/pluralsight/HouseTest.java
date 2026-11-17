package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void getValue_should_return235500_forGoodHouseOf1800SquareFeetOn6000SquareFootLot() {
        House house = new House("my house", "2020-06-15", new BigDecimal("180000"),
                "12 Maple Lane", 2, 1800, 6000);
        BigDecimal expected = new BigDecimal("235500.00");

        BigDecimal actual = house.getValue();

        assertEquals(expected, actual);
    }
}