package home_work_6.seachers.simple;

import home_work_6.seachers.api.ISearchEngine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("(^|[^а-яА-ЯёЁ_])" + word + "(?![а-яА-ЯёЁ_])");
        Matcher match = pattern.matcher(text);
        long cnt = 0;
        while (match.find()) {
            cnt++;
        }
        return cnt;
    }


}
