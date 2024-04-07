package test.home_work_1;

import home_work_1.Excercise6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Excercise6Test {
    private static final String MEN = "Вася";
    private static final String WOMEN = "Анастасия";
    @Test
    public void greeting() {
        Assertions.assertTrue(Excercise6.checkIsFriend(MEN));
        Assertions.assertTrue(Excercise6.checkIsFriend(WOMEN));
        Assertions.assertFalse(Excercise6.checkIsFriend("Katya"));
    }

}
