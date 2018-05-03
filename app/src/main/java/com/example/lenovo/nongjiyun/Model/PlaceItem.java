package com.example.lenovo.nongjiyun.Model;

import cn.bmob.v3.BmobObject;

public class PlaceItem extends BmobObject {
    private String placename;
public PlaceItem(){

}
    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
