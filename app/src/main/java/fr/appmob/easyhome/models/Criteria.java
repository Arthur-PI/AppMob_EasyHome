package fr.appmob.easyhome.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Criteria {

    private String rooms;
    private String postal_code;
    private String city;
    private String area_max;
    private String area_min;
    private String price_min;
    private String price_max;
    private boolean property_type_house;
    private boolean property_type_apartment;
    private boolean search_type_buy;
    private boolean search_type_rent;
    private boolean modified;


    public Criteria() {
    }
    public Criteria(String postal_code,String rooms, String city, String area_min, String area_max, String price_min, String price_max, boolean property_type_house, boolean property_type_apartment, boolean search_type_buy, boolean search_type_rent) {
        this.rooms = rooms;
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
        this.modified = true;
    }



    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.modified = true;
        this.city = city;
    }

    public String getArea_max() {
        return area_max;
    }

    public void setArea_max(String area_max) {
        this.modified = true;
        this.area_max = area_max;
    }

    public String getArea_min() {
        return area_min;
    }

    public void setArea_min(String area_min) {
        this.modified = true;
        this.area_min = area_min;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.modified = true;
        this.price_min = price_min;
    }

    public String getPrice_max() {
        return price_max;
    }

    public void setPrice_max(String price_max) {
        this.modified = true;
        this.price_max = price_max;
    }

    public boolean getProperty_type_house() {
        return property_type_house;
    }

    public void setProperty_type_house(boolean property_type_house) {
        this.modified = true;
        this.property_type_house = property_type_house;
    }

    public boolean getProperty_type_apartment() {
        return property_type_apartment;
    }

    public void setProperty_type_apartment(boolean property_type_apartment) {
        this.modified = true;
        this.property_type_apartment = property_type_apartment;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.modified = true;
        this.postal_code = postal_code;
    }

    public boolean getSearch_type_buy() {
        return search_type_buy;
    }

    public void setSearch_type_buy(boolean search_type_buy) {
        this.modified = true;
        this.search_type_buy = search_type_buy;
    }

    public boolean getSearch_type_rent() {
        return search_type_rent;
    }

    public void setSearch_type_rent(boolean search_type_rent) {
        this.modified = true;
        this.search_type_rent = search_type_rent;
    }

    public boolean isNew() {
        return this.modified;
    }

    public void used(){
        this.modified = false;
    }

    public Map<String, String> getFormatedData() {
        Map<String, String> data = new HashMap<>();
        if (isValid(postal_code)) data.put("postal_codes", postal_code);
        if (isValid(city)) data.put("city", city);
        if (isValid(area_min)) data.put("area_min", area_min);
        if (isValid(area_max)) data.put("area_max", area_max);
        if (isValid(price_min)) data.put("price_min", price_min);
        if (isValid(price_max)) data.put("price_max", price_max);
        if (property_type_apartment && !property_type_house) data.put("property_type", "Apartment");
        if (!property_type_apartment && property_type_house) data.put("property_type", "House");
        if (search_type_buy && !search_type_rent) data.put("search_type", "buy");
        if (!search_type_buy && search_type_rent) data.put("search_type", "rent");
        return data;
    }

    private boolean isValid(String param) {
        return param != null && !param.trim().isEmpty();
    }

}
