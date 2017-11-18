
package com.example.otvisa.nalaka.amica;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SetMenu {

    @SerializedName("SortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Price")
    @Expose
    private Object price;
    @SerializedName("Components")
    @Expose
    private List<String> components = null;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

}
