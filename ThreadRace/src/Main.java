public class Main {
    public static void main(String[] args) throws InterruptedException {
        Process proc = new Process();

        Thread t1 = new Thread(proc);
        Thread t2 = new Thread(proc);
        Thread t3 = new Thread(proc);
        Thread t4 = new Thread(proc);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

        System.out.println("TEKLER: " + Process.odds.size());
        System.out.println("ÇİFTLER: " + Process.evens.size());

    }
}