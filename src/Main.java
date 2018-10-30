import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public int identifier = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        BlockingQueue<TaskItem> queue = new LinkedBlockingDeque<>(Arrays.asList(
                new TaskItem("a", 1200, task()),
                new TaskItem("b", 1600, task()),
                new TaskItem("c", 1300, task())
        ));

        System.out.println("Task deployed");

        QueueWorker queueWorker = new QueueWorker(queue);
        executor.execute(queueWorker);
        queue.add(new TaskItem("d", 1100, task()));

    }

    public static Consumer<Integer> task() {
        return delay -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
