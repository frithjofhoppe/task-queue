import java.util.function.Consumer;
import java.util.function.Function;

public class TaskItem {
    String identifier;
    int valueToApply;
    Consumer<Integer> function;

    public TaskItem(String identifier, int valueToApply, Consumer<Integer> function) {
        this.identifier = identifier;
        this.valueToApply = valueToApply;
        this.function = function;
    }
}
