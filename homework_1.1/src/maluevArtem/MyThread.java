package maluevArtem;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.println("Поток " + Thread.currentThread().getName() + ": Привет!");
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        finally {
            System.out.println("Поток " + Thread.currentThread().getName() + " завершен");
        }
    }
}
