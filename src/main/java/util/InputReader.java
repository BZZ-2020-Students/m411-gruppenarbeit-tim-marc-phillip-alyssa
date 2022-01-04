package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {
    private static File[] listFiles() {
        File folder = null;
        try {
            folder = new File(InputReader.class.getClassLoader().getResource("inputfiles").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        assert folder != null;
        return folder.listFiles();
    }

    public static int[][] getFileContent() {
        File[] files = listFiles();

        int[][] out = new int[files.length][];

        for (int i = 0; i < files.length; i++) {
            File f = files[i];

            out[i] = parseFileContent(readSingleFile(f));
        }

        return out;
    }

    private static int[] parseFileContent(List<String> f) {
        return f.stream().mapToInt(Integer::parseInt).toArray();
    }

    private static List<String> readSingleFile(File f) {
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var out = new ArrayList<String>();

        assert sc != null;
        sc.forEachRemaining(out::add);

        return out;
    }
}
