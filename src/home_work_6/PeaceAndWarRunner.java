package home_work_6;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeaceAndWarRunner {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();
        //Pattern pattern = Pattern.compile("(\\W+\\w+)");
        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|;|:|- | -|--|=|\\*|\\)|\\(|\\?|\\.)\\s*");
        //Pattern pattern = Pattern.compile("\\s{1,}|\\s|,|!|;|:|- | -|--|=|\\*|\"|\\)|\\(|\\?|\\.");

        try (FileReader reader = new FileReader("src/home_work_6/Война и мир_книга.txt");
             BufferedReader buf = new BufferedReader(reader)
        ) {
            String line;
            while ((line = buf.readLine()) != null){
                text.append(line);
            }
        } catch (IOException e){
            System.out.println("Ошибка записи данных" +e);
        }
        String string = text.toString().replaceAll("\"","");
        LinkedList<String> textArr = new LinkedList<>(Arrays.asList(pattern.split(string)));
        textArr.removeIf(s->s.equals(""));
        Set<String> set = new TreeSet<>(textArr);
        System.out.println(textArr.size());
        System.out.println("Количество использованных слов: "+ set.size());
        System.out.print("Введите величину N (топ самых используемых слов ):");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        findTopNWordsInText(textArr,n);
    }

    public static void findTopNWordsInText(LinkedList<String> arr, int n){

        Comparator<Map.Entry<String, Integer>> myComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        HashMap<String,Integer> map = new HashMap<>();
        arr.forEach( word -> map.merge(word,1,Integer::sum) );

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(myComparator);
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }

}
