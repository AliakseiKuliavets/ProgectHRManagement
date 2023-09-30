package lessonTaski.practice;

import lessonTaski.practice.enums.Grade;

import java.util.List;


public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private int age;
    private Grade grades;
    private List<Course> courses;

    public Student(String id, String firstName, String lastName, int age, Grade grades, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grades = grades;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                ", courses=" + courses +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrades() {
        return grades;
    }

    public void setGrades(Grade grades) {
        this.grades = grades;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
