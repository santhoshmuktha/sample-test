package bigcompany;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testDefaultConstructor() {
        Employee emp = new Employee();
        assertNull(emp.getId());
        assertNull(emp.getFirstName());
        assertNull(emp.getLastName());
        assertNull(emp.getSalary());
        assertNull(emp.getManagerId());
    }

    @Test
    public void testParameterizedConstructor() {
        Employee emp = new Employee("1", "John", "Doe", 50000.0, "100");
        assertEquals("1", emp.getId());
        assertEquals("John", emp.getFirstName());
        assertEquals("Doe", emp.getLastName());
        assertEquals(Double.valueOf(50000.0), emp.getSalary());
        assertEquals("100", emp.getManagerId());
    }

    @Test
    public void testSettersAndGetters() {
        Employee emp = new Employee();
        emp.setId("2");
        emp.setFirstName("Jane");
        emp.setLastName("Smith");
        emp.setSalary(60000.0);
        emp.setManagerId("200");

        assertEquals("2", emp.getId());
        assertEquals("Jane", emp.getFirstName());
        assertEquals("Smith", emp.getLastName());
        assertEquals(Double.valueOf(60000.0), emp.getSalary());
        assertEquals("200", emp.getManagerId());
    }

    @Test
    public void testToString() {
        Employee emp = new Employee("3", "Alice", "Brown", 70000.0, "300");
        String expected = "Employee{id='3', firstName='Alice', lastName='Brown', salary=70000.0, managerId='300'}";
        assertEquals(expected, emp.toString());
    }

    @Test
    public void testSetSalaryNull() {
        Employee emp = new Employee();
        emp.setSalary(null);
        assertNull(emp.getSalary());
    }
}