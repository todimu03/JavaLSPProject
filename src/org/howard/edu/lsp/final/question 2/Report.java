package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class implementing the Template Method pattern for report generation.
 *
 * <p>The {@link #generateReport()} method defines a fixed workflow that all subclasses
 * must follow. Subclasses override the abstract step methods to provide report-specific
 * behavior without altering the overall algorithm structure.</p>
 *
 * @author Student
 * @version 1.0
 */
public abstract class Report {

    /**
     * Template method that defines the fixed report generation workflow.
     * This method is final and cannot be overridden by subclasses.
     * The workflow is: loadData → formatHeader → formatBody → formatFooter.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();
        System.out.println("=== BODY ===");
        formatBody();
        System.out.println("=== FOOTER ===");
        formatFooter();
        System.out.println();
    }

    /**
     * Loads report-specific data. Must be implemented by each subclass.
     */
    protected abstract void loadData();

    /**
     * Formats and prints the report header. Must be implemented by each subclass.
     */
    protected abstract void formatHeader();

    /**
     * Formats and prints the report body. Must be implemented by each subclass.
     */
    protected abstract void formatBody();

    /**
     * Formats and prints the report footer. Must be implemented by each subclass.
     */
    protected abstract void formatFooter();
}
