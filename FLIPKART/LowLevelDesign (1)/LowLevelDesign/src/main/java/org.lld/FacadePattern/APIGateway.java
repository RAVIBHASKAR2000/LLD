package main.java.org.lld.FacadePattern;

public class APIGateway {

    private UserManagementService user;
    private OrderManagementService order;
    private WishlistManagementService wishlist;

    public APIGateway(){
        user = new UserManagementService();
        order = new OrderManagementService();
        wishlist = new WishlistManagementService();
    }

    public void getFullUserInformation(String userID, String orderID){
        user.getUserDetails(userID);
        order.getOrderDetails(orderID);
        wishlist.getUserWishList(userID);
    }

}
