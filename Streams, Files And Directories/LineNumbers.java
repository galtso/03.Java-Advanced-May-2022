package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        int count = 1;
        BufferedWriter bw = new BufferedWriter(new FileWriter("Line Numbers.txt"));
        for (String line : lines) {
            bw.write(count + ". " + line);
            bw.newLine();
            count++;
        }
        bw.close();
    }
}
