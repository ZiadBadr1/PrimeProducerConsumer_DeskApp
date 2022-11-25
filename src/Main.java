import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static buffer buf = new buffer();

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter N: ");
        int n = myObj.nextInt();  // Read user input
//            System.out.println("Enter Buffer Size: ");
//            int buffer = myObj.nextInt();
        Producer P = new Producer(buf,n);
        Consumer C = new Consumer(buf, n, P);
        P.start();
        C.start();
    }
}

