package home_work_6;

import home_work_6.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegSearchCaseInsensitive implements ISearchEngine  {

    public long search(String text, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        long cnt = 0;
        while (match.find()) {
            cnt++;
        }
        return cnt;
    }
}
