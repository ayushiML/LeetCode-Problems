package MultiThreading;

public class Producer implements Runnable {
    Q q;
    Producer(Q q)
    {
        this.q = q;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0 ; i < 10 ; i ++)
         q.put(i);

    }

    
}
