package home_work_6.runners;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import home_work_6.models.ELibrary;
import home_work_6.seachers.additional.RegSearchCaseInsensitive;
import home_work_6.seachers.simple.SearchInCatalog;

import java.util.*;

public class LibraryMain {

    public static void main(String[] args) {
        Catalog catalog = ELibrary.INSTANCE.getCatalogByName("catalog5");
        String fileName = "Война и мир.txt";
        Book book = catalog.getBookByName(fileName);
        long cnt = book.getCountOfUsedWords();
        System.out.printf("Количество использованных слов в книге %s : %d%n", fileName, cnt);
        System.out.println("Введите величину N (топ самых используемых слов ):");
        int n = 0;
        try{
            n = Math.max(Integer.parseInt(readLine()), 0);
        }catch (NumberFormatException e){
            System.out.println("Введено не число");
        }
        System.out.println(book.getTopNWordsMostUsed(n));

        System.out.println("Слово 'война'(как есть) встречается в тексте " + book.getCountMatchesWordInText("война") + " раз");
        System.out.println("Слово 'и' (как есть) встречается в тексте " + book.getCountMatchesWordInText("и") + " раз");
        System.out.println("Слово 'мир' (как есть) встречается в тексте " + book.getCountMatchesWordInText("мир") + " раз");
        book.setSearchEngine(new RegSearchCaseInsensitive());
        System.out.println();
        System.out.println("Слово 'война'(без учета регистра) встречается в тексте " + book.getCountMatchesWordInText("война") + " раз");
        System.out.println("Слово 'и' (без учета регистра) встречается в тексте " + book.getCountMatchesWordInText("и") + " раз");
        System.out.println("Слово 'мир'(без учета регистра) встречается в тексте " + book.getCountMatchesWordInText("мир") + " раз");
        System.out.println();

        workWithLibrary();

    }

    public static void workWithLibrary() {

        System.out.println("Добро пожаловать в библиотеку!");
        System.out.println("Список имеющихся каталогов:");
        System.out.println(getCatalogsList());
        String catalogName = "";
        System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
        System.out.println("Для выхода из библиотеки нажмите exit");
        do {
            try {
                catalogName = readLine();
                CatalogMain.workWithCatalog(ELibrary.INSTANCE.getCatalogByName(catalogName));
                System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
                System.out.println("Для выхода из библиотеки нажмите exit");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!catalogName.equals("exit"));
        System.out.println("До новых встреч в библиотеке!");
    }

    static String getCatalogsList() {
        String[] catalogs = ELibrary.INSTANCE.displayCatalogs();
        return formatArrayToString(catalogs);
    }

    protected static String formatArrayToString(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(i + 1).append(". ").append(array[i]).append("\n");
        }
        return sb.toString();
    }
    protected static String readLine(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            return scanner.nextLine();
        }
        scanner.close();
        return "";
    }



}
