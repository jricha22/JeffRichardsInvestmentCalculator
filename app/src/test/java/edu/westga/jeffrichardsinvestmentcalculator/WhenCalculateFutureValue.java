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
        assertEquals(0, my_calc.getRate(), 0.00001);
    }

    @Test
    public void testInitialPeriodsIsZero() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        assertEquals(0, my_calc.getPeriods());
    }

    @Test
    public void testSetPaymentGetsPayment() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        my_calc.setPayment(1000.23);
        assertEquals(1000.23, my_calc.getPayment(), 0.001);
    }

    @Test
    public void testSetRateGetsRate() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        my_calc.setRate(0.1234);
        assertEquals(0.1234, my_calc.getRate(), 0.00001);
    }

    @Test
    public void testSetPeriodGetsPeriod() throws Exception {
        InvestmentCalculator my_calc = new InvestmentCalculator();
        my_calc.setPeriods(9);
        assertEquals(9, my_calc.getPeriods());
    }
}