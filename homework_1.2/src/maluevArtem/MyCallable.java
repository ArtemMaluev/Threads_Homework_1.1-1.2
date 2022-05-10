package maluevArtem;

import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<String> {

    private final String task;

    public MyCallable(String task) {
        this.task = task;
    }

    @Override
    public String call() throws Exception {
        int result = 0;
        try {
            while (result != 5) {
                Thread.sleep(1000);
                System.out.println("Поток " + Thread.currentThread().getName() + " выполняет Задачу " + task);
                result++;
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        finally {
            Thread.sleep(1000);
            System.out.println(">>> Поток " + Thread.currentThread().getName() + " завершен");
        }
        return "Количество сообщений для Задачи " + task + ": " + result;
    }
}
