package com.example.javaprojectfxml;

import java.util.ArrayList;
import java.util.List;

public class MovieSearch {
    static Movie SearchName(String moviename, List<Movie> searchlist) {

        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getMovieName().equalsIgnoreCase(moviename)) {
                return m;
            }
        }
        return null;
    }

    static List Releaseyear(int year, List<Movie> searchlist) {

        List<Movie> A = new ArrayList<Movie>();

        for (int i = 0; i < searchlist.size(); i++) {

            Movie m = searchlist.get(i);
            if (year == searchlist.get(i).getYear()) {
                A.add(m);
            }
        }
        return A;
    }

    static List Genre(String genre, List<Movie> searchlist) {
        List<Movie> A = new ArrayList<Movie>();

        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getGenre1().equalsIgnoreCase(genre) || m.getGenre2().equalsIgnoreCase(genre) || m.getGenre3().equalsIgnoreCase(genre)) {
                A.add(m);
            }
        }
        return A;
    }

    static List Production(String productioncompany, List<Movie> searchlist) {
        List<Movie> A = new ArrayList<Movie>();
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                A.add(m);
            }
        }
        return A;
    }

    static List RunningTime(long runningtime,long runningtime1, List<Movie> searchlist) {

        List<Movie> A = new ArrayList<Movie>();

        for (int i = 0; i < searchlist.size(); i++) {

            if (searchlist.get(i).getRunningtime() >=runningtime && searchlist.get(i).getRunningtime() <=runningtime1) {
                A.add(searchlist.get(i));
            }
        }
        return A;
    }

    static List TopTenMovies(List<Movie> searchlist) {

        int num = 0;
        long[] diff = new long[100];
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            diff[num] = (m.getRevenue() - m.getBudget());
            num++;
        }

        long temp;
        for (int j = 0; j < diff.length; j++) {
            for (int k = j; k < diff.length; k++) {
                if (diff[j] < diff[k]) {
                    temp = diff[j];
                    diff[j] = diff[k];
                    diff[k] = temp;
                }
            }
        }
        List<Movie> A = new ArrayList<Movie>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < searchlist.size(); j++) {
                Movie m = searchlist.get(j);
                {
                    if (diff[i] == (m.getRevenue() - m.getBudget())) {
                        A.add(m);
                    }
                }
            }
        }
        return A;
    }
}
