package bigcompany;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the employee CSV file.");
            return;
        }
        App.findEmpployeeDEtails(args[0]);
       
    }

    public static void findEmpployeeDEtails(String employeeFilePath){
         List<Employee> employees = App.loadEmployees(employeeFilePath);
        List<EmployeeDetails> salaryLessThan20Percent = App.employeesWithSalaryLessThan20PercentOfSubordinates(employees);
        System.out.println("####### which managers earn less than they should, and by how much #######");
        // System.out.println(salaryLessThan20Percent);

         for (EmployeeDetails emp : salaryLessThan20Percent) {
            System.out.println(emp.getId() + " - "+ emp.getFirstName() + " " + emp.getLastName() + " earns " + emp.getSalary() + " which is less by " + emp.getSalaryDifferenece() + " than the benchmark");
        }



        System.out.println();
        System.out.println();

        List<EmployeeDetails> salaryGreaterThan50Percent = App.employeesWithSalaryGreaterThan50PercentOfSubordinates(employees);
        System.out.println("####### which managers earn more than they should, and by how much #######");

        //System.out.println(salaryGreaterThan50Percent);
        for (EmployeeDetails emp : salaryGreaterThan50Percent) {
            System.out.println(emp.getId() + " - "+ emp.getFirstName() + " " + emp.getLastName() + " earns " + emp.getSalary() + " which is more by " + emp.getSalaryDifferenece() + " than the benchmark");
        }

        System.out.println();
        System.out.println();

        List<EmployeeDetails> depthGreaterThanFour = App.employeesWithDepthGreaterThanFour(employees);
        System.out.println("####### which employees have a reporting line which is too long, and by how much #######");
        //System.out.println(depthGreaterThanFour);
         for (EmployeeDetails emp : depthGreaterThanFour) {
            System.out.println(emp.getId() + " - "+ emp.getFirstName() + " " + emp.getLastName() + " has a depth of  " + emp.getDepth() + " which is more than the benchmark");
        }

        System.out.println();
        System.out.println();
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

    public static List<EmployeeDetails> employeesWithSalaryLessThan20PercentOfSubordinates(List<Employee> employees) {
        List<EmployeeDetails> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
            EmployeeDetails eDetails = new EmployeeDetails();
            eDetails.setId(emp.getId());
            eDetails.setFirstName(emp.getFirstName());
            eDetails.setLastName(emp.getLastName());
            eDetails.setSalary(emp.getSalary());
            eDetails.setManagerId(emp.getManagerId());

            double avgSubSalary = averageSalaryOfDirectSubordinates(employees, emp.getId());
            if (avgSubSalary > 0 && emp.getSalary() < 1.2 * avgSubSalary) {
               
                eDetails.setSalaryDifferenece(emp.getSalary()- 1.2 * avgSubSalary);
                result.add(eDetails);
            }
        }
        return result;
    }

    public static List<EmployeeDetails> employeesWithSalaryGreaterThan50PercentOfSubordinates(List<Employee> employees) {
        List<EmployeeDetails> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
            EmployeeDetails eDetails = new EmployeeDetails();
            eDetails.setId(emp.getId());
            eDetails.setFirstName(emp.getFirstName());
            eDetails.setLastName(emp.getLastName());
            eDetails.setSalary(emp.getSalary());
            eDetails.setManagerId(emp.getManagerId());

            double avgSubSalary = averageSalaryOfDirectSubordinates(employees, emp.getId());
            if (avgSubSalary > 0 && emp.getSalary() > 1.5 * avgSubSalary) {
                eDetails.setSalaryDifferenece(emp.getSalary() - 1.5 * avgSubSalary);
                result.add(eDetails);
            }
        }
        return result;
    }

    public static List<EmployeeDetails> employeesWithDepthGreaterThanFour(List<Employee> employees) {
        List<EmployeeDetails> result = new java.util.ArrayList<>();
        for (Employee emp : employees) {
                EmployeeDetails eDetails = new EmployeeDetails();
                eDetails.setId(emp.getId());
                eDetails.setFirstName(emp.getFirstName());
                eDetails.setLastName(emp.getLastName());
                eDetails.setSalary(emp.getSalary());
                eDetails.setManagerId(emp.getManagerId());

            int depth = getEmployeeDepth(employees, emp.getId());
            if (depth > 4) {
                eDetails.setDepth(depth);
                result.add(eDetails);
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
        while (managerId != null && !managerId.equals("")) {
            boolean found = false;
            for (Employee emp : employees) {
                if (managerId.equalsIgnoreCase(emp.getId())) {
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