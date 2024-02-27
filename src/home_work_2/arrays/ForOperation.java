package home_work_2.arrays;

public class ForOperation implements IArraysOperation{
    @Override
    public void outputArray2_2_1(int[] container) {
        System.out.print("\nForOperation: ");
        for (int i = 0; i < container.length; i++){
            System.out.print(container[i]+" ");
        }
    }
    @Override
    public void outputArray2_2_2(int[] container) {
        System.out.print("\nForOperation: ");
        for (int i = 0; i < container.length; i++){
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
        }
    }
    @Override
    public void outputArray2_2_3(int[] container) {
        System.out.print("\nForOperation: ");
        for (int i = container.length - 1; i >= 0; i--){
            System.out.print(container[i]+" ");
        }
    }

}
