package in.rohaan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) throws IOException {
        writeToFile("passwords.txt", "Some text");
        writeToFile("passwords.txt", "Some More text");
        writeToFile("passwords.txt", "Other text");
    }

    private static void writeToFile(final String filePathName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(filePathName, true); // Set append=true
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(text);
        printWriter.close();
    }
}
