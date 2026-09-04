class EmployeeM3 {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    EmployeeM3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    EmployeeM3(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName
                + " | Rs " + salary
                + " | Intern: " + isIntern);
    }
}

public class Week3_HW_M3 {

    public static void main(String[] args) {

        EmployeeM3 permanent =
                new EmployeeM3("E-101", "Divya", 65000);

        EmployeeM3 intern =
                new EmployeeM3("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}