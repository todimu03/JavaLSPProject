package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for reading the input CSV file and parsing each data row into a
 * {@link Product} object.
 *
 * <p>This class encapsulates all file-I/O and CSV-parsing concerns, keeping
 * them separate from transformation and output logic.</p>
 *
 * @author Student
 * @version 1.0
 */
public class CSVReader {

    /** Path to the input CSV file. */
    private final String inputPath;

    /**
     * Constructs a CSVReader that will read from the given file path.
     *
     * @param inputPath the relative or absolute path to the input CSV file
     */
    public CSVReader(String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Reads the header line from the input CSV file.
     *
     * @return the first line of the file as a string
     * @throws IOException          if an I/O error occurs while reading
     * @throws NoSuchFileException  if the input file does not exist
     */
    public String readHeader() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputPath));
        return lines.isEmpty() ? "" : lines.get(0);
    }

    /**
     * Reads all data rows (skipping the header) from the input CSV file and
     * attempts to parse each into a {@link Product}.
     *
     * <p>Rows with the wrong number of columns are included in the returned
     * list as {@code null} entries so that the caller can count skipped
     * rows correctly. Rows with exactly four columns are wrapped in a
     * {@link Product}; validation is delegated to {@link Product#isValid()}.</p>
     *
     * @return a list of {@link Product} objects (or {@code null} for malformed
     *         rows), one per non-header CSV row
     * @throws IOException         if an I/O error occurs while reading
     * @throws NoSuchFileException if the input file does not exist
     */
    public List<Product> readProducts() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputPath));
        List<Product> products = new ArrayList<>();

        // Start at row 1 to skip the header
        for (int row = 1; row < lines.size(); row++) {
            String line = lines.get(row);
            String[] fields = line.split(",");

            if (fields.length != 4) {
                // Represent a structurally invalid row as null
                products.add(null);
                continue;
            }

            products.add(new Product(
                    fields[0].trim(),
                    fields[1].trim(),
                    fields[2].trim(),
                    fields[3].trim()
            ));
        }

        return products;
    }
}
