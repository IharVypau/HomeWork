package home_work_6.seachers.additional;

import home_work_6.seachers.api.ISearchEngine;

public class SearchEnginePunctuationNormalizer implements ISearchEngine {
    private final ISearchEngine searchEngine;

    public SearchEnginePunctuationNormalizer(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        text = text.replaceAll("[!|@|_|$|%|^|&|*|?|~|(|)|<|>|:|/|'|\"]"," ");
        return searchEngine.search(text, word);
    }
}
