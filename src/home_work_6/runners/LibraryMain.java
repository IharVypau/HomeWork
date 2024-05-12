package home_work_6.runners;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import home_work_6.models.ELibrary;
import home_work_6.seachers.additional.RegSearchCaseInsensitive;
import java.util.*;

public class LibraryMain {
    protected final static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Catalog catalog = ELibrary.INSTANCE.getCatalogByName("catalog5");
        String fileName = "Война и мир.txt";
        Book book = catalog.getBookByName(fileName);
        long cnt = book.getCountOfUsedWords();
        System.out.printf("Количество использованных слов в книге %s : %d%n", fileName, cnt);
        System.out.println("Введите величину N (топ самых используемых слов ):");
        int n = Math.max(inputNumber(), 0);
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
        Scanner console = new Scanner(System.in);
        System.out.println("Добро пожаловать в библиотеку!");
        System.out.println("Список имеющихся каталогов:");
        System.out.println(getCatalogsList());
        String catalogName = "";
        System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
        System.out.println("Для выхода из библиотеки нажмите exit");
        do {
            catalogName = console.nextLine();
            try {
                CatalogMain.workWithCatalog(ELibrary.INSTANCE.getCatalogByName(catalogName));
            } catch (IllegalArgumentException e) {
                if (!catalogName.equals("exit")) {
                    System.out.println(e.getMessage());
                }
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

    protected static int inputNumber() {

        int val = 0;
        if (console.hasNextInt()) {
            val = console.nextInt();
        } else {
            System.out.println("Ошибка ввода числа");
        }
        return val;
    }
    protected static String readLine(){
        Scanner console = new Scanner(System.in);
        String value  = "";
        if (console.hasNextLine()) {
            value = console.nextLine();
        }
        return value;
    }

}
