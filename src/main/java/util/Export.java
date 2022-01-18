package util;

/**
 * Dataclass for exporting statistics into a .csv file
 *
 * @author Phillip Jerebic
 * @version 1.0
 * @since 04-01-2022
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Export {
    private static final String DEFAULT_FILE_NAME = "export_measurements_";
    private static final String DEFAULT_FILE_ENDING = ".csv";

    public void export(ArrayList<Measurement> data) throws IOException {
        File file = new File(DEFAULT_FILE_NAME + new SimpleDateFormat("yyyy_MM_dd-hh_mm_ss").format(new Date()) + DEFAULT_FILE_ENDING);
        boolean createdFile = file.createNewFile();

        if (!createdFile) {
            System.out.println("File already exists -> Overwriting...");
        }

        FileWriter writer = new FileWriter(file);

        writer.append(",sortername,samplesize,iterations,comparisons,timeInNs,timeInMs,memory\n");

        long[] samplesizes = data.stream().mapToLong(Measurement::getSampleSize).distinct().toArray();

        for (long ss : samplesizes) {
            writer.append("Samplesize:").append(String.valueOf(ss)).append("\n");
            data.stream().filter(measurement -> measurement.getSampleSize() == ss)
                    .forEach(m -> {
                        try {
                            writer.append(String.format(",%s,%s,%s,%s,%s ns,%s ms,%s\n", m.getSorterName(), m.getSampleSize(), m.getIterations(), m.getComparisons(), String.format("%,d", m.getTimeInNs()).replace(",", "'"),String.format("%,d", m.getTimeInMs()), m.getMemory()));
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }

        writer.close();

        System.out.println("\n");

        System.out.println("Completed writing file: " + file.getAbsolutePath());
    }
}
