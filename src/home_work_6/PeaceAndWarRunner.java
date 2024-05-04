package home_work_6;

import home_work_6.models.Book;
import home_work_6.models.Catalog;
import home_work_6.models.Library;
import home_work_6.seachers.additional.RegSearchCaseInsensitive;
import home_work_6.seachers.additional.SearchEngineCaseNormalizer;
import home_work_6.seachers.simple.EasySearch;
import home_work_6.seachers.simple.RegExSearch;

import java.util.*;

public class PeaceAndWarRunner {
    private static final String WORKING_DIR = "src/home_work_6/library/";
    public static void main(String[] args) {
        Library library = new Library(WORKING_DIR);
        String fileName = "Война и мир";
        Book book = library.getBookByName(fileName + ".txt");
        long cnt = book.getCountOfUsedWords();
        System.out.printf("Количество использованных слов в книге %s : %d%n", fileName, cnt);

        System.out.println("Введите величину N (топ самых используемых слов ):");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(book.getTopNWordsMostUsed(n));

        System.out.println("Слово 'война'(как есть) встречается в тексте"+ book.getCountMatchesWordInText("война") + " раз");
        System.out.println("Слово 'и' (как есть) встречается в тексте"+ book.getCountMatchesWordInText("и") + " раз");
        System.out.println("Слово 'мир' (как есть) встречается в тексте"+ book.getCountMatchesWordInText("мир") + " раз");
        book.setSearchEngine(new RegSearchCaseInsensitive());
        System.out.println("Слово 'война'(без учета регистра) встречается в тексте"+ book.getCountMatchesWordInText("война") + " раз");
        System.out.println("Слово 'и' (без учета регистра) встречается в тексте"+ book.getCountMatchesWordInText("и") + " раз");
        System.out.println("Слово 'мир'(без учета регистра) встречается в тексте"+ book.getCountMatchesWordInText("мир") + " раз");


        /*
       // findTopNWordsMostUsed(textArr,n);
        RegExSearch regExSearch = new RegExSearch();
        //System.out.println(engine.search2(textArr.toString(),"мост"));
        EasySearch easySearch = new EasySearch();
        System.out.println();
        //System.out.println(easySearch.search(textArr.toString(), "война"));
        //System.out.println(regExSearch.search(textArr.toString(), "война"));
        //String path = scan.nextLine();
        System.out.println("укажите адрес папки, из которой мы будем считывать текстовые файлы:");
        Catalog reader = new Catalog("src/home_work_6/library");
        System.out.println(reader.getListOfTxtFiles());
        System.out.println("Выберите из списка txt файл с которым мы будем работать: ");
        String fileName = scan.nextLine();*/

    }




}
