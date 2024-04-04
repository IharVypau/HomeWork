package home_work_1.test;

import home_work_1.Excercise5;
import org.junit.Test;

import static org.junit.Assert.*;

public class Excercise5Test {
    @Test
    public void sleepIn() {
        assertFalse("Пора вставать, а ты спишь", Excercise5.sleepIn(true, false));
        assertTrue("Можешь еще поспать, а ты встаешь", Excercise5.sleepIn(false, true));
        assertTrue("Можешь еще поспать, а ты встаешь", Excercise5.sleepIn(false, false));
        assertTrue("Можешь еще поспать, а ты встаешь", Excercise5.sleepIn(true, true));
    }

}
