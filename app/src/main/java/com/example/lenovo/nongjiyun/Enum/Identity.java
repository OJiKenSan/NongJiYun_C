package com.example.lenovo.nongjiyun.Enum;

public enum Identity {
    One("科教管理人员", 0),Two("农技推广人员",1),
    Three("科研院校人员",2),Four("农口工作人员",3),
    Five("基层行政管理人员",4),Six("合作社",5),
    Seven("家庭农场",6),Eight("企业",7),
    Nine("普通农户",8),Ten("农民经纪人",9),
    Elv("其他",10),Twe("专家",11)


    ;
    private int index;
    private String identityName;

    private Identity(String identityName, int index) {
        this.identityName = identityName;
        this.index = index;
    }

    public static String getidentityName(int index) {
        for (Identity iden : Identity.values()) {
            if (iden.getIndex() == index) {
                return iden.name();
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

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }
}
