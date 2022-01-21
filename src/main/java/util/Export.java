package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dataclass for exporting statistics into a .csv file
 *
 * @author Phillip Jerebic & Marc Andri Fuchs
 * @version 1.0
 * @since 04-01-2022
 */
public class Export {
    /**
     * Function to call to export a list of {@link Measurement}
     *
     * @param data the List of Measurements to export
     * @throws IOException if some file cannot be created
     */
    public void export(ArrayList<Measurement> data) throws IOException {
        long[] samplesizes = data.stream().mapToLong(Measurement::getSampleSize).distinct().toArray();

        var exportsFolder = getExportsFolder();
        var folder = createFolder(exportsFolder);

        for (long ss : samplesizes) {
            saveFile(ss, folder, data.stream().filter(measurement -> measurement.getSampleSize() == ss).collect(Collectors.toList()));
        }
    }

    /**
     * Creates the folder to export all the files to
     *
     * @param exportsFolder the Folder in which it will be created
     * @return the created folder
     */
    private File createFolder(File exportsFolder) {
        var folder = new File(exportsFolder.getAbsolutePath() + "/export_" + new SimpleDateFormat("hh_mm_ss").format(new Date()));
        var created = folder.mkdirs();

        if (!created) {
            System.out.println("Could not create folder!");
        }

        return folder;
    }

    /**
     * Creates the 'exports' folder where all exports will be stored!
     *
     * @return the folder
     */
    private File getExportsFolder() {
        var folder = new File("exports");

        if (folder.exists()) {
            System.out.println("Exports folder already exists.");
            return folder;
        }

        var created = folder.mkdirs();

        if (!created) {
            System.out.println("Could not create Exports folder!");
        }

        return folder;
    }

    /**
     * Creates a csv file for one sample size
     *
     * @param size         the sample size of the Measurements
     * @param folder       the folder where the File will be saved
     * @param measurements the List of {@link Measurement} to export with the given sample size
     * @throws IOException if the file cannot be created
     */
    private void saveFile(long size, File folder, List<Measurement> measurements) throws IOException {
        var file = new File(folder.getAbsolutePath() + "/result_" + size + "_numbers.csv");

        var created = file.createNewFile();

        if (!created) {
            System.out.println("Could not create file!");
        }

        var fileWriter = new FileWriter(file);
        fileWriter.append("Sortername,Sample Size,Iterations,Comparisons,Time in ms,memory\n");

        for (var m : measurements) {
            fileWriter.append(String.format("%s,%s,%s,%s,%.6f,%s\n", m.getSorterName(), m.getSampleSize(), m.getIterations(), m.getComparisons(), ((double) m.getTimeInNs() / 1_000_000), m.getMemory()));
            fileWriter.flush();
        }

        fileWriter.close();
    }
}
