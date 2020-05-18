package Task15;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExplorer {
    public static void main(String[] args) throws NotFolderException, FileNotFoundException, IOException {
        Explorer explorer = new Explorer("C:\\Program Files\\");
        System.out.println(explorer.getCurrentPath());
        explorer.cd("D:\\Desktop\\Tasks");
        System.out.println(explorer.getCurrentPath());
        explorer.dir();
        explorer.cd("D:\\Desktop\\Books");
        explorer.dir();
    }
}
