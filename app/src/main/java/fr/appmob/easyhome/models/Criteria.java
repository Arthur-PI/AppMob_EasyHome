package fr.appmob.easyhome.models;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private String rooms;
    private String postal_codes;
    private String city;
    private String area_max;
    private String area_min;
    private String price_min;
    private String price_max;
    private String property_type;
    private String search_type;
    private boolean modified;


    public Criteria() {
    }
    public Criteria(String rooms, String postal_codes, String city, String area_max, String area_min, String price_min, String price_max, String property_type, String search_type) {
        this.rooms = rooms;
        this.postal_codes = postal_codes;
        this.city = city;
        this.area_max = area_max;
        this.area_min = area_min;
        this.price_min = price_min;
        this.price_max = price_max;
        this.setProperty_type(property_type);
        this.setSearch_type(search_type);
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }
    public String getSearch_type() {
        return search_type;
    }

    public void setSearch_type(String search_type) {
        this.search_type = search_type;
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

    public void setProperty_type_house(boolean property_type_house) {
        this.modified = true;
    }

    public String getPostal_codes() {
        return postal_codes;
    }

    public void setPostal_codes(String postal_codes) {
        this.modified = true;
        this.postal_codes = postal_codes;
    }

    public boolean isNew() {
        return this.modified;
    }

    public void used(){
        this.modified = false;
    }

    public Map<String, String> getFormatedData() {
        Map<String, String> data = new HashMap<>();
        if (isValid(postal_codes)) data.put("postal_codes", postal_codes);
        if (isValid(city)) data.put("city", city);
        if (isValid(area_min)) data.put("area_min", area_min);
        if (isValid(area_max)) data.put("area_max", area_max);
        if (isValid(price_min)) data.put("price_min", price_min);
        if (isValid(price_max)) data.put("price_max", price_max);
        if (isValid(property_type)) data.put("property_type", property_type);
        if (isValid(search_type)) data.put("search_type", search_type);
        return data;
    }

    private boolean isValid(String param) {
        return param != null && !param.trim().isEmpty();
    }

}
