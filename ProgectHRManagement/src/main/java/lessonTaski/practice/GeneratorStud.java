package lessonTaski.practice;

import com.github.javafaker.Faker;
import lessonTaski.practice.enums.Grade;

import java.util.*;

public class GeneratorStud {
    private String studentIdGen() {
        Random random = new Random();
        int num = random.nextInt(10_000_000, 99_999_999);
        return "EMP%" + num;
    }

    private Grade gradeRandom() {
        Grade[] myGrade = {
                Grade.A,
                Grade.B,
                Grade.C,
                Grade.D,
                Grade.F
        };
        int n = (int) (Math.random() * myGrade.length);
        return myGrade[n];
    }

    private int randomAge() {
        Random random = new Random();
        return random.nextInt(25);
    }

    private List<Course> courceRanomList(int n) {
        CourseGen courseGen = new CourseGen();

        List<Course> randomCourses = new ArrayList<>(courseGen.getCourseList());
        Collections.shuffle(randomCourses);

        int count = Math.min(3, randomCourses.size());
        List<Course> selectedCourses = randomCourses.subList(0, count);
        return selectedCourses;
    }

    public Student genStud() {
        Faker faker = new Faker();

        String id = studentIdGen();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = randomAge();
        Grade grade = gradeRandom();
        List<Course> courses = courceRanomList(3);

        return new Student(id, name, lastName, age, grade, courses);
    }
}
