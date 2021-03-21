package fr.appmob.easyhome.models;

public class Advert {
    private String url, unique_id, title,ads_type, area, bedrooms, city, published_at, description, elevator, furnished, images_url[], latitude, longitude, others[], postal_code, price, property_type, rooms;

    public Advert(String url, String unique_id, String title, String ads_type, String area, String bedrooms, String city, String published_at, String description, String elevator, String furnished, String[] images_url, String latitude, String longitude, String[] others, String postal_code, String price, String property_type, String rooms) {
        this.url = url;
        this.unique_id = unique_id;
        this.title = title;
        this.ads_type = ads_type;
        this.area = area;
        this.bedrooms = bedrooms;
        this.city = city;
        this.published_at = published_at;
        this.description = description;
        this.elevator = elevator;
        this.furnished = furnished;
        this.images_url = images_url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.others = others;
        this.postal_code = postal_code;
        this.price = price;
        this.property_type = property_type;
        this.rooms = rooms;
    }

    public Advert() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAds_type() {
        return ads_type;
    }

    public void setAds_type(String ads_type) {
        this.ads_type = ads_type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getFurnished() {
        return furnished;
    }

    public void setFurnished(String furnished) {
        this.furnished = furnished;
    }

    public String[] getImages_url() {
        return images_url;
    }

    public void setImages_url(String[] images_url) {
        this.images_url = images_url;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String[] getOthers() {
        return others;
    }

    public void setOthers(String[] others) {
        this.others = others;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }
}
