package home_work_6.seachers.simple;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchInCatalog {
    private final Catalog catalog;
    private HashMap<String, Book> books;

    public SearchInCatalog(Catalog catalog) {
        this.catalog = catalog;
        books = catalog.getBooks();
    }

    public void search(String word) {
        try (ExecutorService executor = Executors.newFixedThreadPool(books.size())) {
            for (String bookName : books.keySet()) {
                executor.execute(new BookSearch(books.get(bookName), word));
            }
            executor.shutdown();
        }
    }

    private class BookSearch implements Runnable {
        private final String word;
        private Book book;

        public BookSearch(Book book, String word) {
            this.word = word;
            this.book = book;
        }

        @Override
        public void run() {
            if(books.get(book.getBookName()).getText().isEmpty()){
                book = catalog.getBookByName(book.getBookName());
            }
            long cnt = book.getCountMatchesWordInText(word);
            System.out.println("Книга: " + book.getBookName() + " - " + cnt);
            synchronized (this) {
                book.saveSearchResults(word, cnt);
            }
        }
    }
}
