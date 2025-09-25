package main.java.org.lldProblemStatements.EcommerceWebsite;

public class Product {
    private final String description;
    private final String productName;
    private final ProductCategories category;
    private final double basePrice;

    public Product(String description, String productName, ProductCategories category, double basePrice) {
        this.description = description;
        this.productName = productName;
        this.category = category;
        this.basePrice = basePrice;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public ProductCategories getCategory() {
        return category;
    }
}
