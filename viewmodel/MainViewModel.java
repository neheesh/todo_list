package viewmodel;

import model.TaskManager;

public class MainViewModel {
    private static MainViewModel instance;
    private final TaskManager taskManager;
    private final TaskListViewModel taskListViewModel;
    private final TaskFormViewModel taskFormViewModel;

    public MainViewModel() {
        taskManager = new TaskManager();
        taskListViewModel = new TaskListViewModel(taskManager);
        taskFormViewModel = new TaskFormViewModel(taskManager);
        instance = this;
    }

    public static MainViewModel getInstance() {
        return instance;
    }

    public TaskListViewModel getTaskListViewModel() {
        return taskListViewModel;
    }

    public TaskFormViewModel getTaskFormViewModel() {
        return taskFormViewModel;
    }

    public void undoLastAction() {
        taskListViewModel.undoLastAction();
    }
}