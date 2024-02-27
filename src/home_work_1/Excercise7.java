package home_work_1;

/*
* Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main,
 данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
 В метод будет передаваться массив из 10 цифр (от 0 до 9).
 Данные цифры должны быть помещены в строку формата: (XXX) XXX-XXXX.
 Например передан массив: {1,2,3,4,5,6,7,8,9,0}, возвращаемый результат: (123) 456-7890.
 (Взято с https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java). В задании нельзя использовать колекции, стрима.
* */
public class Excercise7 {
    static String createPhoneNumber(int[] digits){
        String result = "";
        for(int i: digits){
            result += ""+i;
        }
        return result.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");

    }
    public static void main(String[] args) {
        System.out.print(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
