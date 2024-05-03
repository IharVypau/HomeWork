package home_work_6;

import home_work_6.api.ISearchEngine;

import java.util.*;
import java.util.regex.Pattern;

public class FileDataContainer {
    private static final Pattern PATTERN = Pattern.compile("\\s*(\\s|,|!|;|:|- | -|--|=|\\*|\\)|\\(|\\?|\\.)\\s*");
    private ISearchEngine searchEngine;
    private ArrayList<String> listOfWords;
    private String text = "";

    protected FileDataContainer(String text) {
        this.text = text;
        setListOfWords();
    }

    private void setListOfWords(){
        String textStr = text.replaceAll("\"","");;
        listOfWords = new ArrayList<>(Arrays.asList(PATTERN.split(textStr)));
        listOfWords.removeIf(String::isEmpty);
    }
    public int getCountOfUsedWords(){
        Set<String> set = new TreeSet<>(listOfWords);
        return set.size();
    }
    public String getTopNWordsMostUsed(int n){
        Comparator<Map.Entry<String, Integer>> myComparator = (o1, o2) -> o2.getValue().compareTo(o1.getValue());
        HashMap<String,Integer> map = new HashMap<>();
        listOfWords.forEach( word -> map.merge(word,1,Integer::sum) );
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(myComparator);
        StringBuilder topN =new StringBuilder();
        for (int i = 0; i < n; i++) {
            topN.append(list.get(i)).append("\n");
        }
        return topN.toString();
    }

    public void setSearchEngine(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }
}
