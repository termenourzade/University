package uni;

import java.util.*;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse temp = PresentedCourse.findById(presentedCourseID);
        if (temp.studentIds.contains(studentID)) {
            transcript.put(temp.id, grade);
        } else {
            System.out.printf("the student does not participate in this class!");
        }
    }

    public void printTranscript() {
        for (Map.Entry<Integer, Double> entry : transcript.entrySet()) {
            Course course = Course.findByID(entry.getKey());
            if (course != null) {
                System.out.println(course.title + " : " + entry.getValue());
            }
        }
    }

    public double getGPA() {
        double sum = 0;
        int units = 0;
        for (Map.Entry<Integer, Double> entry : transcript.entrySet()) {
            Course course = Course.findByID(entry.getKey());
            sum += entry.getValue() * course.units;
            units += course.units;
        }
        sum /= units;
        return sum;
    }
}
