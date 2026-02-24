package org.howard.edu.lsp.assignment3;

/**
 * Represents a single product record loaded from the CSV input file.
 * Encapsulates all product fields and provides basic validation logic.
 *
 * <p>This class is immutable after construction; all transformations are
 * performed by {@link ProductTransformer} and stored in a new
 * {@link TransformedProduct}.</p>
 *
 * @author Student
 * @version 1.0
 */
public class Product {

    /** The unique numeric identifier of the product. */
    private final String productId;

    /** The display name of the product. */
    private final String productName;

    /** The original price string as read from the CSV. */
    private final String price;

    /** The product category (e.g. Electronics, Clothing). */
    private final String category;

    /**
     * Constructs a Product with the given field values.
     *
     * @param productId   the product's unique ID
     * @param productName the product's name
     * @param price       the raw price string
     * @param category    the product's category
     */
    public Product(String productId, String productName, String price, String category) {
        this.productId   = productId;
        this.productName = productName;
        this.price       = price;
        this.category    = category;
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
     * Returns the product name.
     *
     * @return the product name string
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Returns the raw price string.
     *
     * @return the price string as read from the CSV
     */
    public String getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     *
     * @return the category string
     */
    public String getCategory() {
        return category;
    }

    /**
     * Validates that this product record contains exactly four non-empty fields,
     * that the product ID parses as an integer, and that the price parses as a
     * double.
     *
     * @return {@code true} if the record is valid; {@code false} otherwise
     */
    public boolean isValid() {
        if (productId.isEmpty() || productName.isEmpty() || price.isEmpty() || category.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(productId.trim());
        } catch (NumberFormatException e) {
            return false;
        }
        try {
            Double.parseDouble(price.trim());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
