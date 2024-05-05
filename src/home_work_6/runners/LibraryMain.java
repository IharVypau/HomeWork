package home_work_6.runners;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import home_work_6.models.Library;
import home_work_6.seachers.additional.RegSearchCaseInsensitive;

import java.util.*;

public class LibraryMain {
    private static final Library LIBRARY = new Library();
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {
        Catalog catalog = LIBRARY.getCatalogByName("library");
        String fileName = "Война и мир.txt";
        Book book = catalog.getBookByName(fileName);
        long cnt = book.getCountOfUsedWords();
        System.out.printf("Количество использованных слов в книге %s : %d%n", fileName, cnt);
        System.out.println("Введите величину N (топ самых используемых слов ):");

        int n = inputNumber();
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
        do {
            System.out.println("Введите название каталога ( адрес папки ), с которым мы будем работать");
            System.out.println("Для выхода из библиотеки нажмите exit");
            catalogName = CONSOLE.nextLine();
            if (LIBRARY.catalogNameIsExist(catalogName)) {
                CatalogMain.workWithCatalog(LIBRARY.getCatalogByName(catalogName));
            } else if(!catalogName.equals("exit")){
                System.out.println("Ввели неверное имя каталога, попробуйте снова");
            }
        } while (!catalogName.equals("exit"));
        System.out.println("До новых встреч в библиотеке!");
    }


    private static String getCatalogsList(){
        String[] catalogs = library.displayCatalogs();
        return formatArrayToString(catalogs);
    }

    protected static String formatArrayToString(String[] array){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(i + 1).append(". ").append(array[i]).append("\n");
        }
        return sb.toString();
    }
    protected static int inputNumber(){
        int val = -1;
        do{
            try {
                val = CONSOLE.nextInt();
            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода числа");
            }
        }while(val != -1);

        return val;
    }


}
