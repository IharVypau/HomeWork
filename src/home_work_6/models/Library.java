package home_work_6.models;


public class Library {
    private final Catalog catalog;

    public Library(String libraryPath) {
        catalog = new Catalog(libraryPath);
    }

    public Book getBookByName(String name){
        return catalog.getBookByName(name);
    }

}
