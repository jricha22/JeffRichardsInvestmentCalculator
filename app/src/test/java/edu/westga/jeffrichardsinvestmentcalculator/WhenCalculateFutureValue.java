package edu.westga.jeffrichardsinvestmentcalculator;

import org.junit.Test;

import edu.westga.jeffrichardsinvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class WhenCalculateFutureValue {
    @Test
    public void testInitialPaymentIsZero() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        assertEquals(0, my_calc.getPayment(), 0.001);
    }

    @Test
    public void testInitialRateIsZero() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        assertEquals(0, my_calc.getRate(), 0.001);
    }

    @Test
    public void testInitialPeriodsIsZero() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        assertEquals(0, my_calc.getPeriods());
    }
}