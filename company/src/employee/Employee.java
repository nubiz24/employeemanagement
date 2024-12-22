package employee;

import work.Department;

public abstract class Employee {
    private  int id;
    private  String name;
    private double baseSalary;
    private String phone; // Sửa thành String
    private String email;
    private Department department;

    // Constructor
    public Employee(int id, String name, double baseSalary, String phone, String email, Department department) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department; // Sửa dòng này
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPhone() { // Thay đổi kiểu trả về
        return phone;
    }

    public void setPhone(String phone) { // Thay đổi kiểu tham số
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Base Salary: " + baseSalary + ", Total Salary: " + calculateSalary());
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}


