package Task20V2;

import sun.dc.path.PathException;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Downloader downloader = new Downloader();
        Scanner scan = new Scanner(System.in);
        String command;
        boolean exit = false;
        boolean correctData = false;
        showHelp();
        while (!exit){
            System.out.println("Enter command");
            command = scan.nextLine();
            switch (command){
                case "start":
                    if (downloader.isDownloading()){
                        System.out.println("Already downloading");
                        continue;
                    }
                    while (!correctData){
                        try {
                            System.out.println("Enter URI");
                            String uriString = scan.nextLine();
                            URI uri = new URI(uriString.trim());
                            System.out.println("Enter path to save file (without name)");
                            String pathToSaveString = scan.nextLine();
                            Path pathToSave = Paths.get(pathToSaveString);
                            pathToSave.toAbsolutePath().normalize();
                            if(Files.exists(pathToSave)){
                                if(Files.isDirectory(pathToSave)){
                                    System.out.println("Enter file name (with extension)");
                                    String fileName = scan.nextLine();
                                    while (Files.exists(Paths.get(pathToSave + "\\" + fileName))){
                                        System.out.println("File already exist, enter new name");
                                        fileName = scan.nextLine();
                                    }
                                    correctData = downloader.init(uri, pathToSave, fileName);
                                }else{
                                    throw new PathException("This is not directory");
                                }
                            }else{
                                throw new FileNotFoundException("File not found");
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (PathException e) {
                            System.out.println(e.getMessage());
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                    downloader.start();
                    System.out.println("Download start");
                    Thread.sleep(200);
                    break;

                case "progress":
                    if(downloader.isDownloading()){
                        System.out.print("Downloaded ");
                        System.out.printf("%.1f", downloader.showProgress());
                        System.out.println("%");
                        Thread.sleep(200);
                    }
                    else {
                        System.out.println("Download not started");
                    }
                    break;

                case "stop":
                    if(downloader.isDownloading()){
                        downloader.setStop();
                        System.out.println("Download stopped");
                    }
                    else {
                        System.out.println("Download not started");
                    }
                    Thread.sleep(200);
                    break;

                case "exit":
                    if(downloader.isDownloading()){
                        downloader.setStop();
                        System.out.println("Download stopped");
                    }
                    System.out.println("Bye");
                    exit = true;
                    break;

                case "help":
                    showHelp();
                    Thread.sleep(200);
                    break;
                default:
                    System.out.println("Unknown command, use \"help\"");
            }
        }
    }


    private static void showHelp(){
        System.out.println("Available commands - ");
        System.out.println("\"start\" - starts downloading file");
        System.out.println("\"progress\" - show download progress");
        System.out.println("\"stop\" - stop downloading file");
        System.out.println("\"exit\" - exit the program");
        System.out.println("\"help\" - show help");
        System.out.println();
    }
}


