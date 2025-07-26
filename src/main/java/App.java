import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = App.loadEmployees("C:\\Users\\91984\\OneDrive\\Desktop\\JAVA\\git\\sample-test\\src\\main\\java\\employee.csv");
        System.out.println(employees);
    }

    public static List<Employee> loadEmployees(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Employee> employeesWithSalaryLessThan20PercentOfSubordinates(List<Employee> employees) {
        List<Employee> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
            double avgSubSalary = averageSalaryOfDirectSubordinates(employees, emp.getId());
            if (avgSubSalary > 0 && emp.getSalary() < 0.2 * avgSubSalary) {
                result.add(emp);
            }
        }
        return result;
    }

    public static List<Employee> employeesWithSalaryGreaterThan50PercentOfSubordinates(List<Employee> employees) {
        List<Employee> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
            double avgSubSalary = averageSalaryOfDirectSubordinates(employees, emp.getId());
            if (avgSubSalary > 0 && emp.getSalary() > 0.5 * avgSubSalary) {
                result.add(emp);
            }
        }
        return result;
    }

    public static List<Employee> employeesWithDepthGreaterThanFour(List<Employee> employees) {
        List<Employee> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
            int depth = getEmployeeDepth(employees, emp.getId());
            if (depth > 4) {
                result.add(emp);
            }
        }
        return result;
    }
    

    public static int getEmployeeDepth(List<Employee> employees, String employeeId) {
        Employee target = null;
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                target = emp;
                break;
            }
        }
        if (target == null) {
            return -1; // Employee not found
        }
        int depth = 0;
        String managerId = target.getManagerId();
        while (managerId != null) {
            boolean found = false;
            for (Employee emp : employees) {
                if (emp.getId() == managerId) {
                    depth++;
                    managerId = emp.getManagerId();
                    found = true;
                    break;
                }
            }
            if (!found) break; // Manager not found in list
        }
        return depth;
    }

    public static double averageSalaryOfDirectSubordinates(List<Employee> employees, String managerId) {
        int count = 0;
        double totalSalary = 0.0;
        for (Employee emp : employees) {
            if (managerId.equals(emp.getManagerId())) {
                totalSalary += emp.getSalary();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return totalSalary / count;
    }
}