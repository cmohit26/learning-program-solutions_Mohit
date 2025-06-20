package DeepSkilling.EngConcepts.AlgoDataStructure.Exercise7.Code;

public class FutureValueCalculator {

    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  // Initial investment
        double growthRate = 0.07;      // 7% annual growth
        int years = 10;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf(" STEP2  -------> Create a Recursive Method: FV=PV×(1+r)^n \n");
        System.out.println("\t WHERE \n\t\tFV: Future Value \n\t\tPV: Present Value \n\t\tr: Rate\n\n");

        System.out.printf(" STEP3  -------> Future Value after %d years: %.2f\n", years, futureValue);

    }
}
