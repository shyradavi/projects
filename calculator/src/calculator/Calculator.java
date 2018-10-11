package calculator;

public class Calculator {
    private double number1 = 0;
    private double number2 = 0;
    private String sign = null;
    private double calculatedResult = 0;
    private double memoryResult = 0;
    private Calculate calculate = new Calculate();


    Calculator() {
    }

    void setNumber1(double number1) {
        this.number1 = number1;
    }

    void setNumber2(double number2) {
        this.number2 = number2;
    }

    void setSign(String sign) {
        this.sign = sign;
    }

    double getCalculatedResult() {
        return calculatedResult;
    }

    void calculateResult() {
        calculatedResult = calculate.calculate(number1, number2, sign);
    }

    void calculateResultWithMemory() {
        calculatedResult = calculate.calculate(memoryResult, calculatedResult, sign);
    }

    void calculateNumberWithMemory() {
        this.calculatedResult = calculate.calculate(memoryResult, number1, sign);
    }

    void saveResultInMemory() {
        memoryResult = calculatedResult;
    }

    @Override
    public String toString() {
        return "\nCalculator state{" +
                "number1 = " + number1 +
                ", number2 = " + number2 +
                ", sign = '" + sign + '\'' +
                ", calculatedResult = " + calculatedResult +
                ", memoryResult = " + memoryResult +
                '}';
    }
}
