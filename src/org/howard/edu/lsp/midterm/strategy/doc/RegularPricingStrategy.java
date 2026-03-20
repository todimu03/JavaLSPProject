package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Pricing strategy for regular customers.
 * <p>
 * No discount is applied; the price is returned unchanged.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class RegularPricingStrategy implements PricingStrategy {

    /**
     * Returns the base price with no discount applied.
     *
     * @param price the base purchase price
     * @return the original price, unchanged
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
