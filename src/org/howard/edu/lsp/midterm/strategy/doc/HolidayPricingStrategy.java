package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Pricing strategy for holiday customers.
 * <p>
 * A 15% discount is applied to the base price.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class HolidayPricingStrategy implements PricingStrategy {

    /**
     * Returns the base price with a 15% discount applied.
     *
     * @param price the base purchase price
     * @return the price after a 15% reduction
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
