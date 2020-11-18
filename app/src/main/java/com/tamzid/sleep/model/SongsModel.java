package com.tamzid.sleep.model;

public class SongsModel {
    private String name;
    private int icon;
    private String time;
    private String category;
    private String Description;
    private int favorits;
    private int lestening;

    public SongsModel(String name, int icon, String time, String category, String description, int favorits, int lestening) {
        this.name = name;
        this.icon = icon;
        this.time = time;
        this.category = category;
        Description = description;
        this.favorits = favorits;
        this.lestening = lestening;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getFavorits() {
        return favorits;
    }

    public void setFavorits(int favorits) {
        this.favorits = favorits;
    }

    public int getLestening() {
        return lestening;
    }

    public void setLestening(int lestening) {
        this.lestening = lestening;
    }
}
