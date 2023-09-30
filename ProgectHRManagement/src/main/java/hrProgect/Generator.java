package hrProgect;

import com.github.javafaker.Faker;
import hrProgect.enums.Department;
import hrProgect.enums.Grade;

import java.util.Random;

public class Generator {

    //рандомная генерация ID
    private String empIdGen() {
        Random random = new Random();
        int num = random.nextInt(10_000_000,99_999_999);
        return "EMP%" + num;
    }

    //рандомная генерация GRADE
    private Grade gradeRandom() {
        Grade[] myGrade = {
                Grade.A,
                Grade.B,
                Grade.C,
                Grade.D
        };
        int n = (int) (Math.random() * myGrade.length);
        return myGrade[n];
    }

    //рандомная генерация Department
    private Department departmentRandom() {
        Department[] myDepartment = {
                Department.HR,
                Department.FINANCE,
                Department.SALES,
                Department.ADMINISTRATION,
                Department.SECURITY
        };
        int n = (int) (Math.random() * myDepartment.length);
        return myDepartment[n];
    }

    //рандомная генерация Salary
    private double randomSalary() {
        Random random = new Random();
        //число умножаю на 10^n, где n равно количеству необходимых знаков после запятой.
        //после этого применяю какой нибудб метод класса Math для округления ну а после снова делю на 10^n
        double scale = Math.pow(10, 2);
        return Math.ceil(random.nextDouble(30_000) * scale) / scale;
    }

    //рандомная генерация BonusPCT
    private double randomPercent() {
        Random random = new Random();
        double scale = Math.pow(10, 2);
        return Math.ceil(random.nextDouble(100) * scale) / scale;
    }

    //рандомная генерация HasPlanBeenCompleted
    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public Employee empGen() {
        Faker faker = new Faker();

        String id = empIdGen();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        Grade grade = gradeRandom();
        Department department = departmentRandom();
        double salary = randomSalary();
        double bonusPCT = randomPercent();
        boolean hasPlanBeenCompleted = randomBoolean();

        return new Employee(id, name, surname, grade, department, salary, bonusPCT, hasPlanBeenCompleted);
    }
}
