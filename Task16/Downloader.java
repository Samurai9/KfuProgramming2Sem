package Task16;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Downloader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter you URI");
        String uriString = scan.nextLine();
        try {
            URI uri = new URI(uriString.trim());
            String pathString = "";
            boolean correctData = false;
            while (!correctData){
                System.out.println("Enter path to save (without name)");
                pathString = scan.nextLine();
                if(Files.exists(Paths.get(pathString))){
                    if (Files.isDirectory(Paths.get(pathString))){
                        correctData = true;
                    }
                    else{
                        System.out.println("This is not directory");
                    }
                }
                else{
                    System.out.println("Path is not exist");
                }

            }
            Path path = Paths.get(pathString).normalize();
            if(!path.isAbsolute()){
                path.toAbsolutePath();
            }

            String fileName = "";
            File file = new File(uriString.trim());
            fileName = file.getName();
            while(Files.exists(Paths.get(path.toString() + "\\" + fileName))){
                System.out.println("File with this name already exist, enter name (with extension)");
                fileName = scan.nextLine();
            }
            Path pathFile = Paths.get(path.toString() + "\\" + fileName);
            Files.createFile(pathFile);

            file = new File(pathFile.toString());
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos);
            InputStream in = uri.toURL().openConnection().getInputStream();
            int read = 0;
            while ((read = in.read()) != -1){
                bout.write(read);
            }
            bout.close();
            in.close();
            System.out.println("Download complete");

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
