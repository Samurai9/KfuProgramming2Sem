package Task19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteInConsoleAnyCharset {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String pathString = null;
        boolean correctData = false;
        while(!correctData){
            System.out.println("Enter path");
            pathString = scan.nextLine();
            if(Files.exists(Paths.get(pathString))){
                if(!Files.isDirectory(Paths.get(pathString))){
                    correctData = true;
                }
                else{
                    System.out.println("It's directory");
                }
            }
            else{
                System.out.println("File not found");
            }
        }
        Path path = Paths.get(pathString);
        path.normalize();
        if(!path.isAbsolute()){
            path.toAbsolutePath();
        }

        System.out.println("Enter Charset");
        String charset = scan.nextLine();
        InputStreamReader osr = new InputStreamReader(new FileInputStream(pathString), charset);
        int a = 0;
        while ((a = osr.read()) != -1){
            System.out.print((char)a);
        }
    }
}
