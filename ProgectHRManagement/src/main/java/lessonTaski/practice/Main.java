package lessonTaski.practice;

public class Main {
    public static void main(String[] args) {
        SetUp set = new SetUp();
        CourseGen courseGen = new CourseGen();

        DataProcessor dataProcessor = new DataProcessor(set.setUpStudent(1),courseGen.getCourseList());
        System.out.println(dataProcessor.getCourseSet());
        System.out.println(dataProcessor.getStudentList());
        System.out.println(dataProcessor.calculateClassAverage());
    }
}
