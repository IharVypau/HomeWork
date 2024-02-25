package HomeWork_2.arrays;

public class DoWhileOperation implements IArraysOperation{
    @Override
    public void outputArray2_2_1(int[] container) {
        int i = 0;
        System.out.print("DoWhileOperation: ");
        do {
            System.out.print(container[i]+" ");
        }while (++i < container.length);

    }

    @Override
    public void outputArray2_2_2(int[] container) {
        int i = 0;
        System.out.print("DoWhileOperation: ");
        do {
            if((i & 1) == 1){
                System.out.print(container[i]+" ");
            }
        }while (++i < container.length);
    }

    @Override
    public void outputArray2_2_3(int[] container) {
        int i = container.length-1;
        System.out.println("DoWhileOperation: ");
        do {
            System.out.print(container[i]+" ");
        }while (--i >= 0);
    }
}
