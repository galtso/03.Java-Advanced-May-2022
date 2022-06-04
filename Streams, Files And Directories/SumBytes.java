package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
        // 1-ви начин
        /*BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        while (line != null) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            line = br.readLine();
        }*/

        // 2-ри начин
        byte[] allBytes = Files.readAllBytes(Path.of(path));
        for (byte singleByte : allBytes) {
            if (singleByte != 10 && singleByte != 13) {
                sum += singleByte;
            }
        }
        System.out.println(sum);
    }
}
