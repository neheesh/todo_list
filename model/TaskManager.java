package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class TaskManager {
    private final Map<String, Task> taskMap;

    public TaskManager() {
        taskMap = new HashMap<>();
    }

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task getTask(String id) {
        return taskMap.get(id);
    }

    public void removeTask(String id) {
        taskMap.remove(id);
    }

    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }

    public boolean markCompleted(String id) {
        Task task = taskMap.get(id);
        if (task != null) {
            task.setCompleted(true);
            return true;
        }
        return false;
    }

    public boolean contains(String id) {
        return taskMap.containsKey(id);
    }

    public int count() {
        return taskMap.size();
    }

}

