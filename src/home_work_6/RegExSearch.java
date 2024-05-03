package home_work_6;

import home_work_6.api.ISearchEngine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile(word);
        Matcher match = pattern.matcher(text);
       // List<String> list = new ArrayList<>();
        long cnt = 0;
        while (match.find()) {
            cnt++;
            //list.add(text.substring(match.start() - 2, match.end()+ 2));
        }
        return cnt;
    }


}
