package com.example.lenovo.nongjiyun.Model;

import cn.bmob.v3.BmobObject;

public class TypeItem extends BmobObject {
    private String typename;
    public TypeItem(){

    }



    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
