package work;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private  int projectId;
    private String name;
    private String deadline;
    private Department department; // Phòng ban phụ trách dự án
    private List<Task> tasks; // Dự án có các nhiệm vụ liên quan

    public Project(int projectId, String name, String deadline, Department department) {
        this.projectId = projectId;
        this.name = name;
        this.deadline = deadline;
        this.department = department;
        this.tasks = new ArrayList<>();
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
