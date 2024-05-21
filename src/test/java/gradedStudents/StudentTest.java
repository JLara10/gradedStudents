package gradedStudents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void testGetExamScores() {
        ArrayList<Double> examScores;
        examScores = new ArrayList<>();
        Student student = new Student("Itachi","Uchiha",examScores);
        String expected = "Exam scores:\n";
        assertEquals(expected, student.getExamScore());
    }

    @Test
    public void testAddExamScore() {
        ArrayList<Double> examScores;
        examScores = new ArrayList<>();
        Student student = new Student("Monkey","Luffy",examScores);
        student.addExamScore(99.0);
        String expected = "Exam scores:\n\tExam 1 -> 99.0\n";
        assertEquals(expected, student.getExamScore());
    }

    @Test
    public void testSetExamScore() {
        ArrayList<Double> examScores;
        examScores = new ArrayList<>();
        Student student = new Student("Kamado","Tanjiro",examScores);
        student.addExamScore(90.0);
        student.addExamScore(85.5);
        student.setExamScore(2, 88.0);
        String expected = "Exam scores:\n\tExam 1 -> 90.0\n\tExam 2 -> 88.0\n";
        assertEquals(expected, student.getExamScore());
    }


    @Test
    public void testGetAverageExamScore() {
        ArrayList<Double> examScores;
        examScores = new ArrayList<>();
        Student student = new Student("Vinsmoke","Sanji",examScores);
        student.addExamScore(93.0);
        student.addExamScore(88.0);
        student.addExamScore(85.0);
        double expected = 88.67;
        assertEquals(expected, student.getAverageExamScores(), 0.01);
    }

}