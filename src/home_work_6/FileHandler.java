package home_work_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private File currentFile;
    private StringBuilder text = new StringBuilder();
    private FileDataContainer container;
    public FileHandler(File currentFile) {
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
    public FileDataContainer buildDataContainer() {
        return new FileDataContainer(text.toString());
    }
}
