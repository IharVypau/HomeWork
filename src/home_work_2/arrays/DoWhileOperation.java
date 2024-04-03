package home_work_2.arrays;

public class DoWhileOperation implements IArraysOperation {
    private StringBuilder str = new StringBuilder();

    @Override
    public String getEveryElementsFromArray(int[] container) {
        str.delete(0, str.length());
        int i = 0;
        do {
            str.append(container[i]).append(" ");
        } while (++i < container.length);
        return str.toString();
    }

    @Override
    public String getEverySecondElementFromArray(int[] container) {
        str.delete(0, str.length());
        int i = 0;
        do {
            if ((i & 1) == 1) {
                str.append(container[i]).append(" ");
            }
        } while (++i < container.length);
        return str.toString();
    }

    @Override
    public String getElementsFromArrayInReverseOrder(int[] container) {
        str.delete(0, str.length());
        int i = container.length - 1;
        do {
            str.append(container[i]).append(" ");
        } while (--i >= 0);
        return str.toString();
    }
}
