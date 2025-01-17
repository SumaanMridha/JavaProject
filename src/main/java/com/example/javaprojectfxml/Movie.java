package com.example.javaprojectfxml;

import java.io.Serializable;

public class Movie implements Serializable {
    private String moviename;
    private int year;
    private String genre1;
    private String genre2;
    private String genre3;
    private  long runningtime;
    private String productioncompany;
    private long budget;
    private long revenue;

    public Movie(String MovieName, int Year, String Genre1, String Genre2, String Genre3, long RunningTime, String ProductionCompany, long Budget, long Revenue) {
        this.moviename = MovieName;
        this.year = Year;
        this.genre1 = Genre1;
        this.genre2 = Genre2;
        this.genre3 = Genre3;
        this.runningtime = RunningTime;
        this.productioncompany = ProductionCompany;
        this.budget = Budget;
        this.revenue = Revenue;

    }

    public Movie() {

    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public void setProductioncompany(String productioncompany) {
        this.productioncompany = productioncompany;
    }

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
}
