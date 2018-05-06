package com.example.lenovo.nongjiyun.Model;

import java.util.List;

public class Question {

    private String xm;
    private String dz1;
    private String dz2;
    private String cg;
    private String qt1;
    private String qt2;
    private String rq;
    private String hd;
    private int pic;
    private int pic1;




    public Question(String xm, String dz1, String dz2, String cg, String qt1, String qt2, String rq, String hd, int pic, int pic1, int pic2) {
        this.xm = xm;
        this.dz1 = dz1;
        this.dz2 = dz2;
        this.cg = cg;
        this.qt1 = qt1;
        this.qt2 = qt2;
        this.rq = rq;
        this.hd = hd;
        this.pic = pic;
        this.pic1 = pic1;
    }

    public int getPic1() {
        return pic1;
    }

    public void setPic1(int pic1) {
        this.pic1 = pic1;
    }



    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }



    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getDz1() {
        return dz1;
    }

    public void setDz1(String dz1) {
        this.dz1 = dz1;
    }

    public String getDz2() {
        return dz2;
    }

    public void setDz2(String dz2) {
        this.dz2 = dz2;
    }

    public String getCg() {
        return cg;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    public String getQt1() {
        return qt1;
    }

    public void setQt1(String qt1) {
        this.qt1 = qt1;
    }

    public String getQt2() {
        return qt2;
    }

    public void setQt2(String qt2) {
        this.qt2 = qt2;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }


    public Question(){

    }



}


