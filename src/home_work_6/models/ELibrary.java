package home_work_6.models;

import home_work_6.utils.DirecroryReaderUtil;
import java.util.HashMap;
import static home_work_6.enums.EProperties.LIBRARY;

public enum ELibrary {
    INSTANCE(LIBRARY.getPath());
    private String directory = ".";
    private final HashMap<String, Catalog> catalogs = new HashMap<>();

    ELibrary(String workDirectory) {
        this.directory = workDirectory;
        initCatalogs();
    }

    private void initCatalogs() {
        String[] catalogsList = DirecroryReaderUtil.getFolderList(LIBRARY.getPath());
        for (String catalogName : catalogsList) {
            catalogs.put(catalogName, new Catalog((LIBRARY.getPath() + catalogName), catalogName));
        }
    }

    public String[] displayCatalogs(){
        return catalogs.keySet().toArray(new String[0]);
    }
    private boolean catalogNameIsExist(String name){
        return catalogs.containsKey(name);
    }

    public Catalog getCatalogByName(String name){
        if(!catalogNameIsExist(name)){
            throw new IllegalArgumentException("Ввели неверное имя каталога, попробуйте снова");
        }
        return catalogs.get(name);
    }
    public String getDirectory(){
        return directory;
    }

}
