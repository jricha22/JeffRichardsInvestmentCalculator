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
     * Precondition: payment >= 0
     * @param payment Periodic payment in dollars
     */
    public void setPayment(double payment) {
        if (payment < 0.0) {
            throw new IllegalArgumentException("Payment cannot be negative");
        }
        this.payment = payment;
    }

    /**
     * Set periodic percentage rate in decimal (1.000 = 100%)
     * Precondition: Rate >= 0.0
     * @param rate Rate per period (decimal)
     */
    public void setRate(double rate) {
        if (rate < 0.0) {
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        this.rate = rate;
    }

    /**
     * Set number of periods
     * Precondition: Periods >= 0
     * @param periods Number of periods
     */
    public void setPeriods(int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative");
        }
        this.periods = periods;
    }

    /**
     * Get the calculated future value result, rounded down to nearest cent
     * @return Calculated future value
     */
    public double getResult() {
        if (this.rate == 0.0) {
            return 0.0;
        }
        double result = this.payment * ((Math.pow((1.0 + this.rate), this.periods) - 1.0) / rate);
        int result_cents = (int)(result * 100 + 0.5);
        return result_cents / 100.0;
    }
}
