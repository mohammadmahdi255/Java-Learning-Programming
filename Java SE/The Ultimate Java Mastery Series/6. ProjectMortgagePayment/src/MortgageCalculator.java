public class MortgageCalculator {

    private static final byte MONTH_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float monthlyInterest;
    private byte numberOfPayments;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    public double calculateMortgage() {
        double X = Math.pow(1 + monthlyInterest, numberOfPayments);
        return principal * monthlyInterest * X / (X - 1);
    }

    public double calculateBalance(byte numberOfPaymentsMade) {
        double X = Math.pow(1 + monthlyInterest, numberOfPayments);
        return principal
                * (X - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (X - 1);
    }

    public void setPrincipal(int principal) {
        if(principal < 1000 || principal > 1000_000)
            throw new IllegalArgumentException("Enter a number between 1000 and 100000");
        this.principal = principal;
    }

    public void setAnnualInterest(float annualInterest) {
        if(annualInterest < 1 || annualInterest > 30)
            throw new IllegalArgumentException("Enter a number between 1 and 30");
        this.monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
    }

    public void setYears(byte years) {
        if(years < 1 || years > 30)
            throw new IllegalArgumentException("Enter a number between 1 and 30");
        numberOfPayments = (byte) (years * MONTH_IN_YEAR);
    }

    public double[] getRemainingBalances() {
        var balances = new double[numberOfPayments];
        for (byte i = 1; i <= numberOfPayments; i++)
            balances[i-1] = calculateBalance(i);
        return balances;
    }
}
