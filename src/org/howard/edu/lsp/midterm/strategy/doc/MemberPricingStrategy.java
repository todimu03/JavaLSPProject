package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Pricing strategy for member customers.
 * <p>
 * A 10% discount is applied to the base price.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class MemberPricingStrategy implements PricingStrategy {

    /**
     * Returns the base price with a 10% discount applied.
     *
     * @param price the base purchase price
     * @return the price after a 10% reduction
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
