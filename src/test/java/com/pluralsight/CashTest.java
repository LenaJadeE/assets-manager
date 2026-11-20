package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {

    @Test
    void getValue_should_returnOriginalCost() {
        Cash cash = new Cash("mattress stash", "2024-12-01", new BigDecimal("2500"));
        BigDecimal expected = new BigDecimal("2500");

        BigDecimal actual = cash.getValue();

        assertEquals(expected, actual);
    }
}