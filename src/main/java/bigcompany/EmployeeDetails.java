package bigcompany;
public class EmployeeDetails extends Employee{
    
    double salaryDifferenece;
    int depth;

    public EmployeeDetails() {
        super();
    }

    public double getSalaryDifferenece() {
        return salaryDifferenece;
    }

    public void setSalaryDifferenece(double salaryDifferenece) {
        this.salaryDifferenece = salaryDifferenece;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", salary=" + getSalary() +
                ", managerId='" + getManagerId() + '\'' +
                ", salaryDifferenece=" + salaryDifferenece +
                ", depth=" + depth +
                '}';
    }
}
