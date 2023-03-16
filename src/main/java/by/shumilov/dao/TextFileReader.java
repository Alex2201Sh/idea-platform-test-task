package by.shumilov.dao;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Class uses to create String from txt file.
 */
public class TextFileReader {

    /**
     * The method is used to read txt file and make String value from it.
     *
     * @return String value
     */
    public String read(String filename) {
        File file = new File(filename);
        StringBuilder result = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            result.append(line).append("\n");
        }
        return result.toString().trim();
    }
}
