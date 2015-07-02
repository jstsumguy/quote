package stock_quote;

public class Stock {
    
    /*
        Gets current ask, 52 week high and low, and company name (verbose)
    */
    
    private double high;
    private double low;
    private double current;
    private String ticker;
    private String verbose;
    
    public Stock(double high, double low, double current, String ticker, String name)
    {
        this.high = high;
        this.low = low;
        this.current = current;
        this.ticker = ticker;
        this.verbose = name;
    }

    /**
     * @return the high
     */
    public double getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * @return the low
     */
    public double getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(double low) {
        this.low = low;
    }

    /**
     * @return the current
     */
    public double getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(double current) {
        this.current = current;
    }

    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return the verbose
     */
    public String getVerbose() {
        return verbose;
    }

    /**
     * @param verbose the verbose to set
     */
    public void setVerbose(String verbose) {
        this.verbose = verbose;
    }
    
}
