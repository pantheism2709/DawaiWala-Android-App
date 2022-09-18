package com.example.dawaiwala.Models;

public class medicinesModel {

    int pic;
    String price;
    String text;

    public medicinesModel(int pic, String text,String price) {
        this.price=price;
        this.pic = pic;
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
