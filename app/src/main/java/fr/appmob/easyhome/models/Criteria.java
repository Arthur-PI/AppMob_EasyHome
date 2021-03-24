package fr.appmob.easyhome;

public class Criteria {
    private String city;
    private String area_max;
    private String area_min;
    private String price_min;
    private String price_max;
    private String property_type_house;
    private String property_type_apartment;
    private String postal_code;
    private String search_type_buy;
    private String search_type_rent;

    public Criteria(String city, String area_max, String area_min, String price_min, String price_max, String property_type_house, String property_type_apartment, String postal_code, String search_type_buy, String search_type_rent) {
        this.city = city;
        this.area_max = area_max;
        this.area_min = area_min;
        this.price_min = price_min;
        this.price_max = price_max;
        this.property_type_house = property_type_house;
        this.property_type_apartment = property_type_apartment;
        this.postal_code = postal_code;
        this.search_type_buy = search_type_buy;
        this.search_type_rent = search_type_rent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea_max() {
        return area_max;
    }

    public void setArea_max(String area_max) {
        this.area_max = area_max;
    }

    public String getArea_min() {
        return area_min;
    }

    public void setArea_min(String area_min) {
        this.area_min = area_min;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.price_min = price_min;
    }

    public String getPrice_max() {
        return price_max;
    }

    public void setPrice_max(String price_max) {
        this.price_max = price_max;
    }

    public String getProperty_type_house() {
        return property_type_house;
    }

    public void setProperty_type_house(String property_type_house) {
        this.property_type_house = property_type_house;
    }

    public String getProperty_type_apartment() {
        return property_type_apartment;
    }

    public void setProperty_type_apartment(String property_type_apartment) {
        this.property_type_apartment = property_type_apartment;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getSearch_type_buy() {
        return search_type_buy;
    }

    public void setSearch_type_buy(String search_type_buy) {
        this.search_type_buy = search_type_buy;
    }

    public String getSearch_type_rent() {
        return search_type_rent;
    }

    public void setSearch_type_rent(String search_type_rent) {
        this.search_type_rent = search_type_rent;
    }
}
