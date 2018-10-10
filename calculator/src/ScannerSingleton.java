import java.util.Scanner;

public class ScannerSingleton {
    public static Scanner instance = null;

    private ScannerSingleton() {}

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

    public static void close(){
        if(instance!=null){
            instance.close();
        }
    }
}
