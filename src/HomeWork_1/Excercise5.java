package HomeWork_1;

/*
* 5.* Создать СТАТИЧЕСКИЙ метод sleepIn рядом с методом main. (Взято с https://codingbat.com/prob/p187868).
	5.1 Данный метод будет принима два параметра
	5.2 Будет отвечать на вопрос спать ли дальше (да\нет) (возвращать true либо false).
	5.3 Первый параметр boolean weekday обозначает рабочий день
	5.4 Второй параметр boolean vacation обозначает отпуск.
	5.5 Если у нас отпуск или не рабочий день то мы можем спать дальше
	5.6 На основании ответа от метода sleepIn вывести сообщение можем спать дальше или пора идти на работу
	* */

public class Excercise5 {
    public static boolean sleepIn(boolean weekday, boolean vacation){
        return !weekday || vacation ;
    }
    public static void main(String[] args) {
        System.out.println("Спать ли дальше?");
        System.out.printf("%s (weekday = false, vacation = false)%n",sleepIn(false, false) ? "Да" : "Нет");
        System.out.printf("%s (weekday = true, vacation = false)%n",sleepIn(true, false) ? "Да" : "Нет");
        System.out.printf("%s (weekday = false, vacation = true)%n",sleepIn(false, true) ? "Да" : "Нет");
        System.out.printf("%s (weekday = true, vacation = true)%n",sleepIn(true, true) ? "Да" : "Нет");
    }
}
