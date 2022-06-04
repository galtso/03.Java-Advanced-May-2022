package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathFrom = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        List<String> lines = Files.readAllLines(Path.of(pathFrom));
        for (String line : lines) {
            bw.write(line.toUpperCase());
            bw.newLine();
        }
        bw.close();
    }
}
