package com.tamzid.sleep.model;

public class HomeOptionMenuModel {

    private String title;
    private int icon_id;

    public HomeOptionMenuModel(String title, int icon_id) {
        this.title = title;
        this.icon_id = icon_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }
}
