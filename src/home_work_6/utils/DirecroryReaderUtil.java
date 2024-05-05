package home_work_6.utils;

import java.io.File;
import java.io.FilenameFilter;

public class DirecroryReaderUtil {
    private File directory;
    private File[] filesList;

    public DirecroryReaderUtil(String dir) {
        directory = new File(dir);
        filesList = directory.listFiles();
    }

    public File getFileByName(String name) {
        return new File(directory.getPath()+"/"+ name);
    }
    public String getListOfTxtFiles(){
        StringBuilder sb = new StringBuilder();
        if(filesList != null){
            for(File file : filesList) {
                if(file.getName().matches(".*\\.txt")){
                    sb.append(file.getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }
    public static String[] getFolderList(String dirName){
        FilenameFilter filter = (dir, name) -> !name.matches(".*\\..*");
        File directory = new File(dirName);
        return directory.list(filter);
    }
    public String[] getFilesList(String dirName){
        FilenameFilter filter = (dir, name) -> name.matches(".*\\.txt$");
        File directory = new File(dirName);
        return directory.list(filter);
    }

    public String getDirectoryPath() {
        return directory.getPath();
    }
}
