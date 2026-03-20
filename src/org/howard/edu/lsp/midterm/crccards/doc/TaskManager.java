package org.howard.edu.lsp.midterm.crccards.doc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class TaskManager {

    private Map<String, Task> tasks;

    public TaskManager() {
        tasks = new LinkedHashMap<>();
    }

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException(
                "Task with ID '" + task.getTaskId() + "' already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }


    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
