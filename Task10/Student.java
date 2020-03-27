package Task10;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int year;
    private String group;
    private String gender;

    public Student(String name, int year, String group, String gender) {
        this.name = name;
        this.year = year;
        this.group = group;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String  getGroup() {
        return group;
    }

    public String getGender() {
        return gender;
    }
}
