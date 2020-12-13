package com.sgcai.mvvmproject.net.resp;

import java.io.Serializable;

public class CategoryTagItemBean implements Serializable {
    /**
     * banner :
     * coverImg :
     * coverUrl :
     * description :
     * icon :
     * id : 1
     * name : Jin Yong
     */

    private String banner;
    private String coverImg;
    private String coverUrl;
    private String description;
    private String icon;
    private int id;
    private String name;


    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}