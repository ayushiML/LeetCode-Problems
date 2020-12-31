package MultiThreading;

import java.util.concurrent.Semaphore;

public class Q
   {   int item;
    //acquire() blocks if necessary until a permit is available, and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer.
    //Throws:
//InterruptedException - if the current thread is interrupted
//IllegalArgumentException - if permits is negative
    static Semaphore semCon = new Semaphore(0); 
  
    static Semaphore semProd = new Semaphore(1); 
  
    // to get an item from buffer 
    void get() 
    { 
        try { 
            // Before consumer can consume an item, 
            // it must acquire a permit from semCon 
            semCon.acquire(); 
        } 
        catch (InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
  
        // consumer consuming an item 
        System.out.println("Consumer consumed item : " + item); 
  
        // After consumer consumes the item, 
        // it releases semProd to notify producer 
        semProd.release(); 
    } 
  
    // to put an item in buffer 
    void put(int item) 
    { 
        try { 
            // Before producer can produce an item, 
            // it must acquire a permit from semProd 
            semProd.acquire(); 
        } 
        catch (InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
  
        // producer producing an item 
        this.item = item; 
  
        System.out.println("Producer produced item : " + item); 
  
        // After producer produces the item, 
        // it releases semCon to notify consumer 
        semCon.release(); 
    } 
   }
