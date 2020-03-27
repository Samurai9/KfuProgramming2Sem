package Task10;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DStudentInputDecorator extends InputStream {
    private DataInputStream in;

    public DStudentInputDecorator(InputStream in) {
        this.in = new DataInputStream(in);
    }

    public Student readStudent() throws IOException{
        StringBuilder name = new StringBuilder("");
        int year;
        StringBuilder group = new StringBuilder("");
        StringBuilder gender = new StringBuilder("");

        int pointer = 0;
        char chr;

        while ((chr = in.readChar()) != ' ' && pointer <= 15){
            name.append(chr);
            pointer++;
        }
        pointer = 0;

        year = in.readInt();
        in.readChar();

        while ((chr =in.readChar()) != ' ' && pointer <= 10){
            group.append(chr);
            pointer++;
        }
        pointer = 0;

        while ((chr = in.readChar()) != (char)13 && pointer <= 10){
            gender.append(chr);
            pointer++;
        }

        return new Student(name.toString(),year, group.toString(), gender.toString());
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return in.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return in.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }


}
