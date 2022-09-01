import java.text.NumberFormat;

public class MortgageReport {

    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(int principal, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principal, annualInterest, years);
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        String mortgageFormatted = currency.format(calculator.calculateMortgage());
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println("--------");
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
        System.out.println("----------------");
    }


}
