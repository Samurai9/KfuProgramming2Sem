package Task13;

import org.omg.IOP.IOR;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class JAMLInputStudentDecorator {
    private InputStreamReader input;

    public JAMLInputStudentDecorator(InputStream input){
        this.input = new InputStreamReader(input);
    }

    public Student readStudent() throws IOException {
        StringBuilder name;
        StringBuilder age;
        StringBuilder gender;
        StringBuilder points;
        try{
            name = new StringBuilder();
            age = new StringBuilder();
            gender = new StringBuilder();
            points = new StringBuilder();

            int a;
            while ((a = input.read()) != ':');

            while ((a = input.read()) != ':');
            input.read();
            while ((a = input.read()) != 10){
                name.append((char)a);
            }

            while ((a = input.read()) != ':');
            input.read();
            while ((a = input.read()) != 10){
                age.append((char)a);
            }

            while ((a = input.read()) != ':');
            input.read();
            while ((a = input.read()) != 10){
                gender.append((char)a);
            }

            while ((a = input.read()) != ':');
            input.read();
            while ((a = input.read()) != 10){
                points.append((char)a);
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        return new Student(name.toString(), Integer.parseInt(age.toString()), gender.toString(), Integer.parseInt(points.toString()));
    }

    public String getEncoding() {
        return input.getEncoding();
    }

    public int read() throws IOException {
        return input.read();
    }

    public int read(char[] cbuf, int offset, int length) throws IOException {
        return input.read(cbuf, offset, length);
    }

    public boolean ready() throws IOException {
        return input.ready();
    }

    public void close() throws IOException {
        input.close();
    }

    public int read(CharBuffer target) throws IOException {
        return input.read(target);
    }

    public int read(char[] cbuf) throws IOException {
        return input.read(cbuf);
    }

    public long skip(long n) throws IOException {
        return input.skip(n);
    }

    public boolean markSupported() {
        return input.markSupported();
    }

    public void mark(int readAheadLimit) throws IOException {
        input.mark(readAheadLimit);
    }

    public void reset() throws IOException {
        input.reset();
    }
}
