package home_work_6.models;

import home_work_6.seachers.api.ISearchEngine;
import home_work_6.seachers.simple.EasySearch;

import java.util.*;
import java.util.regex.Pattern;

public class Book {
    private static final Pattern PATTERN = Pattern.compile("\\s*(\\s|,|!|;|:|- | -|--|=|\\*|\\)|\\(|\\?|\\.)\\s*");
    private ArrayList<String> listOfWords;
    private ISearchEngine searchEngine = new EasySearch();
    private String text = "";

    protected Book(String text) {
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
        HashMap<String,Integer> sortedMap = new HashMap<>();
        Comparator<Map.Entry<String, Integer>> myComparator = (o1, o2) -> o2.getValue().compareTo(o1.getValue());
        listOfWords.forEach( word -> sortedMap.merge(word,1,Integer::sum) );
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(sortedMap.entrySet());
        list.sort(myComparator);
        StringBuilder topN =new StringBuilder();
        for (int i = 0; i < n; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            topN.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue()).append("\n");
        }
        return topN.toString();
    }

    public long getCountMatchesWordInText(String word){
        text = "Война Падежи, склонения, и форма слова, опечатки, война  перенвойнаосы и прочие И проблемы текста";
         return searchEngine.search(text, word);
    }

    public void setSearchEngine(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }
}
