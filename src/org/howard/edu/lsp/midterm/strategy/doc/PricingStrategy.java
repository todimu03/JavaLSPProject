package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Strategy interface for pricing algorithms.
 * <p>
 * Each concrete implementation encapsulates a different discount rule
 * for a particular customer type.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public interface PricingStrategy {

    /**
     * Calculates and returns the final price for a purchase.
     *
     * @param price the base purchase price before any discount
     * @return the final price after applying this strategy's discount
     */
    double calculatePrice(double price);
}
