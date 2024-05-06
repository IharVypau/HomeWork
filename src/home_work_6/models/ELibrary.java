package home_work_6.models;


import home_work_6.utils.DirecroryReaderUtil;

import java.util.HashMap;

public enum ELibrary {
    INSTANCE(Properties.LIBRARY.getPath());
    private String directory = ".";
    private final HashMap<String, Catalog> catalogs = new HashMap<>();
    enum Properties{
        HOME_DIRECTORY("src/home_work_6/"),
        LIBRARY("src/home_work_6/library/");
        private String path = ".";
        Properties(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    ELibrary(String workDirectory) {
        this.directory = workDirectory;
        initCatalogs();
    }

    private void initCatalogs() {
        String[] catalogsList = DirecroryReaderUtil.getFolderList(Properties.LIBRARY.getPath());
        for (String catalogName : catalogsList) {
            catalogs.put(catalogName, new Catalog((Properties.LIBRARY.getPath() + catalogName), catalogName));
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
