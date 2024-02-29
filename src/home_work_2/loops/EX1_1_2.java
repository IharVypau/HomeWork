package home_work_2.loops;

public class EX1_1_2 {
    public static void main(String[] args) {

        if(args.length == 1 && args[0].matches("[2-9](\\d){0,4}")){
            System.out.println("Введенное число через аргумент: " + args[0]);
            int num = Integer.parseInt(args[0]);
            long result = inRecursion(num);
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
    private static long inRecursion(long number){
        long result ;
        if(number <= 1) return 1;
        else {
            long prevResult = number;
            result = number * inRecursion(number - 1);
            return (!checkOwerflowByMultiplyTwoNumbers(number, prevResult)) ? -1 : result;
        }
    }
    private static boolean checkOwerflowByMultiplyTwoNumbers(long a, long b){
        long result = a * b;
        return a == result / b;
    }
}
