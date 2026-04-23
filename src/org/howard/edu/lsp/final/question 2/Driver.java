package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class demonstrating the Template Method pattern through polymorphism.
 *
 * <p>Creates a {@code List<Report>} containing both a {@link StudentReport} and a
 * {@link CourseReport}, then iterates through the list calling {@code generateReport()}
 * on each. The caller does not need to know the concrete type of each report.</p>
 *
 * @author Student
 * @version 1.0
 */
public class Driver {

    /**
     * Main entry point. Demonstrates polymorphic report generation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}
