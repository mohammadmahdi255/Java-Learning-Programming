public class TaxReport {

//    private CanTaxCalculator calculator;
//
//    public TaxReport(CanTaxCalculator calculator) {
//        setCalculator(calculator);
//    }

    public  void show(CanTaxCalculator calculator) {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

//    public void setCalculator(CanTaxCalculator calculator) {
//        this.calculator = calculator;
//    }
}
