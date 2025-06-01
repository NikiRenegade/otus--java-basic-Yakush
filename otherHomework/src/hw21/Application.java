package hw21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        char[] printSymbols = {'A', 'B', 'C'};
        for (int i = 0; i < printSymbols.length; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    printer.print(printSymbols[finalI], finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();

    }
}
