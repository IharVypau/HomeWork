package test.home_work_1;

import home_work_1.Excercise5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Excercise5Test {
    @Test
    public void sleepIn() {
        Assertions.assertFalse(Excercise5.sleepIn(true, false), "Пора вставать, а ты спишь");
        assertTrue( Excercise5.sleepIn(false, true),"Можешь еще поспать, а ты встаешь");
        assertTrue( Excercise5.sleepIn(false, false),"Можешь еще поспать, а ты встаешь");
        assertTrue( Excercise5.sleepIn(true, true), "Можешь еще поспать, а ты встаешь");
    }

}
