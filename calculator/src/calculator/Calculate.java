package calculator;

class Calculate {
    Calculate() {
    }

    double calculate(double d1, double d2, String sign) {
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
        return result;
    }
}

//        calculatedResult = Double.valueOf(new DecimalFormat(".##").format(calculateResult));