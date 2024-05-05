package home_work_6.models;

import home_work_6.utils.DirecroryReaderUtil;
import home_work_6.utils.FileHandlerUtil;
import java.util.HashMap;

public class Catalog {
    private final String catalogName;
    private static final HashMap<String, Book> books = new HashMap<>();
    private final DirecroryReaderUtil dirReader;

    public Catalog(String dir, String catalogName) {
        dirReader = new DirecroryReaderUtil(dir);
        this.catalogName = catalogName;
        initBooks();
    }
    private void initBooks() {
        String[] booksList = dirReader.getFilesList(dirReader.getDirectoryPath());
        for (String bookName : booksList) {
            books.put(bookName, new Book(bookName));
        }
    }

    public Book getBookByName(String name) {
        Book book = books.get(name);
        if(book == null){
            return null;
        }
        book.setText(new FileHandlerUtil(dirReader.getFileByName(name)).getFileContent());
        return book;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String[] getBooksList(){
        return books.keySet().toArray(new String[0]);
    }
    public boolean checkBookIsExist(String bookName){
        return books.containsKey(bookName);
    }

}
