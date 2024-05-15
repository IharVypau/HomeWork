package home_work_6.runners;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import home_work_6.models.ELibrary;
import home_work_6.seachers.simple.SearchInCatalog;

import java.util.Scanner;

public class CatalogMain extends LibraryMain {
    public static void workWithCatalog(Catalog catalog) {
        System.out.println("Вы находитесь в каталоге: " + catalog.getCatalogName());
        System.out.println("Список имеющихся книг:");
        System.out.println(getBooksList(catalog));
        String opName = "";
        do {
            System.out.println("Введите название книги файла (для поиска в этом файле)");
            System.out.println("Для поиска по всему каталогу введите: search_in_catalog");
            System.out.println("для выхода из каталога нажмите exit");
            try{
                opName = readLine();
                if(opName.startsWith("search_in_catalog")){
                    searchInCatalog(ELibrary.INSTANCE.getCatalogByName(catalog.getCatalogName()));
                    break;
                }else{
                    Book book = catalog.getBookByName(opName);
                    BookMain.workWithBook(book);
                }
            } catch (IllegalArgumentException e) {
                if (!opName.equals("exit")) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!opName.equals("exit"));
        System.out.println("Вы вышли из каталога: " + catalog.getCatalogName());
    }

    private static void searchInCatalog(Catalog catalog) {
        SearchInCatalog catalogSearcher = new SearchInCatalog(catalog);
        while (true) {
            System.out.println("Введите искомое слово или фразу, для выхода из каталога нажмите exit");
            String word = readLine();
            if (word.equals("exit")) {
                break;
            }
            catalogSearcher.search(word);
            System.out.println("Результаты поиска записаны в файл results.txt");
        }
    }

    private static String getBooksList(Catalog catalog) {
        String[] books = catalog.getBooksList();
        return formatArrayToString(books);
    }
}
