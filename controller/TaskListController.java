package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Task;
import viewmodel.MainViewModel;

public class TaskListController {
    @FXML private ListView<Task> taskListView;

    private final MainViewModel viewModel = MainViewModel.getInstance();

    @FXML
    public void initialize() {
        taskListView.setItems(viewModel.getTaskListViewModel().getTasks());
        taskListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) setText(null);
                else setText(task.getTitle() + (task.isCompleted() ? " (Done)" : ""));
            }
        });
    }

    public void onRemoveSelected() {
        Task selected = taskListView.getSelectionModel().getSelectedItem();
        if (selected != null) viewModel.getTaskListViewModel().removeTask(selected);
    }

    public void onMarkCompleted() {
        Task selected = taskListView.getSelectionModel().getSelectedItem();
        if (selected != null) viewModel.getTaskListViewModel().markCompleted(selected);
    }
}