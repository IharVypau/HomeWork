package home_work_6.runners;

import home_work_6.models.Book;
import home_work_6.models.Catalog;

import java.util.Scanner;

public class CatalogMain extends LibraryMain{
    public static void workWithCatalog(Catalog catalog) {
        System.out.println("Вы находитесь в каталоге: " + catalog.getCatalogName());
        System.out.println("Список имеющихся книг:");
        System.out.println(getBooksList(catalog));
        String bookName = "";
        do {
            System.out.println("Введите название книги (файла), с которой мы будем работать");
            System.out.println("для выхода из каталога нажмите exit");
            bookName = readLine();
            try{
                Book book = catalog.getBookByName(bookName);
                BookMain.workWithBook(book);
            }catch (IllegalArgumentException e){
                if(!bookName.equals("exit")){
                    System.out.println(e.getMessage());
                }
            }
        } while (!bookName.equals("exit"));
        System.out.println("Вы вышли из каталога: "+ catalog.getCatalogName());
    }

    private static String getBooksList(Catalog catalog){
        String[] books = catalog.getBooksList();
        return formatArrayToString(books);
    }
}
