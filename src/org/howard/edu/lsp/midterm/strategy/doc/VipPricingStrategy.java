package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Pricing strategy for VIP customers.
 * <p>
 * A 20% discount is applied to the base price.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class VipPricingStrategy implements PricingStrategy {

    /**
     * Returns the base price with a 20% discount applied.
     *
     * @param price the base purchase price
     * @return the price after a 20% reduction
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
