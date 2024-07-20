import java.util.concurrent.*;

public class FutureExample {

    private int sharedResource = 0;
    private final Object lock = new Object();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureExample example = new FutureExample();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Void> future1 = executorService.submit(example.new IncrementTask());
        Future<Void> future2 = executorService.submit(example.new IncrementTask());

        future1.get();
        future2.get();

        executorService.shutdown();

        System.out.println("Final value of sharedResource: " + example.sharedResource);
    }

    class IncrementTask implements Callable<Void> {
        @Override
        public Void call() {
            for (int i = 0; i < 1000; i++) {
                //synchronized (lock) {
                    sharedResource++;
                //}
            }
            return null;
        }
    }
}

