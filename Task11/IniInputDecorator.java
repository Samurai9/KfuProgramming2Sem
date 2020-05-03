package Task11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class IniInputDecorator {
    private InputStreamReader input;

    public IniInputDecorator(InputStream input){
        this.input = new InputStreamReader(input);
    }

    public MyContainer readIni() throws IOException{
        StringBuilder key;
        StringBuilder value;
        try{
            key = new StringBuilder();
            value = new StringBuilder();
            int a;
            while ((a = input.read()) != '='){
                key.append((char)a);
            }
            while ((a = input.read()) != 10){
                value.append((char)a);
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        return new MyContainer(key.toString(), value.toString());
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
