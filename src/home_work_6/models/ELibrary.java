package home_work_6.models;

import home_work_6.utils.DirecroryReaderUtil;
import java.util.HashMap;
import static home_work_6.enums.EProperties.LIBRARY;

public enum ELibrary {
    INSTANCE;
    private final HashMap<String, Catalog> catalogs = new HashMap<>();

    {
        String[] catalogsList = DirecroryReaderUtil.getFolderList(LIBRARY.getPath());
        for (String catalogName : catalogsList) {
            catalogs.put(catalogName, new Catalog((LIBRARY.getPath() + catalogName), catalogName));
        }
    }

    public String[] displayCatalogs(){
        return catalogs.keySet().toArray(new String[0]);
    }

    public Catalog getCatalogByName(String name){
        if(!catalogs.containsKey(name)){
            throw new IllegalArgumentException("Ввели неверное имя каталога, попробуйте снова");
        }
        return catalogs.get(name);
    }

}
