package com.example.bottom_bar.Model;

public class HomepageModel {

    private int image;
    private String barname;
    private String bardistance;
    private String barrating;
    private String barcondition;
    private String barreview;

    public HomepageModel( int image, String barname, String bardistance, String barrating, String barcondition, String barreview) {
        this.image = image;
        this.barname = barname;
        this.bardistance = bardistance;
        this.barrating = barrating;
        this.barcondition = barcondition;
        this.barreview = barreview;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBarname() {
        return barname;
    }

    public void setBarname(String barname) {
        this.barname = barname;
    }

    public String getBardistance() {
        return bardistance;
    }

    public void setBardistance(String bardistance) {
        this.bardistance = bardistance;
    }

    public String getBarrating() {
        return barrating;
    }

    public void setBarrating(String barrating) {
        this.barrating = barrating;
    }

    public String getBarcondition() {
        return barcondition;
    }

    public void setBarcondition(String barcondition) {
        this.barcondition = barcondition;
    }

    public String getBarreview() {
        return barreview;
    }

    public void setBarreview(String barreview) {
        this.barreview = barreview;
    }
}
