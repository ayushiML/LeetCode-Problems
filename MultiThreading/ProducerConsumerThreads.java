package MultiThreading;

import java.util.LinkedList;

public class ProducerConsumerThreads {
    public static void main(String[] args) throws InterruptedException{
        PC pc = new PC();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run()
            {
               try{
                  pc.produce();
               }catch(InterruptedException e){
                  e.printStackTrace();
               }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run()
            {
               try{
                  pc.consume();
               }catch(InterruptedException e){
                  e.printStackTrace();
               }
            }
        });
        t1.start();
        t2.start();
        
        
        
    }
    public static class PC
    {
        //Queuue buffer
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;


        public void produce() throws InterruptedException
        {
            int value = 0 ;
            while(true)
            {
                synchronized(this)
                {
                    while(list.size() == capacity)
                    {
                        wait();
                    }
                    System.out.println("Producer produces" + value);
                        list.add(value++);
                        notify();// notify consumer that it is ready to be consumed 
                        Thread.sleep(1000);

                }
            }
        }
        public void consume() throws InterruptedException
        {
           while(true)
           {
               synchronized(this)
               {
                   while(list.size() == 0)
                   wait();
                   int val = list.removeFirst();
                   System.out.println("consumed :" +val);
                   notify();
                   Thread.sleep(1000);

               }
           }
        }
    }

}
