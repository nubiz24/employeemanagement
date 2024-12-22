package employee;

import work.Department;

// Lớp Manager
public class Manager extends Employee {
    private double bonus;

    public Manager(int id, String name, double baseSalary, String phone, String email, Department department, double bonus) {
        super(id, name, baseSalary, phone, email, department);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}


