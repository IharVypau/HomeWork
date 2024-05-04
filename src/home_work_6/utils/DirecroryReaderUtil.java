package home_work_6.utils;

import java.io.File;

public class DirecroryReaderUtil {
    private File path;
    private File[] filesList;

    public DirecroryReaderUtil(String dir) {
        path = new File(dir);
        filesList= path.listFiles();
    }

    public File getFileByName(String name) {
        return new File(path.getPath()+"/"+ name);
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
}
