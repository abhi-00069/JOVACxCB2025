interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: ₹" + baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary(); 
    }

    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Abhishek", 50000);
        Employee e2 = new PartTimeEmployee(102, "Ravi", 500, 40);

        ((Department) e1).assignDepartment("Engineering");
        ((Department) e2).assignDepartment("Support");

        Employee[] employees = {e1, e2};

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Salary: ₹" + emp.calculateSalary());
            System.out.println(((Department) emp).getDepartmentDetails());
            System.out.println();
        }
    }
}
