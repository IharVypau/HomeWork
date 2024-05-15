package home_work_6.runners;

import home_work_6.models.Book;

import java.util.Scanner;

public class BookMain extends CatalogMain{
    public static void workWithBook(Book book) {
        System.out.println("Вы работаете с книгой: " + book.getBookName());
        System.out.println("Введите, что вы хотите найти в этой книге: ");
        System.out.println("Все запросы и их результат, будут записаны в файле results.txt");
        System.out.println("Для выхода, или выбора другой книги введите exit");
        String word = "";
        do {
            word = readLine();
            if(!word.equals("exit")){
                long cnt = book.getCountMatchesWordInText(word);
                System.out.println("Количество совпадений равно: "+ cnt);
                System.out.println("Для продолжения поиска введите свой запрос");
                System.out.println("Для выхода или выбора другой книги введите exit");
                book.saveSearchResults(word, cnt);
            }
        } while (!word.equals("exit"));

    }
}
