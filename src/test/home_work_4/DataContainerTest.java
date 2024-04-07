package test.home_work_4;

import home_work_4.DataContainer;
import home_work_4.utils.comparators.NumberComparator;
import home_work_4.utils.comparators.StringLenghtComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataContainerTest {

    @Test
    public void dataContainerTest(){
        DataContainer<String> container = new DataContainer<>(new String[]{"i", "hello", "1", "Как домашка"});
        Assertions.assertEquals(4, container.add("bye"));
        Assertions.assertEquals(5, container.add("hi"));
        Assertions.assertEquals("bye", container.get(4));
        Assertions.assertTrue(container.delete("bye"));
        Assertions.assertTrue(container.delete(2));
        Assertions.assertEquals("[i, hello, Как домашка, hi]",container.toString());
        container.sort(new StringLenghtComparator());
        Assertions.assertEquals("[i, hi, hello, Как домашка]",container.toString());

        DataContainer<Integer> container2 = new DataContainer<>(new Integer[]{99, 3, 2, 33, null, null, null});
        Assertions.assertEquals(4, container2.add(777));
        Assertions.assertEquals(-1, container2.add(null));
        Assertions.assertEquals(3, container2.get(1));
        Assertions.assertTrue(container.delete((Integer) 2));
        Assertions.assertTrue(container.delete(1));
        Assertions.assertEquals("[99, 3, 2, 33, 777]",container2.toString());
        container2.sort(new NumberComparator());
        Assertions.assertEquals("[2, 3, 33, 99, 777]",container2.toString());
    }
}
