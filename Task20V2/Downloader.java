package Task20V2;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Scanner;

public class Downloader extends Thread{

    private InputStream is;
    private File file;
    private Double size;
    private boolean isDownloading;

    public boolean init(URI uri, Path pathToSave, String fileName){
        try {
            is = uri.toURL().openConnection().getInputStream();
            size = (double)uri.toURL().openConnection().getContentLength();
            isDownloading = false;
            file = new File(pathToSave + "\\" + fileName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void run(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos);
            int read = 0;
            isDownloading = true;
            while (((read = is.read()) != -1) && isDownloading){
                bout.write(read);
            }
            bout.close();
            is.close();
            if(isDownloading){
                System.out.println("Download completed");
            }
            isDownloading = false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double showProgress(){
        Double result;
        if(file != null && size != 0) {
            result = (file.length() * 100) / size;
        } else{
            result = 0.0;
        }
        return result;
    }

    public void setStop(){
        isDownloading = false;
    }

    public boolean isDownloading(){
        return isDownloading;
    }
}
