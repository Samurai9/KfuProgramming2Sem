package Task8;

import java.io.*;

public class ReadIntChar {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        try (FileInputStream in = new FileInputStream("D:\\Desktop\\Tasks\\Repositories\\KfuTasks2Sem\\src\\Task8\\cde.txt")) {
            int integer = 0;
            int number;
            char symbol;

            integer = (in.read()<<24)|integer;
            integer = (in.read()<<16)|integer;
            integer = (in.read()<<8)|integer;
            integer = (in.read()<<0)|integer;
            number = integer;

            integer = 0;
            integer = (in.read()<<8)|integer;
            integer = (in.read()<<0)|integer;
            symbol = (char) integer;

            System.out.println(number);
            System.out.println(symbol);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
