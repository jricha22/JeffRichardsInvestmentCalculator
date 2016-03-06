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

    /**
     * Get number of periods
     * @return Number of periods
     */
    public int getPeriods() {
        return periods;
    }

    /**
     * Get periodice payment in dollare
     * @return Payment in dollars
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Get percentage rate per period as decimal (1 = 100%)
     * @return Rate per period (decimal)
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set periodic payment in dollars
     * @param payment Periodic payment in dollars
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Set periodic percentage rate in decimal (1.000 = 100%)
     * @param rate Rate per period (decimal)
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Set number of periods
     * @param periods Number of periods
     */
    public void setPeriods(int periods) {
        this.periods = periods;
    }

    /**
     * Get the calculated future value result
     * @return Calculated future value
     */
    public double getResult() {
        return 0.0;
    }
}
