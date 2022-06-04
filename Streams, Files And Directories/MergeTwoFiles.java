package StreamsFilesAndDirectories;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String firstFile = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondFile = "C:\\Users\\galch\\IdeaProjects\\Java Advanced - may 2022\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        PrintWriter pw = new PrintWriter("MergeResult.txt");
        List<String> firstFileList = Files.readAllLines(Path.of(firstFile));
        List<String> secondFileList = Files.readAllLines(Path.of(secondFile));
        for (String s : firstFileList) {
            pw.println(s);
        }
        for (String s : secondFileList) {
            pw.println(s);
        }
        pw.close();
    }
}
