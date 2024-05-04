package home_work_6.seachers.simple;

import home_work_6.seachers.api.ISearchEngine;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        long cnt = 0;
        int fromIdx = 0, idx;
        StringBuilder sb = new StringBuilder(text);
        do{
            idx = sb.indexOf(word, fromIdx);
            fromIdx = idx + word.length();
            if( idx> -1 && !(sb.substring(idx - 1, idx).matches("[а-я]"))
                        && !(sb.substring(idx + word.length(), idx+word.length() + 1).matches("[а-я]"))){

                cnt++;
            }
        } while (idx > -1);
        return cnt;
    }
}
