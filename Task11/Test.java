package Task11;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        IniOutputDecorator output = new IniOutputDecorator(new FileOutputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task11\\abc.txt"));
        output.writeIni("key", "value");
        output.writeIni("key1", "value1");
        output.writeIni("key", "value");

        MyContainer container;
        IniInputDecorator input = new IniInputDecorator(new FileInputStream("D:\\Desktop\\Tasks\\Repositories\\KfuProject2SemV2\\src\\Task11\\abc.txt"));
        container = input.readIni();
        System.out.println(container.getKey() + " = " + container.getValue());
        container = input.readIni();
        System.out.println(container.getKey() + " = " + container.getValue());
        container = input.readIni();
        System.out.println(container.getKey() + " = " + container.getValue());
    }
}
