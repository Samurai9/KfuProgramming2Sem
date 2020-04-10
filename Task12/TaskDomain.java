package Task12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskDomain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern domain = Pattern.compile("([.]\\w+)");
        Matcher domainMatch = domain.matcher(text);

        while (domainMatch.find()){
            System.out.println(text.substring(domainMatch.start(), domainMatch.end()));
        }
    }
}
