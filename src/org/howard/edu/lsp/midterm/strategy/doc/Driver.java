package org.howard.edu.lsp.midterm.strategy.doc;

/**
 * Driver class demonstrating the Strategy Pattern implementation
 * of {@link PriceCalculator}.
 * <p>
 * Exercises all four pricing strategies with a base purchase price of 100.0
 * and prints results in the required format.
 * </p>
 *
 * @author Student
 * @version 1.0
 */
public class Driver {

    /**
     * Entry point for the Strategy Pattern demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        double basePrice = 100.0;

        PriceCalculator calculator = new PriceCalculator(new RegularPricingStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new MemberPricingStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new VipPricingStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new HolidayPricingStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(basePrice));
    }
}
