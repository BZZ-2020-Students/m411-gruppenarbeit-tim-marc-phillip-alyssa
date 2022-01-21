package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to read input files to sort
 */
public class InputReader {
    /**
     * Gets the resources/inputfiles folder and gets its children files
     *
     * @return a list of all files in the resources/inputfiles folder
     */
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

    /**
     * Function to get the content of all the files in the folder
     *
     * @return and array of int arrays
     */
    public static int[][] getFileContent() {
        File[] files = listFiles();

        int[][] out = new int[files.length][];

        for (int i = 0; i < files.length; i++) {
            File f = files[i];

            out[i] = parseFileContent(readSingleFile(f));
        }

        return out;
    }

    /**
     * Parses a list of Strings to an Integer Array
     *
     * @param f the list to parse
     * @return the parsed int array
     */
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
