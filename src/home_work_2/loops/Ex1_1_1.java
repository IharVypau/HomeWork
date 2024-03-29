package home_work_2.loops;
/*
* 1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе.
   Есть нюанс с переполнением, можно добавить проверки и сообщения пользователю.
   Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
   1.1.1. Используя только цикл
   1.1.2.* Используя рекурсию
* */
public class Ex1_1_1 {
    public static void main(String[] args) {

        if(args.length == 1 && args[0].matches("[2-9](\\d){0,4}")){
            System.out.println("Введенное число через аргумент: " + args[0]);
            int num = Integer.parseInt(args[0]);
            long  result = inLoop(num);
            if(result > 0){
                StringBuffer strBuff = new StringBuffer();
                for(int i = 1; i < num; i++){
                    strBuff.append(i).append(" * ");
                }
                System.out.println(strBuff.toString() + num + " = " + result);
            } else{
                System.out.println("Результат выполнения выражения превышает 64 битное целое число (long).");
            }
        }else{
            System.out.println("Не корректное число, должно быть от 2 до 99999");
        }
    }
    private static long inLoop(long number){
        long result = number;
        while(--number > 1 ) {
            if(checkOwerflowByMultiplyTwoNumbers(result, number)){
                result *= number;
            }
            else {
                result = -1;
                break;
            }
        }
        return result;
    }

    private static boolean checkOwerflowByMultiplyTwoNumbers(long a, long b){
        long result = a * b;
        return a == result / b;
    }
}
