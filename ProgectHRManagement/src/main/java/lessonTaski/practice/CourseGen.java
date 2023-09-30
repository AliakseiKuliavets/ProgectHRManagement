package lessonTaski.practice;

import java.util.HashSet;
import java.util.Set;

public class CourseGen {
    private Set<Course> courseList() {
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(new Course("EMP1234", "Algebra", "Its math", 10));
        courseSet.add(new Course("EMP1234", "BIOLOGY", "Its BIOLOGY", 23));
        courseSet.add(new Course("EMP2321314", "CHEMISTRY", "Its CHEMISTRY", 15));
        courseSet.add(new Course("EMP111234", "GEOGRAPHY", "Its GEOGRAPHY", 32));
        courseSet.add(new Course("EMP123334", "GEOMETRY", "Its GEOMETRY", 12));
        courseSet.add(new Course("EMP12234", "HISTORY", "Its HISTORY", 5));
        courseSet.add(new Course("EMP1234654", "LITERATURE", "Its LITERATURE", 11));
        return courseSet;
    }

    public Set<Course> getCourseList() {
        return courseList();
    }
}
