package main.java.org.lldProblemStatements.EcommerceWebsite;

public class Client {
    /*
        The online shopping service should allow users to browse products, add them to the shopping cart, and place orders.
        The system should support multiple product categories and provide search functionality.
        Users should be able to manage their profiles, view order history, and track order status.
        The system should handle inventory management and update product availability accordingly.
        The system should support multiple payment methods and ensure secure transactions.
        The system should handle concurrent user requests and ensure data consistency.
        The system should be scalable to handle a large number of products and users.
        The system should provide a user-friendly interface for a seamless shopping experience.

        Classes & Interface

        Abs class Product ...
        class ProductManagement: search Singleton ...
        abs class category: getStateTax() getCentralTax() ...
        interface Cart: // why we need it? there could be multiple types of carts that we need in future :checkout()
        ShoppingCart implements cart ...
        class CartManagement ...
        class User: profile, orderHistory, activeOrders ...
        class UserManagement Singleton ...
        abs class order
        class Order ...
        class OrderManagement Singleton ...
        enum OrderStatus: PENDING,SHIPPED,DELIVERED,CANCELLED_BY_USER,CANCELLED_BY_SELLER
        interface OrderStatus: getStatus() : status provider can change using adaptor pattern
        class DTDCOrderStatus
        class Inventory ...
        class InventoryManagement Singleton ...
        class Catalogue ...

        Catalogue -> return list of all catalogue
        catalogue item will have:
        Categories: [Products]
        FacadeClass.buy(product):
        FacadeClass.checkout(): cart that we have take all the products and create an order
     */
}
