package home_work_5.additional.generators;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class StringRandomGenerator  {
    private final static Random random = new Random();

    public static String getRandomStringFromSet(String[] set, int size){
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < size;i++){
            result.append(set[random.nextInt(set.length)]);
        }
        return result.toString();
    }

    public static String[] getRandomStringFromFile(String filePath){
        File file = new File(filePath);
        try {
            var lines = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
            return lines.toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
