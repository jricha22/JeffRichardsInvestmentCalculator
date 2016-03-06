package edu.westga.jeffrichardsinvestmentcalculator.model;

/**
 * Model for an investment calculator that calculates return on investment over a given period
 * of time.
 *
 * Created by Jeff on 3/6/2016.
 */
public class InvestmentCalculator {
    private double payment;
    private double rate;
    private int periods;

    public InvestmentCalculator() {
        payment = 0.0;
        rate = 0.0;
        periods = 0;
    }

    public int getPeriods() {
        return periods;
    }

    public double getPayment() {
        return payment;
    }

    public double getRate() {
        return rate;
    }
}
