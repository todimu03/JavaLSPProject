package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Context class that uses a {@link PricingStrategy} to calculate a final price.
 * <p>
 * The strategy is supplied at construction time and can be changed at runtime
 * via {@link #setStrategy(PricingStrategy)}, allowing the pricing algorithm
 * to vary independently of the clients that use it.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class PriceCalculator {

    /** The current pricing strategy used to compute final prices. */
    private PricingStrategy strategy;

    /**
     * Constructs a {@code PriceCalculator} with the specified pricing strategy.
     *
     * @param strategy the {@link PricingStrategy} to use for price calculation
     */
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Replaces the current pricing strategy with a new one.
     *
     * @param strategy the new {@link PricingStrategy} to use
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates and returns the final price by delegating to the current strategy.
     *
     * @param price the base purchase price before any discount
     * @return the final price after the strategy's discount is applied
     */
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}
