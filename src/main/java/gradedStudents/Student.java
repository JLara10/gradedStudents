package gradedStudents;
import java.util.ArrayList;
public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(testScores);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScore() {
        StringBuilder score = new StringBuilder();
        score.append("Exam scores:\n");//concatenation
        int examNumber = 1;
        for (Double scores : examScores) {
            score.append("\tExam ").append(examNumber).append(" -> ").append(scores).append("\n");
            examNumber++;
        }
        return score.toString();
    }
    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }
    public void setExamScore(int examNumber, double newScore) {
        if (examNumber >= 1 && examNumber <= examScores.size()) {
            examScores.set(examNumber - 1, newScore);
        } else {
            System.out.println("Invalid exam number!");
        }
    }
    public double getAverageExamScores(){
        double sum = 0;
        for (double score : examScores) {
            sum += score;
        }
        double average = sum / examScores.size();
        return Double.parseDouble(String.format("%.2f", average));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("Average Score: ").append(getAverageExamScores()).append("\n");
        sb.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("Exam ").append(i + 1).append(" -> ").append(examScores.get(i)).append("\n");
        }
        return sb.toString();
    }
}
