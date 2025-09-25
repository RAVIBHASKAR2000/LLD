package org.example;

public enum City {
    BLR("BLR"),
    LON("LON"),
    NYC("NYC"),
    DEL("DEL"),
    PAR("PAR");

    private final String cityName;


    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public static City fromString(String cityNme) {
        for (City city : City.values()) {
            if (city.cityName.equalsIgnoreCase(cityNme)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Invalid Destination: " + cityNme);
    }
}


