package org.howard.edu.lsp.midterm.strategy.doc;


public class HolidayPricingStrategy implements PricingStrategy {


    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
