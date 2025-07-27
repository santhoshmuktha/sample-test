public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String managerId;
    public Employee() {
        super();
    }
public Employee(String id, String firstName, String lastName, Double salary, String managerId) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.managerId = managerId;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public Double getSalary() {
    return salary;
}

public void setSalary(Double salary) {
    this.salary = salary;
}

public String getManagerId() {
    return managerId;
}

public void setManagerId(String managerId) {
    this.managerId = managerId;
}

@Override
public String toString() {
    return "Employee{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            ", managerId='" + managerId + '\'' +
            '}';
}
}
