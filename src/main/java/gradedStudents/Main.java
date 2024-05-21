package gradedStudents;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores;
        examScores = new ArrayList<>();
        examScores.add(78.0);
        examScores.add(98.0);
        examScores.add(84.0);
        examScores.add(91.0);

        Student student = new Student(firstName, lastName, examScores);
        Classroom classroom  = new Classroom();
        classroom.addStudent(student);

        student.addExamScore(92.0);
        student.setExamScore(1, 150.0);
        String output = student.getExamScore();

        System.out.println(student);
        System.out.println(classroom);

    }
}

