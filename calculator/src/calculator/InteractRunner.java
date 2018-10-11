package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InteractRunner {
    void start() {
        Calculator calculator = new Calculator();

        while (true) {
            calculator.setNumber1(getNumberFromScanner("first"));
            calculator.setNumber2(getNumberFromScanner("second"));
            calculator.setSign(getSignFromScanner());

            calculator.calculateResult();
            System.out.println(calculator.toString());
            
            while ("y".equals(getAnswer("Do you want memory operations?"))) {
                saveInMemory(calculator);

                if ("y".equals(getAnswer("Calculate result with memory?"))) {
                    calculator.setSign(getSignFromScanner());
                    calculator.calculateResultWithMemory();

                    saveInMemory(calculator);
                }

                if ("y".equals(getAnswer("Calculate number with memory?"))) {
                    calculator.setNumber1(getNumberFromScanner(""));
                    calculator.setSign(getSignFromScanner());
                    calculator.calculateNumberWithMemory();

                    saveInMemory(calculator);
                }
            }

            if (!"n".equals(getAnswer("Exit?"))) {
                break;
            }
        }

        ScannerSingleton.close();
    }


    private void saveInMemory(Calculator calculator) {
        if ("y".equals(getAnswer("Save result in memory?"))) {
            calculator.saveResultInMemory();
            System.out.println(calculator);
        }
    }

    private String getAnswer(String question) {
        System.out.println("\n" + question + " y/n");
        return ScannerSingleton.getInstance().nextLine();
    }

    private double getNumberFromScanner(String number) {
        Scanner sc = ScannerSingleton.getInstance();
        while (true) {
            System.out.println("Enter the " + number + " number");
            String str = sc.nextLine();
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Error, \"" + str + "\" is not a number, try again");
            }
        }
    }

    private String getSignFromScanner() {
        Scanner sc = ScannerSingleton.getInstance();
        while (true) {
            System.out.println("Enter the operation sign(*,/,+,-)");
            String sign = sc.nextLine();
            if (toMatchMathematicsSign(sign)) {
                return sign;
            }
            System.out.println("Error, \"" + sign + "\" is not a operation sign, try again");
        }
    }

    public boolean toMatchMathematicsSign(String str) {
        boolean result = false;
        if (str.length() == 1) {
            final String MATH_SIGN_PATTERN = "[*/+-]";
            if (Pattern.compile(MATH_SIGN_PATTERN).matcher(str).find()) {
                result = true;
            }
        }
        return result;
    }
}
