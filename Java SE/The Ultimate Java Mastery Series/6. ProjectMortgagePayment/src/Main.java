public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principle ($1K - $1M): ", 1000, 1000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var report = new MortgageReport(principal, annualInterest, years);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
