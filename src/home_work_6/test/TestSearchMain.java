package home_work_6.test;


import home_work_6.models.ELibrary;
import home_work_6.seachers.additional.RegSearchCaseInsensitive;
import home_work_6.seachers.additional.SearchEngineCaseNormalizer;
import home_work_6.seachers.additional.SearchEnginePunctuationNormalizer;
import home_work_6.seachers.simple.EasySearch;
import home_work_6.seachers.simple.RegExSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSearchMain {

    /**
     * Проверяем, получим ли мы исключение если введем название несуществующего каталога
     */
    @Test
    void testWrongCatalogName() {
        assertThrows(IllegalArgumentException.class, () -> ELibrary.INSTANCE.getCatalogByName("sadas"));
    }

    /**
     * Проверяем, получим ли мы исключение если введем название несуществующей книги в каталоге
     */
    @Test
    void testWrongBookName() {
        assertThrows(IllegalArgumentException.class,
                () -> ELibrary.INSTANCE.getCatalogByName("library").getBookByName("24524"));
    }

    @Test
    void testEasySearch(){
        EasySearch es = new EasySearch();
        assertEquals(0, es.search("Мама мыла раму", "мыл"));
        assertEquals(1, es.search("как дела!.Что делаешь?", "дела"));
        assertEquals(1, es.search("привет;какдела!", "привет"));
        assertEquals(1, es.search("привет;какдела", "какдела"));
    }
    @Test
    void testRegExSearch(){
        RegExSearch rs = new RegExSearch();
        assertEquals(0, rs.search("Мама мыла раму", "мыл"));
        assertEquals(1, rs.search("как дела!.Что делаешь?", "дела"));
        assertEquals(1, rs.search("привет;какдела!", "привет"));
        assertEquals(1, rs.search("привет;какдела", "какдела"));
    }
    @Test
    void testPunctuationNormalizerSearch(){
        SearchEnginePunctuationNormalizer ps = new SearchEnginePunctuationNormalizer(new RegExSearch());
        assertEquals(0, ps.search("Мама мыла раму", "мыл"));
        assertEquals(1, ps.search("как дела!.Что делаешь?", "дела"));
        assertEquals(1, ps.search("привет;какдела!", "привет"));
        assertEquals(1, ps.search("привет;какдела", "какдела"));
        assertEquals(1, ps.search("привет\"'какдела'", "какдела"));
        assertEquals(0, ps.search("приветкакдела'", "какдела"));
    }
    @Test
    void testRegSearchCaseInsensitive(){
        RegSearchCaseInsensitive rs = new RegSearchCaseInsensitive();
        assertEquals(0, rs.search("Мама мЫЛа раму", "мыл"));
        assertEquals(1, rs.search("как дЕЛа!.Что делаешь?", "ДЕла"));
        assertEquals(2, rs.search("привет пРИвет;какдела!", "привет"));
        assertEquals(1, rs.search("привет;каКдЕлА", "КАКДЕЛА"));
        assertEquals(1, rs.search("привет\"'каКдела'", "какДЕЛа"));
    }

    @Test
    void testSearchEngineCaseNormalizer(){
        SearchEngineCaseNormalizer сaseNormalizer = new SearchEngineCaseNormalizer();
        assertEquals(2, сaseNormalizer.search("Мама мыла мылом раму ", "мыл"));
        assertEquals(2, сaseNormalizer.search("как делаа!.Что делаешь?", "дел"));
        assertEquals(1, сaseNormalizer.search("привет какдела!", "привет"));
        assertEquals(0, сaseNormalizer.search("приветкакдела делакак", "как"));
    }
}
