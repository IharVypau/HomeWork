package home_work_2.Test.arrays;

import home_work_2.arrays.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


public class Ex2Test {
    private IArraysOperation doWhileOperation = new DoWhileOperation();
    private IArraysOperation whileOperation = new WhileOperation();
    private IArraysOperation forOperation = new ForOperation();
    private IArraysOperation forEachOperation = new ForEachOperation();
    @DisplayName("A special test cases for arrays using do while operating")
    @Test
    public void doWhileOperation(){
        assertAll("do while operation: ",
                () -> assertEquals("4 17 32 ", doWhileOperation.getEveryElementsFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("17 ", doWhileOperation.getEverySecondElementFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("32 17 4 ", doWhileOperation.getElementsFromArrayInReverseOrder(new int[]{4, 17, 32}))
        );
    }
    @Test
    public void whileOperation(){
        assertAll("while operation: ",
                () -> assertEquals("4 17 32 ", whileOperation.getEveryElementsFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("17 ", whileOperation.getEverySecondElementFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("32 17 4 ", whileOperation.getElementsFromArrayInReverseOrder(new int[]{4, 17, 32}))
        );
    }

    @Test
    public void forOperation(){
        assertAll("for operation: ",
                () -> assertEquals("4 17 32 ", forOperation.getEveryElementsFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("17 ", forOperation.getEverySecondElementFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("32 17 4 ", forOperation.getElementsFromArrayInReverseOrder(new int[]{4, 17, 32}))
        );
    }
    @Test
    public void forEachOperation(){
        assertAll("Foreach operation: ",
                () -> assertEquals("4 17 32 ", forEachOperation.getEveryElementsFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("17 ", forEachOperation.getEverySecondElementFromArray(new int[]{4, 17, 32})),
                () -> assertEquals("32 17 4 ", forEachOperation.getElementsFromArrayInReverseOrder(new int[]{4, 17, 32}))
        );
    }


}