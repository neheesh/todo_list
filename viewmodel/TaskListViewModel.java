package viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Task;
import model.TaskManager;

import java.util.Stack;

public class TaskListViewModel {
    private final TaskManager taskManager;
    private final ObservableList<Task> tasks;
    private final Stack<Runnable> undoStack;

    public TaskListViewModel(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.tasks = FXCollections.observableArrayList(taskManager.getAllTasks());
        this.undoStack = new Stack<>();
    }
    
    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        taskManager.addTask(task);
        tasks.add(task);
        undoStack.push(() -> {
            taskManager.removeTask(task.getId());
            tasks.remove(task);
        });
    }

    public void removeTask(Task task) {
        taskManager.removeTask(task.getId());
        tasks.remove(task);
        undoStack.push(() -> {
            taskManager.addTask(task);
            tasks.add(task);
        });
    }

    public void markCompleted(Task task) {
        boolean prevStatus = task.isCompleted();
        task.setCompleted(true);
        undoStack.push(() -> task.setCompleted(prevStatus));
    }

    public boolean undoLastAction() {
        if (!undoStack.isEmpty()) {
            undoStack.pop().run();
            return true;
        }
        return false;
    }

    public int taskCount() {
        return tasks.size();
    }
}