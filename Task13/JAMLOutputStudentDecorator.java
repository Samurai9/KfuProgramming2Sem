package Task13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class JAMLOutputStudentDecorator {
    private OutputStreamWriter output;
    private ArrayList<Student> allStudents;

    public JAMLOutputStudentDecorator(OutputStream output){
        this.output = new OutputStreamWriter(output);
    }

    public void writeStudent(Student student) throws IOException, StudentWasFoundException {
        try {
            if(allStudents.contains(student)){
                throw new StudentWasFoundException();
            }
            output.write("Student: \n");
            output.write("\tname: " + student.getName() + "\n");
            output.write("\tage: " + student.getAge() + "\n");
            output.write("\tgender: " + student.getGender() + "\n");
            output.write("\tpoints: " + student.getPoints() + "\n");
            allStudents.add(student);
            output.flush();
        }
         catch (StudentWasFoundException ex) {
            throw new StudentWasFoundException();
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    public String getEncoding() {
        return output.getEncoding();
    }

    public void write(int c) throws IOException {
        output.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        output.write(cbuf, off, len);
    }

    public void write(String str, int off, int len) throws IOException {
        output.write(str, off, len);
    }

    public void flush() throws IOException {
        output.flush();
    }

    public void close() throws IOException {
        output.close();
    }

    public void write(char[] cbuf) throws IOException {
        output.write(cbuf);
    }

    public void write(String str) throws IOException {
        output.write(str);
    }

    public Writer append(CharSequence csq) throws IOException {
        return output.append(csq);
    }

    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return output.append(csq, start, end);
    }

    public Writer append(char c) throws IOException {
        return output.append(c);
    }
}
