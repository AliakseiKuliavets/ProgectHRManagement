package lessonTaski.practice;


public class Course {
    private String courseId;
    private String courseName;
    private String courseDescription;
    private int courseCredits;
    private Student studentsEnrolled;
    private String gradeBook;

    public Course(String courseId,
                  String courseName,
                  String courseDescription,
                  int courseCredits,
                  Student studentsEnrolled,
                  String gradeBook) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
        this.studentsEnrolled = studentsEnrolled;
        this.gradeBook = gradeBook;
    }

    public Course(String courseId, String courseName, String courseDescription, int courseCredits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseCredits=" + courseCredits +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public Student getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(Student studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public String getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(String gradeBook) {
        this.gradeBook = gradeBook;
    }
}
