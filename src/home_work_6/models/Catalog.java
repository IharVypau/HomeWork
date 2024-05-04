package home_work_6.models;

import home_work_6.utils.DirecroryReaderUtil;
import home_work_6.utils.FileHandlerUtil;

import java.util.HashMap;

public class Catalog {
    private static final HashMap<String, Book> books = new HashMap<>();
    private final DirecroryReaderUtil dirReader;

    public Catalog(String dir) {
        dirReader = new DirecroryReaderUtil(dir);
    }

    public Book getBookByName(String name){
        Book book = books.get(name);
        if(book == null){
            book = new Book(new FileHandlerUtil(dirReader.getFileByName(name)).getFileContent());
            books.put(name, book);
        }
        return book;
    }

}
