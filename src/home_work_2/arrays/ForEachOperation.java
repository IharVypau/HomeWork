package home_work_2.arrays;

public class ForEachOperation implements IArraysOperation{
    @Override
    public void outputArray2_2_1(int[] container) {
        System.out.print("\nForEachOperation: ");
        for(int j : container){
            System.out.print(j + " ");
        }
    }
    @Override
    public void outputArray2_2_2(int[] container) {
        System.out.print("\nForEachOperation: ");
        int i = 0;
        for(int j : container){
            if((i & 1) == 1){
                System.out.print(j+" ");
            }
            i++;
        }
    }
    @Override
    public void outputArray2_2_3(int[] container) {
        System.out.print("\nForEachOperation: ");
        int i = container.length-1;
        for(int j : container){
            System.out.print(container[i] + " ");
            i--;
        }
    }
}
