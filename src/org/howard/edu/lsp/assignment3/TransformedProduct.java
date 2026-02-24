package org.howard.edu.lsp.assignment3;

/**
 * Represents a fully transformed product record ready to be written to the
 * output CSV file.
 *
 * <p>A {@code TransformedProduct} is produced by {@link ProductTransformer}
 * after applying all business rules (discount, category upgrade, name
 * normalisation, price range label) to a validated {@link Product}.</p>
 *
 * @author Student
 * @version 1.0
 */
public class TransformedProduct {

    /** The product's unique numeric ID (unchanged from input). */
    private final String productId;

    /** The product name, converted to upper case. */
    private final String productName;

    /** The final price, formatted to two decimal places. */
    private final String price;

    /** The final category (may be upgraded to "Premium Electronics"). */
    private final String category;

    /** The price range label: Low, Medium, High, or Premium. */
    private final String priceRange;

    /**
     * Constructs a TransformedProduct with all output fields.
     *
     * @param productId   the product ID
     * @param productName the upper-cased product name
     * @param price       the formatted final price
     * @param category    the (possibly upgraded) category
     * @param priceRange  the price range label
     */
    public TransformedProduct(String productId, String productName,
                              String price, String category, String priceRange) {
        this.productId   = productId;
        this.productName = productName;
        this.price       = price;
        this.category    = category;
        this.priceRange  = priceRange;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID string
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Returns the upper-cased product name.
     *
     * @return the transformed product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Returns the formatted price string.
     *
     * @return the price formatted to two decimal places
     */
    public String getPrice() {
        return price;
    }

    /**
     * Returns the final category.
     *
     * @return the category string, which may have been upgraded
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price range label.
     *
     * @return one of "Low", "Medium", "High", or "Premium"
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Formats this transformed product as a CSV row suitable for writing to
     * the output file.
     *
     * @return a comma-separated string of all five fields
     */
    public String toCsvRow() {
        return String.join(",", productId, productName, price, category, priceRange);
    }
}
