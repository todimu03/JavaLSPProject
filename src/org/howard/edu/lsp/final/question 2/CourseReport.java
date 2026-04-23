package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report implementation for a course.
 *
 * <p>Displays the course name and enrollment count. Data is set in {@link #loadData()}
 * and used across the formatting methods.</p>
 *
 * @author Student
 * @version 1.0
 */
public class CourseReport extends Report {

    /** The name of the course. */
    private String courseName;

    /** The number of students enrolled in the course. */
    private int enrollment;

    /**
     * Loads course-specific data used in the report.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Formats the course report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    /**
     * Formats the course report body showing course name and enrollment.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Formats the course report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}
