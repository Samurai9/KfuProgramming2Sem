package Task10;

import java.io.*;

public class OStudentOutputDecorator extends OutputStream {
    private ObjectOutputStream out;

    public OStudentOutputDecorator(OutputStream out) throws IOException {
        this.out = new ObjectOutputStream(out);
    }

    public void writeStudent(Student student) throws IOException {
        out.writeObject(student);
    }

    public void writeObject(Object obj) throws IOException {
        out.writeObject(obj);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
