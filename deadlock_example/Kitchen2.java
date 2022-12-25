// https://www.linkedin.com/learning/advanced-java-programming-2/avoiding-thread-deadlock?autoplay=true
package deadlock_example;

public class Kitchen2{

public static Object spoon = new Object();
public static Object bowl = new Object();

public static void main(String[] args){
    
    Thread cook1 = new Thread(() -> {
    synchronized(spoon) {
            System.out.println("Cook 1: holding the spoon...");
            System.out.println("Cook 1: waiting for the bowl...");

            synchronized (bowl){
                System.out.println("Cook 1: holding the spoon and the bowl.");
            }
        }
}

    ); // end cook1 Thread

        Thread cook2 = new Thread(() -> {
                synchronized(spoon) {
            System.out.println("Cook 1: holding the spoon...");
            System.out.println("Cook 1: waiting for the bowl...");

            synchronized (bowl){
                System.out.println("Cook 1: holding the spoon and the bowl.");
            }
        }
    synchronized(spoon) {
            System.out.println("Cook 1: holding the spoon...");
            System.out.println("");

            synchronized (bowl){
                System.out.println("Cook 1: holding the spoon and the bowl.");
            }
        }
}

    ); // end cook2 Thread

    cook1.start();
    cook2.start();

} // end main method

} // end class Main