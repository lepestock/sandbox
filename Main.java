
public class Main {
    private static final long MAIN_TIMEOUT = 2000; // 2 seconds
    private static final long DAEMON_TIMEOUT = 10000; // 10 seconds

    private static final Runnable daemon = () -> {
        try {
            System.out.printf("Daemon sleeps for %,d millis%n", DAEMON_TIMEOUT);
            Thread.sleep(DAEMON_TIMEOUT);
        } catch (Exception e) {
            System.out.println("Daemon caught an exception: " + e);
        } finally {
            System.out.println("Daemon executes the finally block");
        }
    };

    public static void main(String[] args) {
        Thread daemonThread = new Thread(daemon);
        daemonThread.setDaemon(true);
        daemonThread.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook has been invoked");
        }));

        try {
            System.out.printf("Main thread sleeps for %,d millis%n", MAIN_TIMEOUT);
            Thread.sleep(MAIN_TIMEOUT);
        } catch (InterruptedException ignored) {};

        System.out.println("Main thread exits");
    }
}
