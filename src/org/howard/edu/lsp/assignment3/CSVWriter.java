package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for writing transformed product records to the output CSV file.
 *
 * <p>This class encapsulates all file-output concerns, keeping them separate
 * from reading and transformation logic.</p>
 *
 * @author Student
 * @version 1.0
 */
public class CSVWriter {

    /** Path to the output CSV file. */
    private final String outputPath;

    /**
     * Constructs a CSVWriter that will write to the given file path.
     *
     * @param outputPath the relative or absolute path for the output CSV file
     */
    public CSVWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * Writes the header line and all successfully transformed products to the
     * output CSV file.
     *
     * <p>The header is the original CSV header with the additional column
     * {@code Price Range} appended.</p>
     *
     * @param header   the original header string from the input file
     * @param products the list of {@link TransformedProduct} objects to write
     * @throws IOException if an I/O error occurs while writing
     */
    public void write(String header, List<TransformedProduct> products) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(header + ",Price Range");

        for (TransformedProduct p : products) {
            lines.add(p.toCsvRow());
        }

        Files.write(Paths.get(outputPath), lines);
    }

    /**
     * Returns the absolute path of the output file, useful for display in
     * console messages.
     *
     * @return the absolute path as a string
     */
    public String getAbsoluteOutputPath() {
        return Paths.get(outputPath).toAbsolutePath().toString();
    }
}
