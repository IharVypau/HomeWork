package home_work_6.seachers.additional;

import home_work_6.seachers.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegSearchCaseInsensitive implements ISearchEngine  {
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("(^|[^а-яА-ЯёЁ_])" + word + "(?![а-яА-ЯёЁ_])",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE );
        Matcher match = pattern.matcher(text);
        long cnt = 0;
        while (match.find()) {
            cnt++;
        }
        return cnt;
    }
}
