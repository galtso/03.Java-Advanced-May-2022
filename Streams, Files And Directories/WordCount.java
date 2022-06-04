package StreamsFilesAndDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String words = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String text = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        Map<String, Integer> wordsMap = new HashMap<>();
        List<String> wordsToCheck = Files.readAllLines(Path.of(words));
        for (String s : wordsToCheck) {
            Arrays.stream(s.split("\\s+")).forEach(word -> wordsMap.put(word, 0));
        }

        List<String> textToCheck = Files.readAllLines(Path.of(text));
        for (String s : textToCheck) {
            Arrays.stream(s.split("\\s+")).forEach(word -> {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            });
        }
        PrintWriter pw = new PrintWriter(new FileWriter("result.txt"));
        wordsMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> pw.println(entry.getKey() + " - " + entry.getValue()));
        pw.close();
    }
}
