
public class Exthread extends Thread {
    String threadName = "hello";
    
    public Exthread() {}
    
    public Exthread(String threadName) {
        this.threadName = threadName;
    }
    
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(threadName + Integer.toString(i));
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        /* Create a Thread object and start and join the thread
         * 
         * */
        Exthread thread1 = new Exthread();
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
        
        Exthread thread2 = new Exthread("Thread1 ");
        Exthread thread3 = new Exthread("Thread2 ");
        Exthread thread4 = new Exthread("Thread3 ");
        thread2.start();
        thread3.start();
        thread4.start();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
