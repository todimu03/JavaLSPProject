package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GradeCalculatorTest {

    private final GradeCalculator calc = new GradeCalculator();

   
    @Test
    public void testAverageTypicalScores() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.001,
                "Average of 70, 80, 90 should be 80.0");
    }

    
    @Test
    public void testLetterGradeB() {
        assertEquals("B", calc.letterGrade(85.0),
                "Average of 85.0 should return letter grade B");
    }

   
    @Test
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(75.0),
                "Average of 75.0 should be passing");
    }

   
    @Test
    public void testIsPassingAtExactly60() {
        assertTrue(calc.isPassing(60.0),
                "Average of exactly 60.0 should be passing (boundary)");
    }


    @Test
    public void testLetterGradeAtExactly90() {
        assertEquals("A", calc.letterGrade(90.0),
                "Average of exactly 90.0 should return letter grade A (boundary)");
    }

   
    @Test
    public void testAverageThrowsOnNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(-1, 50, 50),
                "Score of -1 should throw IllegalArgumentException");
    }

    
    @Test
    public void testAverageThrowsOnScoreOver100() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(50, 101, 50),
                "Score of 101 should throw IllegalArgumentException");
    }
}
