package work;

import employee.Employee;

public class Task {
    private  int taskId;
    private  String description;
    private  String deadline;
    private Project project; // Nhiệm vụ thuộc dự án nào
    private boolean isCompleted;

    public Task(int taskId, String description, String deadline, Project project) {
        this.taskId = taskId;
        this.description = description;
        this.deadline = deadline;
        this.project = project;
        this.isCompleted = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Project getProject() {
        return project;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public void displayTaskDetails() {
        System.out.println("Task ID: " + taskId + ", Description: " + description + ", Deadline: " + deadline +
                ", Project: " + (project != null ? project.getName() : "None") +
                ", Completed: " + isCompleted);
    }
}
