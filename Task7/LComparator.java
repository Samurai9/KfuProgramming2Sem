package Task7;

import java.util.Arrays;

public class LComparator {
    //Human;
    private int age;

    public LComparator(int age){
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        LComparator a = new LComparator(20);
        LComparator b = new LComparator(25);
        LComparator c = new LComparator(15);
        LComparator d = new LComparator(16);
        LComparator[] humans = new LComparator[] {a,b,c,d};
        Arrays.sort(humans, (o1, o2) -> o1.getAge() - o2.getAge());
        for(LComparator h : humans){
            System.out.println(h.getAge());
        }
    }
}
