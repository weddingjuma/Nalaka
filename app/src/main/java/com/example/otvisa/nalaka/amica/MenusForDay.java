
package com.example.otvisa.nalaka.amica;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenusForDay {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("LunchTime")
    @Expose
    private Object lunchTime;
    @SerializedName("SetMenus")
    @Expose
    private List<SetMenu> setMenus = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(Object lunchTime) {
        this.lunchTime = lunchTime;
    }

    public List<SetMenu> getSetMenus() {
        return setMenus;
    }

    public void setSetMenus(List<SetMenu> setMenus) {
        this.setMenus = setMenus;
    }

}
