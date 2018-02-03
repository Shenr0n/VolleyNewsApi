package com.example.shenron.news1;

/**
 * Created by Shenron on 03-02-2018.
 */

public class News {
    String class_title;
    String class_description;
    String class_published;
    String class_img_url;

    public String getClass_img_url() {
        return class_img_url;
    }

    public void setClass_img_url(String class_img_url) {
        this.class_img_url = class_img_url;
    }


    public News(String class_title, String class_description, String class_published, String class_img_url) {
        this.class_title = class_title;
        this.class_description = class_description;
        this.class_published = class_published;
        this.class_img_url = class_img_url;
    }

    public String getClass_title() {
        return class_title;
    }

    public void setClass_title(String class_title) {
        this.class_title = class_title;
    }

    public String getClass_description() {
        return class_description;
    }

    public void setClass_description(String class_description) {
        this.class_description = class_description;
    }

    public String getClass_published() {
        return class_published;
    }

    public void setClass_published(String class_published) {
        this.class_published = class_published;
    }

}
