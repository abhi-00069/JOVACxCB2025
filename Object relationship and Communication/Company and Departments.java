import java.util.ArrayList;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void showDepartment() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            e.showInfo();
        }
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    public void dissolveCompany() {
        departments.clear(); 
        System.out.println("Company " + name + " has been dissolved.");
    }
}

public class CompanyCompositionDemo {
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        Department devDept = new Department("Development");
        devDept.addEmployee("Alice");
        devDept.addEmployee("Bob");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Charlie");

        techCorp.addDepartment(devDept);
        techCorp.addDepartment(hrDept);

        techCorp.showCompanyStructure();

        techCorp.dissolveCompany();
    }
}
