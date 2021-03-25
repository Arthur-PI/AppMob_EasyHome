package fr.appmob.easyhome.models;

import java.util.Arrays;

public class Advert {
    private String ads_type, area, city, rooms, bedrooms, title, description, postal_code;
    private String longitude, latitude, agency_name, floor;
    private String images_url[], website, property_type, site_id, published_at, created_at;
    private String geoloc_prob, duplicate, unique_id, url;
    private boolean agency, coloc_friendly, elevator, furnished, is_new, sous_loc, short_term, anomaly_detected;
    private int price;

    public String getAds_type() {
        return ads_type;
    }

    public void setAds_type(String ads_type) {
        this.ads_type = ads_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String[] getImages_url() {
        return images_url;
    }

    public void setImages_url(String[] images_url) {
        this.images_url = images_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getGeoloc_prob() {
        return geoloc_prob;
    }

    public void setGeoloc_prob(String geoloc_prob) {
        this.geoloc_prob = geoloc_prob;
    }

    public String getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(String duplicate) {
        this.duplicate = duplicate;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAgency() {
        return agency;
    }

    public void setAgency(boolean agency) {
        this.agency = agency;
    }

    public boolean isColoc_friendly() {
        return coloc_friendly;
    }

    public void setColoc_friendly(boolean coloc_friendly) {
        this.coloc_friendly = coloc_friendly;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public boolean isIs_new() {
        return is_new;
    }

    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
    }

    public boolean isSous_loc() {
        return sous_loc;
    }

    public void setSous_loc(boolean sous_loc) {
        this.sous_loc = sous_loc;
    }

    public boolean isShort_term() {
        return short_term;
    }

    public void setShort_term(boolean short_term) {
        this.short_term = short_term;
    }

    public boolean isAnomaly_detected() {
        return anomaly_detected;
    }

    public void setAnomaly_detected(boolean anomaly_detected) {
        this.anomaly_detected = anomaly_detected;
    }

    public Advert() { }

    @Override
    public String toString() {
        return "Advert{" +
                "ads_type='" + ads_type + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", rooms='" + rooms + '\'' +
                ", bedrooms='" + bedrooms + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", agency_name='" + agency_name + '\'' +
                ", floor='" + floor + '\'' +
                ", images_url=" + Arrays.toString(images_url) +
                ", website='" + website + '\'' +
                ", property_type='" + property_type + '\'' +
                ", site_id='" + site_id + '\'' +
                ", published_at='" + published_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", geoloc_prob='" + geoloc_prob + '\'' +
                ", duplicate='" + duplicate + '\'' +
                ", unique_id='" + unique_id + '\'' +
                ", url='" + url + '\'' +
                ", agency=" + agency +
                ", coloc_friendly=" + coloc_friendly +
                ", elevator=" + elevator +
                ", furnished=" + furnished +
                ", is_new=" + is_new +
                ", sous_loc=" + sous_loc +
                ", short_term=" + short_term +
                ", anomaly_detected=" + anomaly_detected +
                ", price=" + price +
                '}';
    }
}
