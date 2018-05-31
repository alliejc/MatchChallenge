
package com.alisonjc.matchchallenge.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("enemy")
    @Expose
    private Integer enemy;
    @SerializedName("relative")
    @Expose
    private Float relative;
    @SerializedName("last_login")
    @Expose
    private Integer lastLogin;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("match")
    @Expose
    private Integer match;
    @SerializedName("gender_tags")
    @Expose
    private List<Object> genderTags = null;
    @SerializedName("liked")
    @Expose
    private Boolean liked;
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    @SerializedName("orientation")
    @Expose
    private Integer orientation;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("state_name")
    @Expose
    private String stateName;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("friend")
    @Expose
    private Integer friend;
    @SerializedName("is_online")
    @Expose
    private Integer isOnline;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("stoplight_color")
    @Expose
    private String stoplightColor;
    @SerializedName("last_contact_time")
    @Expose
    private List<Integer> lastContactTime = null;
    @SerializedName("orientation_tags")
    @Expose
    private List<Object> orientationTags = null;
    private Boolean hasTimer = false;

    public Integer getEnemy() {
        return enemy;
    }

    public void setEnemy(Integer enemy) {
        this.enemy = enemy;
    }

    public Float getRelative() {
        return relative;
    }

    public void setRelative(Float relative) {
        this.relative = relative;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }

    public List<Object> getGenderTags() {
        return genderTags;
    }

    public void setGenderTags(List<Object> genderTags) {
        this.genderTags = genderTags;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getFriend() {
        return friend;
    }

    public void setFriend(Integer friend) {
        this.friend = friend;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStoplightColor() {
        return stoplightColor;
    }

    public void setStoplightColor(String stoplightColor) {
        this.stoplightColor = stoplightColor;
    }

    public List<Integer> getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(List<Integer> lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public List<Object> getOrientationTags() {
        return orientationTags;
    }

    public void setOrientationTags(List<Object> orientationTags) {
        this.orientationTags = orientationTags;
    }

    public Boolean getHasTimer() {
        return hasTimer;
    }

    public void setHasTimer(Boolean hasTimer) {
        this.hasTimer = hasTimer;
    }
}
