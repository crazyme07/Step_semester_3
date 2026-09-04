class EmployeeM5 {

    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Week3_HW_M5 {

    public static void main(String[] args) {

        EmployeeM5 employee1 =
                new EmployeeM5("Ravi", 50000);

        EmployeeM5 employee2 =
                new EmployeeM5("Meera", 55000);

        EmployeeM5 employee3 =
                new EmployeeM5("Karthik", 60000);

        EmployeeM5.printCompanyInfo();
    }
}