package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for {@link GradeCalculator}.
 * Covers average(), letterGrade(), isPassing(), boundary values, and exception cases.
 */
public class GradeCalculatorTest {

    private final GradeCalculator calc = new GradeCalculator();

    // -----------------------------------------------------------------------
    // 1. Test for average()
    // -----------------------------------------------------------------------

    /** Verifies that average() returns the correct arithmetic mean of three typical scores. */
    @Test
    public void testAverageTypicalScores() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.001,
                "Average of 70, 80, 90 should be 80.0");
    }

    // -----------------------------------------------------------------------
    // 2. Test for letterGrade()
    // -----------------------------------------------------------------------

    /** Verifies that an average of 85 maps to letter grade B. */
    @Test
    public void testLetterGradeB() {
        assertEquals("B", calc.letterGrade(85.0),
                "Average of 85.0 should return letter grade B");
    }

    // -----------------------------------------------------------------------
    // 3. Test for isPassing()
    // -----------------------------------------------------------------------

    /** Verifies that an average well above 60 is considered passing. */
    @Test
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(75.0),
                "Average of 75.0 should be passing");
    }

    // -----------------------------------------------------------------------
    // 4a. Boundary value — exactly 60 (lowest passing score)
    // -----------------------------------------------------------------------

    /** Verifies that an average of exactly 60 is the boundary for passing. */
    @Test
    public void testIsPassingAtExactly60() {
        assertTrue(calc.isPassing(60.0),
                "Average of exactly 60.0 should be passing (boundary)");
    }

    // -----------------------------------------------------------------------
    // 4b. Boundary value — exactly 90 (lowest score for grade A)
    // -----------------------------------------------------------------------

    /** Verifies that an average of exactly 90 maps to letter grade A (lower boundary of A). */
    @Test
    public void testLetterGradeAtExactly90() {
        assertEquals("A", calc.letterGrade(90.0),
                "Average of exactly 90.0 should return letter grade A (boundary)");
    }

    // -----------------------------------------------------------------------
    // 5a. Exception test — score below 0
    // -----------------------------------------------------------------------

    /** Verifies that a negative score throws IllegalArgumentException. */
    @Test
    public void testAverageThrowsOnNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(-1, 50, 50),
                "Score of -1 should throw IllegalArgumentException");
    }

    // -----------------------------------------------------------------------
    // 5b. Exception test — score above 100
    // -----------------------------------------------------------------------

    /** Verifies that a score greater than 100 throws IllegalArgumentException. */
    @Test
    public void testAverageThrowsOnScoreOver100() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(50, 101, 50),
                "Score of 101 should throw IllegalArgumentException");
    }
}
