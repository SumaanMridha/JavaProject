package com.example.javaprojectfxml;

import java.io.Serializable;

public class ADDMOVIE implements Serializable {
    public static ADDMOVIE addd;
    private String moviename;
    private int year;
    private String genre1;
    private String genre2;
    private String genre3;
    private  long runningtime;
    private String productioncompany;
    private long budget;
    private long revenue;
    public String getMovieName() {
        return moviename;
    }

    public int getYear() {
        return year;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public long getRunningtime() {
        return runningtime;
    }

    public String getProductioncompany() {
        return productioncompany;
    }

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public void setRunningtime(long runningtime) {
        this.runningtime = runningtime;
    }

    public void setProductioncompany(String productioncompany) {
        this.productioncompany = productioncompany;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}


