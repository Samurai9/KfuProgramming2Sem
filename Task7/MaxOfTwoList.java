package Task7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class MaxOfTwoList {


    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            first.add(random.nextInt(10));
            second.add(random.nextInt(20));
        }

        for (int i = 0; i < first.size(); i++) {
            System.out.print(first.get(i) + ", ");
        }
        System.out.println();

        for (int i = 0; i < second.size(); i++) {
            System.out.print(second.get(i) + ", ");
        }
        System.out.println();

        Integer max = first.stream().max(Integer::compareTo).get();
        System.out.println(max);
        System.out.println(second.stream().filter((a) -> a>max).collect(Collectors.toList()));

    }
}
