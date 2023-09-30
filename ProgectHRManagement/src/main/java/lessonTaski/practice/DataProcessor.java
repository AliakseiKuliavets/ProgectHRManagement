package lessonTaski.practice;

import java.util.*;

public class DataProcessor {
    private final List<Student> studentList;
    private final Set<Course> courseSet;

    public DataProcessor(List<Student> studentList, Set<Course> courseSet) {
        this.studentList = studentList;
        this.courseSet = courseSet;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }
    //Метод, который вычисляет
    //средний балл для каждого студента и возвращает результат в виде отображения (Map).
    public Map<Student, Double> calculateClassAverage() {
        Map<Student, Double> averageCreditsMap = new HashMap<>();

        for (Student student : studentList) {
            double totalCredits = 0;
            int courseCount = 0;

            for (Course course : student.getCourses()) {
                totalCredits += course.getCourseCredits();
                courseCount++;
            }

            double averageCredits = courseCount > 0 ? totalCredits / courseCount : 0;
            averageCreditsMap.put(student, averageCredits);
        }
        return averageCreditsMap;
    }
}
