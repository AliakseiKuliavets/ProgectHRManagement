package hrProgect;

import java.util.ArrayList;
import java.util.List;

public class SetUp {
    public List<Employee> setUp(int n) {
        Generator generator = new Generator();
        List<Employee> employeeArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            employeeArrayList.add(generator.empGen());
        }
        return employeeArrayList;
    }
}
