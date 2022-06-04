package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        int vowels = 0;
        int punctuation = 0;
        int consonants = 0;
        String path = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'u' || currentSymbol == 'o' || currentSymbol == 'i') {
                    vowels++;
                } else if (currentSymbol == '.' || currentSymbol == ',' || currentSymbol == '!' || currentSymbol == '?') {
                    punctuation++;
                } else {
                    consonants++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        bw.write("Vowels: " + vowels);
        bw.newLine();
        bw.write("Consonants: " + consonants);
        bw.newLine();
        bw.write("Punctuation: " + punctuation);
        bw.close();
    }
}
