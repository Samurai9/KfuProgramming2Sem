package Task13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestJAML {
    public static void main(String[] args) throws IOException, StudentWasFoundException{
        JAMLOutputStudentDecorator outputStudentDecorator = new JAMLOutputStudentDecorator(new FileOutputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task13\\JAML.txt"));
        Student a = new Student("Student", 20, "male", 99);
        outputStudentDecorator.writeStudent(a);


        JAMLInputStudentDecorator inputDecorator = new JAMLInputStudentDecorator(new FileInputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task13\\JAML.txt"));
        Student abc = inputDecorator.readStudent();
        System.out.println("name - " + abc.getName());
        System.out.println("age - " + abc.getAge());
        System.out.println("gender - " + abc.getGender());
        System.out.println("points - " + abc.getPoints());
    }
}
