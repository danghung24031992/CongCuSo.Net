package com.dh.congcusonet;

/**
 * Created by DH on 6/24/2015.
 */
public class NavBean {
    private String title;
    private int image;

    public NavBean() {
    }

    public NavBean(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
