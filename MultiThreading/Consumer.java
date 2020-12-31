package MultiThreading;

public class Consumer implements Runnable {
    Q q;
    Consumer(Q q)
    {
        this.q = q;
        new Thread(this,"Consumer").start();
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0 ; i < 10 ; i++)
        {
            q.get();
        }

    }
    
}
