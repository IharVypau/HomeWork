package home_work_6;

import home_work_6.api.ISearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngineCaseNormalizer implements ISearchEngine {
    private final ISearchEngine searchEngine;

    public SearchEngineCaseNormalizer(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("[^а-я]" + word + "[а-я]*");
        Matcher matcher = pattern.matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.size();
    }
}
