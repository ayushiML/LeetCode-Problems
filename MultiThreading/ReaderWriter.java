package MultiThreading;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
    // when reader has priority over writer 
    public static void main(String[] args) {
        //ReaderWriter rd = new ReaderWriter();
        Q q = new Q();

        new Consumer(q);
        new Producer(q);

    }
   
}
