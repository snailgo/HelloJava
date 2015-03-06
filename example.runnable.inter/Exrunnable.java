/*
 * This is a example to show how to use runnable interface.
 * Here is what this class is going to do
 * 
 * 1. Implement runnable interface to count number
 * 2. Main thread pass an argument into every thread
 * 3. print out number
 * 
 * 
 * 
 * Runnable is a interface with one function.
 * Thread is better way to create a thread object.
 * */


public class Exrunnable implements Runnable{

    String threadName = "hello";
    
    public Exrunnable() {}
    
    public Exrunnable(String threadName) {
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(threadName + Integer.toString(i));
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        /* Create a thread and run 
         * 
         * This could run the thread, but it don't have join(), start(), etc 
         * 
         * */
        Exrunnable run0 = new Exrunnable();
        run0.run();
        Thread.sleep(1000);
        
        /* Create a Thread object and start and join the thread
         * 
         * */
        Exrunnable run1 = new Exrunnable();
        Thread thread1 = new Thread(run1);
        thread1.start();
        if(thread1.isAlive()) {
            System.out.println("one thread is running");
        }
        thread1.join();
        
        /*
         * Pass variable into thread
         * 
         * If computer is too fast, increase the number of loop
         * such that you can see the disorder of output.
         * */
        
        Thread thread2 = new Thread(new Exrunnable("Thread1 "));
        Thread thread3 = new Thread(new Exrunnable("Thread2 "));
        Thread thread4 = new Thread(new Exrunnable("Thread3 "));
        thread2.start();
        thread3.start();
        thread4.start();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
