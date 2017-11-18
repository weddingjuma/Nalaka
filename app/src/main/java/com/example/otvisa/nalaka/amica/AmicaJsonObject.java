
package com.example.otvisa.nalaka.amica;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmicaJsonObject {

    @SerializedName("RestaurantName")
    @Expose
    private String restaurantName;
    @SerializedName("RestaurantUrl")
    @Expose
    private String restaurantUrl;
    @SerializedName("PriceHeader")
    @Expose
    private Object priceHeader;
    @SerializedName("Footer")
    @Expose
    private String footer;
    @SerializedName("MenusForDays")
    @Expose
    private List<MenusForDay> menusForDays = null;
    @SerializedName("ErrorText")
    @Expose
    private Object errorText;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantUrl() {
        return restaurantUrl;
    }

    public void setRestaurantUrl(String restaurantUrl) {
        this.restaurantUrl = restaurantUrl;
    }

    public Object getPriceHeader() {
        return priceHeader;
    }

    public void setPriceHeader(Object priceHeader) {
        this.priceHeader = priceHeader;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<MenusForDay> getMenusForDays() {
        return menusForDays;
    }

    public void setMenusForDays(List<MenusForDay> menusForDays) {
        this.menusForDays = menusForDays;
    }

    public Object getErrorText() {
        return errorText;
    }

    public void setErrorText(Object errorText) {
        this.errorText = errorText;
    }

}
