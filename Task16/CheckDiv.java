package Task16;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.*;

public class CheckDiv {
    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter URI");
            String uriString = scan.nextLine();
            URI uri = new URI(uriString.trim());
            BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }

            Pattern pattern = Pattern.compile("(<div)");
            Matcher matcher = pattern.matcher(sb);
            int count = 0;
            while (matcher.find()){
                count++;
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
