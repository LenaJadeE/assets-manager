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

    @Test
    void getValue_should_take25PercentOff_whenOver100000MilesAndNotHondaOrToyota() {
        int thisYear = LocalDate.now().getYear();
        Vehicle vehicle = new Vehicle("Tom's truck", "2015-01-10", new BigDecimal("20000"),
                "Ford F-150", thisYear - 5, 140000);
        BigDecimal expected = new BigDecimal("10500.00");

        BigDecimal actual = vehicle.getValue();

        assertEquals(0, expected.compareTo(actual));
    }
}