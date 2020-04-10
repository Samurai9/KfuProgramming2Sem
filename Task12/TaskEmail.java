package Task12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskEmail {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Pattern lowerDomain = Pattern.compile("@[\\w]+");
        Pattern upperDomain = Pattern.compile("\\.\\w+$");

        Matcher lowerMatch = lowerDomain.matcher(text);
        Matcher upperMatch = upperDomain.matcher(text);

        if (text.matches("^([\\w\\-\\_]+)@(([\\w\\-\\_\\.]+)$)")){
            while (lowerMatch.find()) {
                System.out.print(text.substring(lowerMatch.start(), lowerMatch.end()) + " ");
            }
            System.out.println();
            while (upperMatch.find()){
                System.out.print(text.substring(upperMatch.start(), upperMatch.end()) + " ");
            }
        }
        else{
            System.out.println("No email here");
        }
    }
}
