import base.Person;
import uni.*;

import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person ghazal = new Person("ghazal" , "0212654788");
        Person nima = new Person("nima" , "0365954785");
        Person mozhde = new Person("mozhde" , "0312665488");
        Person amin = new Person("amin" , "0315654785");
        Person tina = new Person("tina" , "0415987211");



        Major cs = new Major("computer science" , 100);
        Major math = new Major("mathematics" , 100);

        Student ghazalStu = new Student(ghazal.id, 1401, cs.id);
        Student nimaStu = new Student(nima.id, 1400, cs.id);
        Student tinaStu = new Student(tina.id, 1402, math.id);

        Student[] helper = new Student[] {ghazalStu, nimaStu, tinaStu};

        Professor aminPro = new Professor(amin.id, cs.id);
        Professor mozhdePro = new Professor(mozhde.id, cs.id);

        Course chemistry = new Course("chemistry" , 4);
        Course physics = new Course("physics" , 4);
        Course geometry = new Course("geometry" , 4);

        PresentedCourse chemistryCourse = new PresentedCourse(chemistry.id, aminPro.id, 50);
        PresentedCourse physicsCourse = new PresentedCourse(physics.id, aminPro.id, 50);
        PresentedCourse geometryCourse = new PresentedCourse(geometry.id, mozhdePro.id, 50);

        chemistryCourse.addStudent(ghazalStu.id);
        chemistryCourse.addStudent(nima.id);
        physicsCourse.addStudent(ghazalStu.id);
        physicsCourse.addStudent(nimaStu.id);
        physicsCourse.addStudent(tinaStu.id);
        geometryCourse.addStudent(tinaStu.id);

        for (Student p : helper) {
            Person person = Person.findByID(p.personID);
            System.out.println(person.name + " : " + p.studentID);
        }
        System.out.println("----------------------");
        System.out.println(amin.name + " : " + aminPro.id);
        System.out.println(mozhde.name + " : " + mozhdePro.id);

        Transcript ghazalTranscript = new Transcript(ghazalStu.id);
        Transcript nimaTranscript = new Transcript(nimaStu.id);
        Transcript tinaTranscript = new Transcript(tinaStu.id);

        ghazalTranscript.setGrade(chemistryCourse.courseID, 20);
        ghazalTranscript.setGrade(physicsCourse.courseID, 19);
        nimaTranscript.setGrade(chemistryCourse.courseID, 17);
        nimaTranscript.setGrade(physicsCourse.courseID, 16);
        tinaTranscript.setGrade(geometryCourse.courseID, 20);
        tinaTranscript.setGrade(physicsCourse.courseID, 18);
        System.out.println("=================");


        ghazalTranscript.printTranscript();
        System.out.println("=================");
        nimaTranscript.printTranscript();
        System.out.println("=================");
        tinaTranscript.printTranscript();
        System.out.println("=================");

        System.out.println(ghazal.name + " : " + ghazalTranscript.getGPA());
        System.out.println(nima.name + " : " + nimaTranscript.getGPA());
        System.out.println(tina.name + " : " + tinaTranscript.getGPA());
    }
}