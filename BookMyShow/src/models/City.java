package models;

public class City {
    private String cityId;
    private String cityName;
    private String state;
    private String zipCode;

    public City(String cityId, String cityName, String state, String zipCode) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters
    public String getCityId() { return cityId; }
    public String getCityName() { return cityName; }
}
