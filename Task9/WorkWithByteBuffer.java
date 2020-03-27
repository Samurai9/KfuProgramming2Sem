package Task9;


import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class WorkWithByteBuffer {
    File file = new File("D:\\Desktop\\Tasks\\Repositories\\KfuTasks2Sem\\src\\Task9\\abc.txt");

    public boolean write(Collection<Student> students) {
        try (FileOutputStream out = new FileOutputStream(file)) {
            ByteBuffer bb;
            Student tempStud;
            char chr;
            Iterator<Student> iterator = students.iterator();

            while (iterator.hasNext()) {
                tempStud = iterator.next();

                //Name
                for (int i = 0; i < tempStud.getName().length(); i++) {
                    bb = ByteBuffer.allocate(2);
                    bb.putChar(tempStud.getName().charAt(i));
                    out.write(bb.array());
                }
                bb = ByteBuffer.allocate(2);
                bb.putChar(' ');
                out.write(bb.array());

                //Year
                bb = ByteBuffer.allocate(4);
                bb.putInt(tempStud.getYear());
                out.write(bb.array());
                bb = ByteBuffer.allocate(2);
                bb.putChar(' ');
                out.write(bb.array());

                //Group
                for (int i = 0; i < tempStud.getGroup().length(); i++) {
                    bb = ByteBuffer.allocate(2);
                    bb.putChar(tempStud.getGroup().charAt(i));
                    out.write(bb.array());
                }
                bb = ByteBuffer.allocate(2);
                bb.putChar(' ');
                out.write(bb.array());

                //Gender
                for (int i = 0; i < tempStud.getGender().length(); i++) {
                    bb = ByteBuffer.allocate(2);
                    bb.putChar(tempStud.getGender().charAt(i));
                    out.write(bb.array());
                }
                bb = ByteBuffer.allocate(2);
                bb.putChar((char) 13);
                out.write(bb.array());
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
        return true;
    }

    public Collection<Student> read(File file) {
        LinkedList<Student> students = new LinkedList<>();
        int a = 0;
        try (FileInputStream in = new FileInputStream(file)) {
            while ((a = in.read()) != -1) {
                StringBuilder name = new StringBuilder("");
                int year = 0;
                StringBuilder group = new StringBuilder("");
                StringBuilder gender = new StringBuilder("");

                //Name
                ByteBuffer bb = ByteBuffer.allocate(2);
                bb.put((byte) a);
                bb.put((byte) in.read());
                bb.rewind();
                int counter = 0;
                while ((counter <= 10) && ((bb.getChar() != ' '))) {
                    bb.rewind();
                    name.append(bb.getChar());

                    bb = ByteBuffer.allocate(2);
                    bb.put((byte) in.read());
                    bb.put((byte) in.read());
                    bb.rewind();
                    counter++;
                }

                //Year
                bb = ByteBuffer.allocate(4);
                bb.put((byte) in.read());
                bb.put((byte) in.read());
                bb.put((byte) in.read());
                bb.put((byte) in.read());
                bb.rewind();
                year = bb.getInt();

                //Group
                bb = ByteBuffer.allocate(2);
                bb.put((byte) in.read());
                bb.put((byte) in.read());
                bb.rewind();
                counter = 0;
                while ((counter <= 10) && ((bb.getChar() != ' '))) {
                    bb.rewind();
                    group.append(bb.getChar());

                    bb = ByteBuffer.allocate(2);
                    bb.put((byte) in.read());
                    bb.put((byte) in.read());
                    bb.rewind();
                    counter++;
                }

                //Gender
                bb = ByteBuffer.allocate(2);
                bb.put((byte) in.read());
                bb.put((byte) in.read());
                bb.rewind();
                counter = 0;
                while ((counter<=10) && bb.getChar() != 13) {
                    bb.rewind();
                    gender.append(bb.getChar());
                    
                    bb = ByteBuffer.allocate(2);
                    bb.put((byte) in.read());
                    bb.put((byte) in.read());
                    bb.rewind();
                    counter++;
                }

                students.add(new Student(name.toString(), year, group.toString(), gender.toString()));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return students;
    }

    public static void main(String[] args) {
        WorkWithByteBuffer w = new WorkWithByteBuffer();
        Student student1 = new Student("stud1", 20, "902", "male");
        Student student2 = new Student("stud2", 20, "902", "male");
        Student student3 = new Student("stud3", 20, "902", "male");
        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        w.write(students);


        File file = new File("D:\\Desktop\\Tasks\\Repositories\\KfuTasks2Sem\\src\\Task9\\abc.txt");
        LinkedList<Student> stud = (LinkedList<Student>) w.read(file);
        for (Student x : stud) {
            System.out.println(x.getName() + " " + x.getYear() + " " + x.getGroup() + " " + x.getGender());
        }
    }
}
