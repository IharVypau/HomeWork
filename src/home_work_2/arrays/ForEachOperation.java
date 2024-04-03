package home_work_2.arrays;

public class ForEachOperation implements IArraysOperation {

    private StringBuilder str = new StringBuilder();

    @Override
    public String getEveryElementsFromArray(int[] container) {
        str.delete(0, str.length());
        for (int j : container) {
            str.append(j).append(" ");
        }
        return str.toString();
    }

    @Override
    public String getEverySecondElementFromArray(int[] container) {
        str.delete(0, str.length());
        int i = 0;
        for (int j : container) {
            if ((i & 1) == 1) {
                str.append(j).append(" ");
            }
            i++;
        }
        return str.toString();
    }

    @Override
    public String getElementsFromArrayInReverseOrder(int[] container) {
        str.delete(0, str.length());
        int i = container.length - 1;
        for (int j : container) {
            str.append(container[i]).append(" ");
            i--;
        }
        return str.toString();
    }
}
