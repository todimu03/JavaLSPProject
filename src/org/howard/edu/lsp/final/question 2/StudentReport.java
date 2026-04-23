package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report implementation for a student.
 *
 * <p>Displays the student's name and GPA. Data is set in {@link #loadData()}
 * and used across the formatting methods.</p>
 *
 * @author Student
 * @version 1.0
 */
public class StudentReport extends Report {

    /** The student's full name. */
    private String studentName;

    /** The student's grade point average. */
    private double gpa;

    /**
     * Loads student-specific data used in the report.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Formats the student report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
    }

    /**
     * Formats the student report body showing name and GPA.
     */
    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }

    /**
     * Formats the student report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
    }
}
