package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point and orchestrator for the Assignment 3 ETL pipeline.
 *
 * <p>This class coordinates the three pipeline stages — Extract, Transform,
 * Load — by delegating to specialised collaborator classes:
 * <ul>
 *   <li>{@link CSVReader} — reads and parses the input file</li>
 *   <li>{@link ProductTransformer} — applies all business rules</li>
 *   <li>{@link CSVWriter} — writes the output file</li>
 * </ul>
 *
 * <p>The program produces identical inputs, outputs, transformations, and
 * error handling to the Assignment 2 procedural solution.</p>
 *
 * @author Student
 * @version 1.0
 */
public class ETLPipelineOOP {

    /** Relative path to the input CSV file. */
    private static final String INPUT_PATH  = "data/products.csv";

    /** Relative path to the output CSV file. */
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    /**
     * Runs the ETL pipeline: reads products from the input CSV, transforms
     * each valid record, writes results to the output CSV, and prints a
     * processing summary to standard output.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        CSVReader          reader      = new CSVReader(INPUT_PATH);
        ProductTransformer transformer = new ProductTransformer();
        CSVWriter          writer      = new CSVWriter(OUTPUT_PATH);

        // --- Extract ---
        String header;
        List<Product> rawProducts;

        try {
            header      = reader.readHeader();
            rawProducts = reader.readProducts();
        } catch (NoSuchFileException e) {
            System.err.println("Error: " + INPUT_PATH
                    + " not found, program missing an input file and will terminate.");
            return;
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        // --- Transform ---
        List<TransformedProduct> transformed = new ArrayList<>();
        int rowsProcessed = 0;
        int rowsSkipped   = 0;

        for (Product product : rawProducts) {
            rowsProcessed++;

            // null means the row had the wrong number of columns
            if (product == null || !product.isValid()) {
                rowsSkipped++;
                continue;
            }

            transformed.add(transformer.transform(product));
        }

        // --- Load ---
        try {
            writer.write(header, transformed);
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
            return;
        }

        // Summary
        System.out.println("Count of total rows processed: " + rowsProcessed);
        System.out.println("Count of rows successfully transformed: " + (rowsProcessed - rowsSkipped));
        System.out.println("Count of rows skipped due to formatting errors: " + rowsSkipped);
        System.out.println("Output written to: " + writer.getAbsoluteOutputPath());
    }
}