package util;

/**
 * Dataclass for exporting
 *
 * @author Phillip William Jerebic
 * @version 1.0
 * @since 04-01-2022
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Export {

    public void export(ArrayList<Measurement> data) throws IOException {
        File file = null;
        file = new File("export_measurements.csv");
        file.createNewFile();
        assert file != null;
        FileWriter writer = new FileWriter(file);

        writer.append("sortername,samplesize,iterations,comparisons,time,memory\n");
        for (Measurement m : data) {
            writer.append(String.format("%s,%s,%s,%s,%s,%s\n", m.getSorterName(), m.getSampleSize(), m.getIterations(), m.getComparisons(), m.getTime(), m.getMemory()));
            writer.flush();
        }
        writer.close();

    }


}
