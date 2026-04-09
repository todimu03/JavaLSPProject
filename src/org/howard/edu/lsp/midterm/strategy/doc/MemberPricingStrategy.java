package org.howard.edu.lsp.midterm.strategy.doc;


public class MemberPricingStrategy implements PricingStrategy {



    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
