package Task10;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class OStudentInputDecorator extends InputStream {
    private ObjectInputStream in;

    public OStudentInputDecorator(InputStream in) throws IOException {
        this.in = new ObjectInputStream(new DataInputStream(in));
    }

    public Student readStudent() throws IOException, ClassNotFoundException{
        try {
            return (Student) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(e.getMessage());
        }
        catch (IOException e){
            throw new IOException(e.getMessage());
        }
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
    public long skip(long n) throws IOException {
        return in.skip(n);
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
