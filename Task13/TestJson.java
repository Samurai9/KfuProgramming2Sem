package Task13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestJson {
    public static void main(String[] args) throws IOException, StudentWasFoundException {
        Student a = new Student("Student", 20, "male", 99);

        JsonOutputStudentDecorator outputStudentDecorator = new JsonOutputStudentDecorator(new FileOutputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task13\\abc.txt"));
        outputStudentDecorator.writeStudent(a);

        JsonInputStudentDecorator inputDecorator = new JsonInputStudentDecorator(new FileInputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task13\\abc.txt"));
        Student abc = inputDecorator.readStudent();
        System.out.println("name - " + abc.getName());
        System.out.println("age - " + abc.getAge());
        System.out.println("gender - " + abc.getGender());
        System.out.println("points - " + abc.getPoints());
    }
}
