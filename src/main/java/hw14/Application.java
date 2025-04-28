package hw14;

public class Application {
    public static void main(String[] args) throws InterruptedException{
        ManyThread();
        OneThread();
    }

    public static void OneThread() {
        double[] array = new double[100_000_000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время (один поток): " + (endTime - startTime));
    }
    public static void ManyThread() throws InterruptedException {
        int arrayCount = 100_000_000;
        int threadCount = 4;
        Thread[] threads = new Thread[threadCount];
        double[] array = new double[arrayCount];
        long startTime = System.currentTimeMillis();
        for (int t = 0; t < 4; t++) {
            final int finalT = t;
            threads[t] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = arrayCount / threadCount * finalT; i < arrayCount / threadCount * (finalT + 1) ; i++) {
                        array[i] = 1.14 * Math.cos(i) * Math.sin(i) * Math.cos(i / 1.2);
                    }
                }
            });
            threads[t].start();

        }
        for (int t = 0; t < 4; t++) {
            threads[t].join();
            System.out.println("Поток " +  t + " завершен в " + System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время (четыре потока): " + (endTime - startTime));
    }
}
