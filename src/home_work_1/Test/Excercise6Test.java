package home_work_1.Test;

import home_work_1.Excercise5;
import home_work_1.Excercise6;
import org.junit.Test;

import static org.junit.Assert.*;

public class Excercise6Test {
    private static final String MEN = "Вася";
    private static final String WOMEN = "Анастасия";
    @Test
    public void greeting() {
        assertTrue(Excercise6.checkIsFriend(MEN));
        assertTrue(Excercise6.checkIsFriend(WOMEN));
        assertFalse(Excercise6.checkIsFriend("Katya"));
    }

}
