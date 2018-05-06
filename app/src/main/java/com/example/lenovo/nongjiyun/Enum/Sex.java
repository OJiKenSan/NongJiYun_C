package com.example.lenovo.nongjiyun.Enum;

public enum  Sex {
    One("男",1),Two("女",2);
    private int index;
    private String sexName;

    private Sex(String sexName,int index){
        this.sexName=sexName;
        this.index=index;
    }
    public static String getSexName(int index){
        for (Sex c : Sex.values()) {
            if (c.getIndex() == index) {
                return c.sexName;
            }
        }
        return null;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
