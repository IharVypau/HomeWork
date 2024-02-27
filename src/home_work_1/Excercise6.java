package home_work_1;

import java.util.Objects;
import java.util.Scanner;

/*
* 6. Запросить у пользователя через консоль его имя. В данном задании у вас должно получиться 3 класса.
	Что в итоге надо сделать (общее условие):
		1. Если имя будет равно имени "Вася" тогда в консоль должно вывести сообщение "Привет!" на одной строке, а на второй "Я тебя так долго ждал".
		2. Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение "Я тебя так долго ждал".
		3. В случае если это будет другое имя то вывести сообщение "Добрый день, а вы кто?".
	Как это сделать:
		6.1 Написать в отдельном классе main метод и в нём код который будет выполнять общее условие при помощи if else
		6.2 Написать в отдельном классе main метод и в нём код который будет выполнять общее условие при помощи if else if
		6.3 Написать в отдельном классе main метод и в нём код который будет выполнять общее условие при помощи switch
	ВНИМАНИЕ! В примерах c if для сравнения имён использовать код вида Objects.equals("Имя1", "Имя2").
*
* */
public class Excercise6 {
    static String friendGreeting = "Привет!\nЯ тебя так долго ждал";
    static String guestGreeting = "Добрый день, а вы кто?";
    static final String MEN = "Вася";
    static final String WOMEN = "Анастасия";
    public static void main(String[] args) {

    }
}
class Ex6_1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = input.next();
        if(Objects.equals(Excercise6.MEN, name) || Objects.equals(Excercise6.WOMEN, name)){
            System.out.println(Excercise6.friendGreeting);
        } else {
            System.out.println(Excercise6.guestGreeting);
        }
    }

}
class Ex6_2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = input.next();
        if(Objects.equals(Excercise6.MEN, name)){
            System.out.println(Excercise6.friendGreeting);
            return;
        } else if(Objects.equals(Excercise6.WOMEN, name)){
            System.out.println(Excercise6.friendGreeting);
            return;
        }
        System.out.println(Excercise6.guestGreeting);
    }
}
class Ex6_3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = input.next();
        switch (name){
            case Excercise6.MEN:
            case Excercise6.WOMEN:{
                System.out.println(Excercise6.friendGreeting); break;
            }
            default:
                System.out.println(Excercise6.guestGreeting); break;
        }
    }
}
