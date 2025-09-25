package models;


public class Address {
    private String addressId;
    private String street;
    private String area;
    private String landmark;
    private String pincode;

    public Address(String addressId, String street, String area, String landmark, String pincode) {
        this.addressId = addressId;
        this.street = street;
        this.area = area;
        this.landmark = landmark;
        this.pincode = pincode;
    }

    public String getFullAddress() {
        return street + ", " + area + ", " + landmark + " - " + pincode;
    }
}