package Task7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Vowels {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String vowels = "уеэоаыяиюё";
        set.add("привет");
        set.add("абв");
        set.add("аоеыи");
        set.add("ыаложфывлсф");
        System.out.println(set.stream().filter(chars1 -> chars1.chars().filter(chars2 -> vowels.indexOf(chars2) != -1).count()>3).collect(Collectors.toList()));
    }
}
