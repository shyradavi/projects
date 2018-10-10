
public class Calculator {
    private double number1 = 0;
    private double number2 = 0;
    private String sign = null;
    private double calculatedResult = 0;
    private double memoryResult = 0;

    public Calculator() {
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getCalculatedResult() {
        return calculatedResult;
    }

    public void calculateResult() {
        calculatedResult = calculate(number1, number2);
    }

    public void calculateResultWithMemory() {
        calculatedResult = calculate(memoryResult, calculatedResult);
    }
    public void calculateNumberWithMemory() {
        calculatedResult = calculate(memoryResult, number1);
    }

    private double calculate(double d1, double d2) {
        double result = 0;
        switch (sign) {
            case "*": {
                result = d1 * d2;
                break;
            }
            case "/": {
                result = d1 / d2;
                break;
            }
            case "+": {
                result = d1 + d2;
                break;
            }
            case "-": {
                result = d1 - d2;
                break;
            }
        }
        System.out.println(d1 + " " + sign + " " + d2 + " = " + result);
        System.out.println(toString());
        return result;
//        calculatedResult = Double.valueOf(new DecimalFormat(".##").format(calculateResult));
    }

    public void saveResultInMemory() {
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
