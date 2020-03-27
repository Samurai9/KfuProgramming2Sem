package Task10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DStudentOutputDecorator extends OutputStream {
    private DataOutputStream out;

    public DStudentOutputDecorator(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    public void writeStudent(Student student) throws IOException {
        out.writeChars(student.getName());
        out.writeChar(' ');
        out.writeInt(student.getYear());
        out.writeChar(' ');
        out.writeChars(student.getGroup());
        out.writeChar(' ');
        out.writeChars(student.getGender());
        out.writeChar(13);
    }

    @Override
    public void write(int b) throws IOException {
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

    public void writeBoolean(boolean v) throws IOException {
        out.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        out.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        out.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        out.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        out.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        out.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        out.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        out.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        out.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        out.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        out.writeUTF(str);
    }

    public int size() {
        return out.size();
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
