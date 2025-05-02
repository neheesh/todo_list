package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Task;
import viewmodel.MainViewModel;

import java.time.LocalDate;
import java.util.UUID;

public class TaskFormController {
    @FXML private TextField titleField;
    @FXML private TextField descField;
    @FXML private DatePicker dueDatePicker;

    private final MainViewModel viewModel = MainViewModel.getInstance();

    public void onAddTask() {
        String id = UUID.randomUUID().toString();
        String title = titleField.getText();
        String desc = descField.getText();
        LocalDate due = dueDatePicker.getValue();

        if (title.isEmpty() || due == null) return;
        Task task = new Task(id, title, desc, due);
        viewModel.getTaskListViewModel().addTask(task);

        titleField.clear();
        descField.clear();
        dueDatePicker.setValue(null);
    }
}