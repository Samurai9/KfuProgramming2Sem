package Task8;

import java.io.*;
import java.util.Random;

public class WriteIntChar {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        int number = 53456;
        char symbol = 'ф';
        try (FileOutputStream out = new FileOutputStream("D:\\Desktop\\Tasks\\Repositories\\KfuTasks2Sem\\src\\Task8\\cde.txt")) {
            out.write(number>>24);
            out.write(number>>16);
            out.write(number>>8);
            out.write(number>>0);
            out.flush();

            out.write(0);
            out.write(((int) symbol)>>8);
            out.write(((int) symbol)>>0);
            out.flush();
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
