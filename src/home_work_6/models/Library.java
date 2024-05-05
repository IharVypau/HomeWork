package home_work_6.models;


import home_work_6.utils.DirecroryReaderUtil;

import java.util.HashMap;

public final class Library {
    public static final String WORKING_DIR = "src/home_work_6/";
    private final HashMap<String, Catalog> catalogs = new HashMap<>();

    {
        initCatalogs();
    }

    private void initCatalogs() {
        String[] catalogsList = DirecroryReaderUtil.getFolderList(WORKING_DIR);
        for (String catalogName : catalogsList) {
            catalogs.put(catalogName, new Catalog((WORKING_DIR + catalogName), catalogName));
        }
    }

    public String[] displayCatalogs(){
        return catalogs.keySet().toArray(new String[0]);
    }
    public boolean catalogNameIsExist(String name){
        return catalogs.containsKey(name);
    }

    public Catalog getCatalogByName(String name){
        return catalogs.get(name);
    }

}
