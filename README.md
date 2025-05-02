# To-Do List

A simple desktop To-Do List built with JavaFX using the MVVM (Model-View-ViewModel) architecture.

![2025-05-02T08:38:01,060716345+05:30](https://github.com/user-attachments/assets/a9e456de-253d-4337-8060-a8418914e89c)

## Project Structure

```
todo_list
├── app                                 # Launched the JavaFX app
│   └── Main.java
├── controller                          # Event handlers for UI (JavaFX controllers)
│   ├── MainViewController.java
│   ├── TaskFormController.java
│   └── TaskListController.java
├── model                               # Core data strucutres (Tasks, TaskManager)
│   ├── Task.java
│   └── TaskManager.java
├── util                                # Helper interfaces (e.g., Action for undo)
│   └── Action.java
├── view                                # FXML files (UI Layout)
│   ├── MainView.fxml
│   ├── TaskForm.fxml
│   └── TaskList.fxml
└── viewmodel                           # Glue between UI and logic
    ├── MainViewModel.java
    ├── TaskFormViewModel.java
    └── TaskListViewModel.java
```
- app - Launch point.
- controller - JavaFX controllers that wire up buttons and UI events.
- model - The actual data and logic. Task, TaskManager, and UndoManager live here.
- util - For extras like Action used in undo functionality.
- view - Just the UI skeleton, i.e., all the layout stuff in FXML.
- viewmodel - Exposes logic to the view while keeping it dumb. Middleman between model and view.

## What It Does?

- Add tasks with a title, description, and due date.
- View all tasks in a list.
- Mark tasks as completed.
- Remove selected tasks.
- Undo the last action (add/remove/complete).

## Why MVVM?

The Model-View-ViewModel (MVVM) is used to,
- Keep UI, logic, and data handling separated.
- Make the code easier to maintain and expand.
- Avoid everything turning into a giant tangle of mess.

## How To Run

- Clone the repo.
- Open in an IDE with JavaFX support (e.g., IntelliJ, VS Code).
- Make sure your build setup includes JavaFX libraries.
- Run app/Main.java.

## Dependencies

- Java 17
