package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class ShoppingCart {
    private HashMap<Product,Integer> cartItems;
    private String couponApplied;
    private double finalPrice;

    public ShoppingCart(){
        cartItems = new HashMap<>();
    }

    // this function should a part of coupon class but to save time and business logic we have added it here
    private boolean isValidCoupon(String coupon){
        // some logic

        return true;
    }

    public void applyCoupon(String coupon){
        if(isValidCoupon(coupon)){
            finalPrice -= 10;
        }
        else{
            System.out.println("Invalid Coupon!");
        }
    }

    public void addItem(Product product){

    }


}
