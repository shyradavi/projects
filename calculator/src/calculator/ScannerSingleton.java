package calculator;

import java.util.Scanner;

class ScannerSingleton {
    private static Scanner instance = null;

    private ScannerSingleton() {
    }

    static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

    static void close() {
        if (instance != null) {
            instance.close();
        }
    }
}
