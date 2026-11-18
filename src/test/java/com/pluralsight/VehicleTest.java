package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void getValue_should_return18800_forTwoYearOldCarWorth20000() {
        int thisYear = LocalDate.now().getYear();
        Vehicle vehicle = new Vehicle("my car", "2023-08-20", new BigDecimal("20000"),
                "Mazda CX-5", thisYear - 2, 35000);
        BigDecimal expected = new BigDecimal("18800.00");

        BigDecimal actual = vehicle.getValue();

        assertEquals(0, expected.compareTo(actual));
    }
}