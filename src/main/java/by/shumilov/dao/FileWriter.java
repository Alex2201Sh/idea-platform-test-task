package by.shumilov.dao;

import java.io.IOException;

public class FileWriter {
    public void writeDataToFile(String text, String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
