package laba2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class storage {
    static int max = 10;
    static BlockingQueue queue = new LinkedBlockingQueue(max);
    public static void main(String[] args) {
        Prod prod = new Prod();
        Cons cons = new Cons();
        prod.start();
        cons.start();
    }

    static class Prod extends Thread {
        Random random = new Random();
        public void run() {
            while(true){
                int element = random.nextInt(max);
                try{
                    Thread.sleep(100);
                    queue.put(element);
                    System.out.println("Производитель " + String.valueOf(element));
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Cons extends Thread {
        public void run() {
            while(true) {
                try{
                    Thread.sleep(100);
                    System.out.println("Потребитель" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
