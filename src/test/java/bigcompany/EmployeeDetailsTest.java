package bigcompany;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDetailsTest {

    @Test
    public void testDefaultConstructor() {
        EmployeeDetails details = new EmployeeDetails();
        assertEquals(0.0, details.getSalaryDifferenece(), 0.0000);
        assertEquals(0, details.getDepth());
    }

    @Test
    public void testSetAndGetSalaryDifference() {
        EmployeeDetails details = new EmployeeDetails();
        details.setSalaryDifferenece(1500.75);
        assertEquals(1500.75, details.getSalaryDifferenece(), 0.0000);
    }

    @Test
    public void testSetAndGetDepth() {
        EmployeeDetails details = new EmployeeDetails();
        details.setDepth(3);
        assertEquals(3, details.getDepth());
    }

    @Test
    public void testToStringIncludesAllFields() {
        EmployeeDetails details = new EmployeeDetails();
        details.setSalaryDifferenece(2000.0);
        details.setDepth(2);
        details.setId("E123");
        details.setFirstName("John");
        details.setLastName("Doe");
        details.setSalary(50000.0);
        details.setManagerId("M456");

        String result = details.toString();
        assertTrue(result.contains("id='E123'"));
        assertTrue(result.contains("firstName='John'"));
        assertTrue(result.contains("lastName='Doe'"));
        assertTrue(result.contains("salary=50000.0"));
        assertTrue(result.contains("managerId='M456'"));
        assertTrue(result.contains("salaryDifferenece=2000.0"));
        assertTrue(result.contains("depth=2"));
    }
}