package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        presentedCourseList.add(this);
        this.id = presentedCourseList.size();
    }

    public static PresentedCourse findById(int ID) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == ID) {
                return presentedCourse;
            }
        }
        return null;
    }

    public void addStudent(int studentId) {
        if (studentIds.size() < capacity) {
            studentIds.add(studentId);
        } else {
            System.out.printf("the class is full!");
        }
    }
}

