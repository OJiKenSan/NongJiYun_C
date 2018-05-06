package com.example.lenovo.nongjiyun.Model;

/**
 * Created by CAI on 2018/4/27.
 */

public class HomeMenu {
  private  int image;
    private Class url;
    private String name;

    public HomeMenu(int image, String name, Class url) {
        this.image = image;
        this.url = url;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
