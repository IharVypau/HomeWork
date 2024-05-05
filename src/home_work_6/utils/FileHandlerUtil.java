package home_work_6.utils;

import java.io.*;

public class FileHandlerUtil {

    private final File currentFile;
    private final StringBuffer text = new StringBuffer();
    public FileHandlerUtil(File currentFile) {
        this.currentFile = currentFile;
        readFile();
    }

    public void readFile(){
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

    public void writeInFile(String text){
        try (FileWriter writer = new FileWriter(currentFile, true)) {
            writer.write(text);
            writer.append("\n");
            writer.flush();
        }  catch (IOException e){
            System.out.println("Произошла ошибка работы с файлом");
        }
    }

    public String getFileContent() {
        return text.toString();
    }
}
