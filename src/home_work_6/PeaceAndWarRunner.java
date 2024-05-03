package home_work_6;

import home_work_6.utils.DirectoryReaderUtil;

import java.util.*;
import java.util.regex.Pattern;

public class PeaceAndWarRunner {
    public static void main(String[] args) {

        System.out.println("Количество использованных слов: ");
        System.out.print("Введите величину N (топ самых используемых слов ):");
        Scanner scan = new Scanner(System.in);
        //System.out.println(textArr);
       // int n = scan.nextInt();
       // findTopNWordsMostUsed(textArr,n);
        RegExSearch regExSearch = new RegExSearch();
        //System.out.println(engine.search2(textArr.toString(),"мост"));
        EasySearch easySearch = new EasySearch();
        System.out.println();
        //System.out.println(easySearch.search(textArr.toString(), "война"));
        //System.out.println(regExSearch.search(textArr.toString(), "война"));
        //String path = scan.nextLine();
        System.out.println("укажите адрес папки, из которой мы будем считывать текстовые файлы:");
        DirectoryReaderUtil reader = new DirectoryReaderUtil("src/home_work_6/library");
        System.out.println(reader.getListOfTxtFiles());
        System.out.println("Выберите из списка txt файл с которым мы будем работать: ");
        String fileName = scan.nextLine();

    }




}
