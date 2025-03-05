package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int enteranceYear, int majorID) {
        this.personID = personID;
        this.enteranceYear = enteranceYear;
        this.majorID = majorID;
        studentList.add(this);
        this.id = studentList.size();
        setStudentCode();
    }

    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public void setStudentCode() {
        if(this.majorID < 10 && studentList.size() < 10) {
            this.studentID = String.valueOf(enteranceYear) + "0" + String.valueOf(majorID) + "0" + String.valueOf(id);
        }
        else if(this.majorID < 10) {
            this.studentID = String.valueOf(enteranceYear) + "0" + String.valueOf(majorID) + String.valueOf(id);
        }
        else if(studentList.size() < 10) {
            this.studentID = String.valueOf(enteranceYear) + String.valueOf(majorID) + "0" + String.valueOf(id);
        }
        else {
            this.studentID = String.valueOf(enteranceYear) + String.valueOf(majorID) + String.valueOf(id);
        }
    }
}
