package org.howard.edu.lsp.finalexam.question2;


public class StudentReport extends Report {


    private String studentName;


    private double gpa;

    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }


    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
    }


    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }


    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
    }
}
