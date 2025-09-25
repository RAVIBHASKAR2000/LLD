package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;
import java.util.List;

public class ProductCatalogue {
    private HashMap<ProductCategories, List<Product>> productsCatalogue;
    private static ProductCatalogue instance;

    private ProductCatalogue(){
        productsCatalogue = new HashMap<>();
    }

    public static ProductCatalogue getInstance(){
        if(instance==null){
            return new ProductCatalogue();
        }
        return instance;
    }

    public List<ProductCategories> getAllCategories(){
        return new ArrayList<>();
    }

    public List<Product> getAllProductsOfCategories(ProductCategories category){
        return this.productsCatalogue.get(category);
    }
}
