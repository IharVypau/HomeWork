package home_work_6.seachers.simple;

import home_work_6.seachers.api.ISearchEngine;
import java.util.regex.Pattern;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]");
        long cnt = 0;
        int fromIdx = 0, idx;
        StringBuilder sb = new StringBuilder(text);
        do {
            idx = sb.indexOf(word, fromIdx);
            fromIdx = idx + word.length();
            if (idx > 0
                    && !pattern.matcher(sb.substring(idx - 1, idx)).find()
                    && idx + word.length() < text.length()
                    && !pattern.matcher(sb.substring(idx + word.length(), idx + word.length() + 1)).find()
                    || idx == 0
                    || idx + word.length() == text.length()) {

                cnt++;
            }
        } while (idx > -1);
        return cnt;
    }
}
