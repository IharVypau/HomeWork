package home_work_6.seachers.simple;

import home_work_6.seachers.api.ISearchEngine;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        long cnt =0;
        while(text.contains(word)){
            cnt++;
            text = text.substring(text.indexOf(word) + word.length());
        }
        return cnt;
    }
}
