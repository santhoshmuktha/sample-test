import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class AppTest {

    @Test
    public void testLoadEmployeesReturnsList() {
        // Since this method reads from a file, we can only check for null or not null.
        // You may want to mock file reading for a more robust test.
        List<Employee> employees = App.loadEmployees("src/test/resources/test_employees.csv");
        assertNotNull(employees);
    }

    @Test
    public void testAverageSalaryOfDirectSubordinates() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "A", "B", 100.0, ""),
            new Employee("2", "C", "D", 200.0, "1"),
            new Employee("3", "E", "F", 300.0, "1"),
            new Employee("4", "G", "H", 400.0, "2")
        );
        double avg = App.averageSalaryOfDirectSubordinates(employees, "1");
        assertEquals(250.0, avg, 0.001);
    }

    @Test
    public void testEmployeesWithSalaryLessThan20PercentOfSubordinates() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "A", "B", 100.0, ""),
            new Employee("2", "C", "D", 200.0, "1"),
            new Employee("3", "E", "F", 300.0, "1")
        );
        List<EmployeeDetails> result = App.employeesWithSalaryLessThan20PercentOfSubordinates(employees);
        assertFalse(result.isEmpty());
        assertEquals("1", result.get(0).getId());
        assertEquals("-200.000000", String.format("%.6f", result.get(0).getSalaryDifferenece()));
    }

    @Test
    public void testEmployeesWithSalaryGreaterThan50PercentOfSubordinates() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "A", "B", 1000.0, ""),
            new Employee("2", "C", "D", 200.0, "1"),
            new Employee("3", "E", "F", 300.0, "1")
        );
        List<EmployeeDetails> result = App.employeesWithSalaryGreaterThan50PercentOfSubordinates(employees);
        assertFalse(result.isEmpty());
        assertEquals("1", result.get(0).getId());
        assertEquals("625.000000", String.format("%.6f", result.get(0).getSalaryDifferenece()));
    }

    @Test
    public void testEmployeesWithDepthGreaterThanFour() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "A", "B", 100.0, ""),
            new Employee("2", "C", "D", 200.0, "1"),
            new Employee("3", "E", "F", 300.0, "2"),
            new Employee("4", "G", "H", 400.0, "3"),
            new Employee("5", "I", "J", 500.0, "4"),
            new Employee("6", "K", "L", 600.0, "5")
        );
        List<EmployeeDetails> result = App.employeesWithDepthGreaterThanFour(employees);
        assertFalse(result.isEmpty());
        assertEquals("6", result.get(0).getId());
    }

    @Test
    public void testGetEmployeeDepth() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "A", "B", 100.0, ""),
            new Employee("2", "C", "D", 200.0, "1"),
            new Employee("3", "E", "F", 300.0, "2"),
            new Employee("4", "G", "H", 400.0, "3")
        );
        int depth = App.getEmployeeDepth(employees, "4");
        assertEquals(3, depth);
        int notFound = App.getEmployeeDepth(employees, "999");
        assertEquals(-1, notFound);
    }
}