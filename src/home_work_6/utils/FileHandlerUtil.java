package home_work_6.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandlerUtil {

    private final File currentFile;
    private StringBuilder text = new StringBuilder();
    public FileHandlerUtil(File currentFile) {
        this.currentFile = currentFile;
        handleFile();
    }
    public void handleFile(){
        try (FileReader reader = new FileReader(currentFile.getPath());
             BufferedReader buf = new BufferedReader(reader) )
         {
            String line;
            while ((line = buf.readLine()) != null){
                text.append(line);
            }
        } catch (IOException e){
            System.out.println("Ошибка чтения данных: " + e);
        }
    }

    public String getFileContent() {
        return text.toString();
    }
}
