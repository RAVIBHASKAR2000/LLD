package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class AmazonFacadeController {
    private InventoryManagement inventoryManagement;
    private ProductCatalogue productCatalogue;
    private UserManagement userManagement;
    

    public AmazonFacadeController(){
        inventoryManagement = InventoryManagement.getInstance();
        productCatalogue = ProductCatalogue.getInstance();
    }

    public List<Product> getAllProduct(ProductCategories category){
        return productCatalogue.getAllProductsOfCategories(category);
    }

    public Product searchProduct(String productName){
        // add logic for it
        // if optimization is required then user a hashmap

        return new Product("","",ProductCategories.CLOTHES,10.0);
    }

    public void addUser(User user){
        userManagement.addUser(user);
    }

    public void removeUser(User user){
        userManagement.removeUser(user);
    }

    public void checkoutCart(){
        //
    }
}
