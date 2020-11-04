package chapter1;

import java.io.File;
import java.io.FileFilter;

public class Ex2_HiddenFileFilter {

    public static void main(String[] args) {
        traditionalFindHiddenFiles();
        modernFindHiddenFiles();
    }

    public static void traditionalFindHiddenFiles() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
    }

    public static void modernFindHiddenFiles() {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
