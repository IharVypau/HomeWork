package home_work_2.arrays;

public class ForOperation implements IArraysOperation{
    private StringBuilder str = new StringBuilder();
    @Override
    public String getEveryElementsFromArray(int[] container) {
        str.delete(0, str.length());
        for (int i = 0; i < container.length; i++){
            str.append(container[i]).append(" ");
        }
        return str.toString();
    }
    @Override
    public String getEverySecondElementFromArray(int[] container) {
        str.delete(0, str.length());
        for (int i = 0; i < container.length; i++){
            if((i & 1) == 1){
                str.append(container[i]).append(" ");
            }
        }
        return str.toString();
    }
    @Override
    public String getElementsFromArrayInReverseOrder(int[] container) {
        str.delete(0, str.length());
        for (int i = container.length - 1; i >= 0; i--){
            str.append(container[i]).append(" ");
        }
        return str.toString();
    }

}
