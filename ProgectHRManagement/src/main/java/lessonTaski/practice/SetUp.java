package lessonTaski.practice;


import java.util.ArrayList;
import java.util.List;

public class SetUp {
    public List<Student> setUpStudent(int n) {
        GeneratorStud generatorStud = new GeneratorStud();
        List<Student> employeeArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            employeeArrayList.add(generatorStud.genStud());
        }
        return employeeArrayList;
    }
}
