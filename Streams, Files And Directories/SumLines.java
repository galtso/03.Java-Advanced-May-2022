package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        //Вариант 1
        /* for (String line : lines) {
            int sum = 0;
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            System.out.println(sum);
        }*/
        //Вариант 2
        lines.stream()
                .map(String::toCharArray)
                .forEach(array ->{
                    int sum = 0;
                    for (char symbol : array) {
                        sum+=symbol;
                    }
                    System.out.println(sum);
                });
    }
}
