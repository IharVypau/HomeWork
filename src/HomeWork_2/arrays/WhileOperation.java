package HomeWork_2.arrays;

public class WhileOperation  implements IArraysOperation{
    @Override
    public void outputArray2_2_1(int[] container) {
        System.out.print("\nWhileOperation: ");
        int i = 0;
        while(container.length > i){
            System.out.print(container[i]+" ");
            i++;
        }
    }

    @Override
    public void outputArray2_2_2(int[] container) {
        System.out.print("\nWhileOperation: ");
        int i = 0;
        while(container.length > i){
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
            i++;
        }
    }

    @Override
    public void outputArray2_2_3(int[] container) {
        System.out.print("\nWhileOperation: ");
        int i = container.length-1;
        while(i >= 0){
            System.out.print(container[i]+" ");
            i--;
        }
    }
}
