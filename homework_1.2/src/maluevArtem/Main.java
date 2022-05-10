package maluevArtem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    static final int NUMBER_THREADS = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<String> callable_1 = new MyCallable("1");
        Callable<String> callable_2 = new MyCallable("2");
        Callable<String> callable_3 = new MyCallable("3");

        List<Callable<String>> invocationList = new ArrayList<>();
        invocationList.add(callable_1);
        invocationList.add(callable_2);
        invocationList.add(callable_3);

        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_THREADS);

        List<Future<String>> task = threadPool.invokeAll(invocationList);

        for (Future<String> t : task) {
            System.out.println(t.get());
        }

        System.out.println();

        String singleTask = threadPool.invokeAny(invocationList);
        System.out.println(singleTask);

        threadPool.shutdown();
    }
}
