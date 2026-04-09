package org.howard.edu.lsp.midterm.strategy.doc;


public class Driver {


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
