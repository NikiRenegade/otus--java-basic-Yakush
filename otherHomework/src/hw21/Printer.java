package hw21;

public class Printer {
    private final Object monitor = new Object();
    private int state = 0;

    public void print(char symbol, int symbolState) throws InterruptedException {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    if (state == 3) {
                        state = 0;
                    }
                    while (state != symbolState) {
                        monitor.wait();
                    }
                    System.out.print(symbol);
                    state++;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
