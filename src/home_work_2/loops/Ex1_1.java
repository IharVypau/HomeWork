package home_work_2.loops;

/*
* 1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе.
   Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.
   Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
   1.1.1. Используя только цикл
   1.1.2.* Используя рекурсию
* */
public class Ex1_1 {
    public static final String USER_INPUT_MSG = "Введенное число через аргумент: ";
    public static final String ERROR_INPUT_NUMBER_MSG = "Не корректное число, должно быть от 2 до 20";


    public static void main(String[] args) {
        if (args.length != 0 && userInputIsCorrect(args[0])) {
            System.out.println(USER_INPUT_MSG + args[0]);
            long number = Long.parseLong(args[0]);
            long result = calculateUsingLoop(number);
            System.out.println(getStringExpression(number, result));
        } else {
            System.out.println(ERROR_INPUT_NUMBER_MSG);
        }
    }

    public static String getStringExpression(long number, long result) {
        StringBuffer strBuff = new StringBuffer();
        for (int i = 1; i < number; i++) {
            strBuff.append(i).append(" * ");
        }
        return strBuff.toString() + number + " = " + result;
    }

    public static boolean userInputIsCorrect(String strNumber) {
        return (strNumber.matches("[1-9](\\d){0,4}") && Integer.parseInt(strNumber) < 21);
    }

    public static long calculateUsingLoop(Long number) {
        long result = number;
        while (--number > 1) {
            if (checkOwerflowByMultiplyTwoNumbers(result, number)) {
                result *= number;
            } else {
                result = -1;
                break;
            }
        }
        return result;
    }
    public static long calculateUsingRecursion(long number){
        long result ;
        if(number <= 1) return 1;
        else {
            result = number * calculateUsingRecursion(number - 1);
            return (!checkOwerflowByMultiplyTwoNumbers(number, number)) ? -1 : result;
        }
    }

    private static boolean checkOwerflowByMultiplyTwoNumbers(long a, long b) {
        long result = a * b;
        return a == result / b;
    }
}
