package employee;

import work.Department;
import work.Project;
import work.Task;

import java.util.ArrayList;
import java.util.List;


public class EmployeeManager {
    public List<Employee> employees;
    public List<Department> departments;
    public List<Project> projects;
    public List<Task> tasks;
    public EmployeeManager() {
        tasks = new ArrayList<>();
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        projects = new ArrayList<>();
    }

    // Quản lý nhân viên
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployeeById(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Quản lý phòng ban
    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Department findDepartmentById(int id) {
        for (Department department : departments) {
            if (department.getDepartmentId() == id) {
                return department;
            }
        }
        return null;
    }

    // Quản lý dự án
    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project findProjectById(int id) {
        for (Project project : projects) {
            if (project.getProjectId() == id) {
                return project;
            }
        }
        return null;
    }
    // Quản lý Task
    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksByProject(int projectId) {
        List<Task> projectTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getProject().getProjectId() == projectId) {
                projectTasks.add(task);
            }
        }
        return projectTasks;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}