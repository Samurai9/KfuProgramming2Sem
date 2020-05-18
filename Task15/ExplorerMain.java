package Task15;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ExplorerMain {
    Explorer explorer;
    public static void main(String[] args) throws NotFolderException {
        ExplorerMain main = new ExplorerMain();
        main.init();
        main.start();
    }

    public void init() throws NotFolderException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the start directory");
            explorer = new Explorer(scan.nextLine());
            System.out.println("Success");
            showHelp();
        }
        catch (NotFolderException ex){
            throw new NotFolderException();
        }
    }

    public void start() {
        while (true){
            try {
                Scanner scan = new Scanner(System.in);
                String string = scan.nextLine();
                String[] strings = string.split("\\s", 2);
                String command;
                String argument;

                if (strings.length == 1) {
                    command = string;
                    argument = null;
                } else {
                    command = strings[0];
                    argument = strings[1];
                }


                switch (command) {
                    case "cd":
                        explorer.cd(argument);
                        break;

                    case "copy":
                        System.out.println("Enter path to copy");
                        String argument2 = scan.nextLine();
                        if (explorer.copy(argument,argument2)){
                            System.out.println("Success");
                        }
                        break;

                    case "delete":
                        if (explorer.delete(argument)) {
                            System.out.println("Success");
                        }
                        break;

                    case "dir":
                        explorer.dir();
                        break;

                    case "help":
                        showHelp();
                        break;

                    case "start":
                        explorer.start(argument);
                        break;

                    case "stop":
                        System.out.println("Bye");
                        return;

                    default:
                        System.out.println("Unknown command, use \"help\"");
                }
            }
            catch (NotFolderException ex){
                System.out.println("Specify a folder or use \"start\"");
            }
            catch (FolderException ex){
                System.out.println("Specify a folder or use \"start\"");
            }
            catch (FileNotFoundException ex){
                System.out.println("Cant found this file");
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
    }

    public void showHelp(){
        System.out.println("Runnable commands:");
        System.out.println("cd <path> - change directory to entered path");
        System.out.println("delete <path or filename> - delete current file");
        System.out.println("dir - shows files and directories in current directory");
        System.out.println("help - show this message again");
        System.out.println("start <path or filename> - start the file");
        System.out.println("stop - exit the explorer");
    }
}
