package util;

import java.io.FileWriter;
import java.io.IOException;

public class SampleFileGenerator {
    private static final int size = 100000;

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(size + "Digits.dat");

        for (int i = 0; i < size; i++) {
            var rand = (int) (Math.random() * size);
            fw.append(String.valueOf(rand)).append("\n");
        }

        fw.flush();
    }
}
