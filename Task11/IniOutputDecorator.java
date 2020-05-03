package Task11;

import Task13.Student;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class IniOutputDecorator {
    private OutputStreamWriter output;
    private ArrayList<Student> keys;

    public IniOutputDecorator(OutputStream output){
        this.output = new OutputStreamWriter(output);
    }

    public void writeIni(String key, String value) throws IOException {
        try {
            if(keys.contains(key)){
               throw new IOException("Key already exist");
            }
            output.write(key + "=" + value + "\n");
            output.flush();
        }
        catch (IOException ex){
            throw new IOException("Can't write");
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
