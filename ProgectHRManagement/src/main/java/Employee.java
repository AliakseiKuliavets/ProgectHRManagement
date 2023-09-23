import enums.Department;
import enums.Grade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String id;
    private String name;
    private String surname;
    private Grade grade;
    private Department department;
    private double salary;
    private double bonusPCT;
    private boolean hasPlanBeenCompleted;
    public Employee(
            String id,
            String name,
            String surname,
            Grade grade,
            Department department,
            double salary,
            double bonusPCT,
            boolean hasPlanBeenCompleted
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.department = department;
        this.salary = salary;
        this.bonusPCT = bonusPCT;
        this.hasPlanBeenCompleted = hasPlanBeenCompleted;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                ", department=" + department +
                ", salary=" + salary +
                ", bonusPCT=" + bonusPCT +
                ", hasPlanBeenCompleted=" + hasPlanBeenCompleted +
                '}';
    }
}
