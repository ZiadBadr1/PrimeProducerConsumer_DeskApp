import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class Consumer extends Thread {
    buffer buf;
    private int n;
    Producer prod;
    ArrayList<String> arr[] ;

    public Consumer(buffer buf, int n,Producer prod) {
        this.buf = buf;
        this.prod = prod;
        this.n = n;
        n = prod.getN();
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            String x= String.valueOf(buf.consume());
            arr[i]=x;
//            System.out.println(buf.consume());
            try {
                FileWriter myWriter = new FileWriter("Primeoutput.txt");
                myWriter.write(x);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}


/*
 *
 *
 *
 *
 * */