package maluevArtem;

public class Main {

    static final String THREAD_GROUP_NAME = "group";

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup(THREAD_GROUP_NAME);
        Thread myThread = new MyThread();

        Thread thread_1 = new Thread(group, myThread);
        Thread thread_2 = new Thread(group, myThread);
        Thread thread_3 = new Thread(group, myThread);

        thread_1.setName(ThreadName.RED.name());
        thread_2.setName(ThreadName.BLACK.name());
        thread_3.setName(ThreadName.WHITE.name());

        thread_1.start();
        thread_2.start();
        thread_3.start();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.interrupt();

    }
}
