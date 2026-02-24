package org.howard.edu.lsp.assignment3;

/**
 * Applies all ETL transformation rules to a validated {@link Product} and
 * returns a {@link TransformedProduct}.
 *
 * <p>Transformation rules (identical to Assignment 2 behaviour):</p>
 * <ul>
 *   <li>Product name is converted to upper case.</li>
 *   <li>Electronics items receive a 10 % discount.</li>
 *   <li>Electronics items with a final price above $500 are re-categorised
 *       as "Premium Electronics".</li>
 *   <li>A price range label is assigned: Low (&le;$10), Medium (&le;$100),
 *       High (&le;$500), or Premium (&gt;$500).</li>
 * </ul>
 *
 * @author Student
 * @version 1.0
 */
public class ProductTransformer {

    /**
     * Transforms a validated {@link Product} by applying all business rules
     * and returns the resulting {@link TransformedProduct}.
     *
     * @param product a valid product record (must pass {@link Product#isValid()})
     * @return a fully transformed product ready for output
     */
    public TransformedProduct transform(Product product) {
        String productId   = product.getProductId().trim();
        String productName = product.getProductName().trim().toUpperCase();
        String category    = product.getCategory().trim();
        double priceDecimal = Double.parseDouble(product.getPrice().trim());

        // Apply Electronics discount
        if (category.equals("Electronics")) {
            priceDecimal = priceDecimal * 0.9;
        }

        // Round to two decimal places
        double priceRounded = Math.round(priceDecimal * 100.0) / 100.0;

        // Upgrade category for expensive Electronics
        if (priceRounded > 500.00 && category.equals("Electronics")) {
            category = "Premium Electronics";
        }

        String price      = String.format("%.2f", priceRounded);
        String priceRange = assignPriceRange(priceRounded);

        return new TransformedProduct(productId, productName, price, category, priceRange);
    }

    /**
     * Assigns a price range label based on the rounded price value.
     *
     * @param price the final rounded price
     * @return "Low" if price &le; 10, "Medium" if price &le; 100,
     *         "High" if price &le; 500, or "Premium" otherwise
     */
    private String assignPriceRange(double price) {
        if (price <= 10.00) {
            return "Low";
        } else if (price <= 100.00) {
            return "Medium";
        } else if (price <= 500.00) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
