import enums.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private String id;
    private String name;
    private String surname;
    private Grade grade;
    private double salary;
    private double bonusPCT;
    private boolean hasPlanBeenCompleted;

}
