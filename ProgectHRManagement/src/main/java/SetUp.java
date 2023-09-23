import java.util.ArrayList;
import java.util.List;

public class SetUp {
    public List<Employee> setUp() {
        Generator generator = new Generator();
        List<Employee> employeeArrayList= new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            employeeArrayList.add(generator.empGen());
        }
        return employeeArrayList;
    }
}
