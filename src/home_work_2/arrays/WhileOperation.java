package home_work_2.arrays;

public class WhileOperation  implements IArraysOperation{
    private StringBuilder str = new StringBuilder();
    @Override
    public String getEveryElementsFromArray(int[] container) {
        str.delete(0, str.length());
        int i = 0;
        while(container.length > i){
            str.append(container[i]).append(" ");
            i++;
        }
        return str.toString();
    }

    @Override
    public String getEverySecondElementFromArray(int[] container) {
        str.delete(0, str.length());
        int i = 0;
        while(container.length > i){
            if((i & 1) == 1){
                str.append(container[i]).append(" ");
            }
            i++;
        }
        return str.toString();
    }

    @Override
    public String getElementsFromArrayInReverseOrder(int[] container) {
        str.delete(0, str.length());
        int i = container.length-1;
        while(i >= 0){
            str.append(container[i]).append(" ");
            i--;
        }
        return str.toString();
    }
}
