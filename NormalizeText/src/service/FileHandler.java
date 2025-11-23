package service;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    // Đọc file
    public static String readFile(String filePath) throws IOException {
        StringBuffer content = new StringBuffer();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
                //System.lineSeparator == \n
            }
        }
        return content.toString();
    }

    // Ghi file
    public static void writeFile(String filePath, String content) throws IOException {
        String normalizedLineEndings = content.replace("\n", System.lineSeparator());
        Files.write(Paths.get(filePath), normalizedLineEndings.getBytes());
    }
}

