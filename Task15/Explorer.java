package Task15;

import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class Explorer {
    private Path currentPath;

    public Explorer(String path) throws InvalidPathException, NotFolderException {
        try {
            currentPath = Paths.get(path);
            currentPath.normalize();

            if (!currentPath.isAbsolute()) {
                currentPath.toAbsolutePath();
            }

            if (Files.exists(currentPath)) {
                if (!Files.isDirectory(currentPath)) {
                    throw new NotFolderException("Not folder");
                }
            } else {
                throw new InvalidPathException(path, "Path doesnt exist");
            }
        } catch (InvalidPathException ex) {
            throw new InvalidPathException(path, "Invalid path");
        } catch (NotFolderException ex) {
            throw new NotFolderException("Not folder");
        }
    }


    public void cd(String path) throws NotFolderException{
        try{
            if(path == null){
                if (currentPath.getParent() == null){
                    System.out.println("You in the root directory");
                } else {
                    currentPath = currentPath.getParent();
                    System.out.println(getCurrentPath());
                }
                return;
            }
            Path tempPath = Paths.get(path);
            tempPath.normalize();
            if(!tempPath.isAbsolute()){
                tempPath = Paths.get(currentPath + "\\" + tempPath);
            }
            if(Files.exists(tempPath)){
                if(Files.isDirectory(tempPath)){
                    currentPath = tempPath;
                }
                else{
                    throw new NotFolderException();
                }
            }else {
                throw new InvalidPathException(path, "Path doesnt exist");
            }
            System.out.println(getCurrentPath());
        }
        catch (NotFolderException e) {
            throw new NotFolderException();
        }
        catch (InvalidPathException ex) {
            throw new InvalidPathException(path, "Invalid path");
        }
    }

    public boolean copy(String elementToCopyString, String pathToCopyString) throws IOException, FolderException {
        Path elementToCopy = Paths.get(elementToCopyString);
        Path pathToCopy = Paths.get(pathToCopyString);
        elementToCopy.normalize();
        pathToCopy.normalize();
        if (!elementToCopy.isAbsolute()) {
            elementToCopy = Paths.get(currentPath + "\\" + elementToCopy);
        }
        if(!pathToCopy.isAbsolute()){
            pathToCopy = Paths.get(currentPath + "\\" + pathToCopy);
        }
        if(Files.exists(elementToCopy) && Files.exists(pathToCopy)){
            if(Files.isDirectory(pathToCopy)){
                try {
                    File file = new File(elementToCopyString);
                    String fileName = file.getName();
                    pathToCopy = Paths.get(pathToCopyString + "\\" + fileName);
                    Files.copy(elementToCopy, pathToCopy);
                    return true;
                }
                catch (FileAlreadyExistsException ex){
                    throw new FileNotFoundException("File already exist");
                }
                catch (DirectoryNotEmptyException ex){
                    throw new DirectoryNotEmptyException("Directory not empty");
                }
            }
            else{
                throw new FolderException();
            }
        }
        else{
            throw new FileNotFoundException();
        }
    }


    public boolean delete(String path) throws IOException {
        if (path == null){
            throw new InvalidPathException(path, "Path cannot be empty");
        }
        Path tempPath = Paths.get(path);
        tempPath.normalize();
        if(!tempPath.isAbsolute()){
            tempPath = Paths.get(currentPath + "\\" + tempPath);
        }
        if(Files.exists(tempPath)){
            try {
                Files.delete(tempPath);
                return true;
            } catch (IOException e) {
                throw new IOException();
            }
        }
        else{
            throw new FileNotFoundException();
        }
    }

    public void dir() throws IOException {
        File file = new File(currentPath.toString());
        String[] namesOfFiles = file.list();
        String[] lastModifiedTimes = new String[namesOfFiles.length];
        String[] owners = new String[namesOfFiles.length];
        Long[] sizes = new Long[namesOfFiles.length];

        int maxNameLength = 0;
        int maxTimeLength = 0;
        int maxOwnerLength = 0;
        int maxSizeLength = 0;

        for (int i = 0; i < namesOfFiles.length; i++) {
            lastModifiedTimes[i] = Files.getLastModifiedTime(Paths.get(currentPath + "\\" + namesOfFiles[i])).toString();
            owners[i] = Files.getOwner(Paths.get(currentPath + "\\" + namesOfFiles[i])).toString();
            if(!Files.isDirectory(Paths.get(currentPath + "\\" + namesOfFiles[i]))){
                sizes[i] = Files.size(Paths.get(currentPath + "\\" + namesOfFiles[i]));
            }

            maxNameLength = Math.max(maxNameLength, namesOfFiles[i].length());
            maxTimeLength = Math.max(maxTimeLength, lastModifiedTimes[i].length());
            maxOwnerLength = Math.max(maxOwnerLength, owners[i].length());
            if(sizes[i] != null){
                maxSizeLength = Math.max(maxSizeLength, sizes[i].toString().length());
            }

        }

        for (int i = 0; i < namesOfFiles.length; i++) {
            System.out.print(namesOfFiles[i]);
            for (int j = 0; j < maxNameLength - namesOfFiles[i].length(); j++) {
                System.out.print(' ');
            }
            System.out.print("  |  ");

            System.out.print(lastModifiedTimes[i]);
            for (int j = 0; j < maxTimeLength - lastModifiedTimes[i].length(); j++) {
                System.out.print(' ');
            }
            System.out.print("  |  ");

            System.out.print(owners[i]);
            for (int j = 0; j < maxOwnerLength - owners[i].length(); j++) {
                System.out.print(' ');
            }
            System.out.print("  |  ");

            if(sizes[i] != null){
                System.out.print(sizes[i] + " bytes");
            }
            System.out.println();
        }
    }

    public void start(String path) throws FolderException, IOException {
        try {
            Path tempPath = Paths.get(path);
            tempPath.normalize();
            if (!tempPath.isAbsolute()) {
                tempPath = Paths.get(currentPath + "\\" + tempPath);
            }
            if (Files.exists(tempPath)) {
                if (Files.isDirectory(tempPath)) {
                    throw new FolderException();
                } else{
                    File file = new File(tempPath.toString());
                    Desktop.getDesktop().open(file);
                }
            } else {
                throw new InvalidPathException(path, "Path doesnt exist");
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
    }

    public Path getCurrentPath(){
        return currentPath;
    }
}
