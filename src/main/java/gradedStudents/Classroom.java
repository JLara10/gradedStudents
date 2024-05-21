package gradedStudents;

import java.util.Arrays;
import java.util.List;

public class Classroom {
    private Student[] students;


    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] students){
        this.students = students;
    }
    public Classroom(){
       this.students = new Student[30];
    }


    public double getAverageExamScore(){
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                sum += student.getAverageExamScores();
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        } else {
            return 0;
        }

    }
    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }
    public void removeStudent(String firstName, String lastName){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getFirstName().equals(firstName)
                    && students[i].getLastName().equals(lastName)) {
                students[i] = null;
                // Re-order the array
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                    students[j + 1] = null;
                }
                return;
            }
        }
    }
    public Student[] getStudentsByScore(){
        List<Student> studentList = Arrays.asList(students);
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.getAverageExamScores(), s1.getAverageExamScores());
            if (compare == 0) {
                compare = s1.getLastName().compareTo(s2.getLastName());
                if (compare == 0) {
                    compare = s1.getFirstName().compareTo(s2.getFirstName());
                }
            }
            return compare;
        });
        return studentList.toArray(new Student[0]);
    }

    @Override
    public String toString() {
        return "Students in class\n" + Arrays.toString(students);
    }
}
