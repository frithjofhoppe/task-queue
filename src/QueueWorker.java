import java.util.concurrent.BlockingQueue;

public class QueueWorker implements Runnable{

    private BlockingQueue<TaskItem> queue;

    public QueueWorker(BlockingQueue<TaskItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                TaskItem item = queue.take();
                System.out.println(String.format("QueueWorker -> Task %s, Took", item.identifier));
                performOperation(item);
            } catch (InterruptedException e) {
                System.out.println("QueueWorker -> Not item found");
                e.printStackTrace();
            }
        }
    }



    private void performOperation(TaskItem  taskItem){
        taskItem.function.accept(taskItem.valueToApply);
        System.out.println(String.format("QueueWorker -> Task %s, Performed", taskItem.identifier));
    }
}
