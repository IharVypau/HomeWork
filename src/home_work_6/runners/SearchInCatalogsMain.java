package home_work_6.runners;

import home_work_6.models.Catalog;
import home_work_6.models.ELibrary;
import home_work_6.seachers.simple.SearchInCatalog;

import java.util.Scanner;


public class SearchInCatalogsMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Добро пожаловать в библиотеку!");
        System.out.println("Список имеющихся каталогов:");
        System.out.println(LibraryMain.getCatalogsList());
        String catalogName = "";
        System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
        System.out.println("Для выхода из библиотеки нажмите exit");
        do {
            catalogName = console.nextLine();
            if (catalogName.equals("exit")) break;
            try {
                Catalog catalog = ELibrary.INSTANCE.getCatalogByName(catalogName);
                SearchInCatalog catalogSearcher = new SearchInCatalog(catalog);
                while (true) {
                    System.out.println("Введите искомое слово или фразу, для выхода из каталога нажмите exit");
                    String word = console.nextLine();
                    if (word.equals("exit")) break;
                    catalogSearcher.search(word);
                    System.out.println("Результаты поиска записаны в файл results.txt");
                }

                System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
                System.out.println("Для выхода из библиотеки нажмите exit");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!catalogName.equals("exit"));
        System.out.println("До новых встреч в библиотеке!");
    }
}
