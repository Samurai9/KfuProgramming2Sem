package Task13;

public class Student {
    private String name;
    private int age;
    private String gender;
    private int points;

    public Student(String name, int age, String gender, int points) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getPoints() {
        return points;
    }
}

