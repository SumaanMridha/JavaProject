package com.example.javaprojectfxml;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class SearchProductionCompany {
    static List ProductionCompanyName(String productioncompany, List<Movie> searchlist) {
        List<Movie> A = new ArrayList<Movie>();
        int searchIndex = 0;
        int num = 0;
        int[] releaseyear = new int[500];
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                 searchIndex = 1;
                releaseyear[num] = m.getYear();
                 num++;
            }

        }


        int max = releaseyear[0];
        for (int j = 0; j < releaseyear.length; j++) {
            if (releaseyear[j] > max) {
                max = releaseyear[j];
            }
        }

        for (int k = 0; k < searchlist.size(); k++) {
            Movie m = searchlist.get(k);
            {
                if (max == m.getYear() && m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                    A.add(m);
                   // return Collections.singletonList(A.add(m));
                   // System.out.println(m.getMovieName() + ", " + m.getYear() + ", " + m.getGenre1() + ", " + m.getGenre2() + ", " + m.getGenre3() + ", " + m.getRunningtime() + ", " + m.getProductioncompany() + ", " + m.getBudget() + ", " + m.getRevenue());
                }
            }
        }

        return A;
    }
    static List ProductionCompanyName1(String productioncompany, List<Movie> searchlist) {
        List<Movie>A=new ArrayList<Movie>();
        int searchIndex = 0;
        int num = 0;
        long[] revenue = new long[500];
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                searchIndex = 1;
                revenue[num] = m.getRevenue();
                num++;

            }
        }
        long max = revenue[0];
        for (int j = 0; j < revenue.length; j++) {
            if (revenue[j] > max) {
                max = revenue[j];

            }
        }
        for (int k = 0; k < searchlist.size(); k++) {
            Movie m = searchlist.get(k);
            {

                if (max == m.getRevenue() && m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                    A.add(m);

                }

            }
        }
            return A;
        }

    static long ProductionCompanyName2(String productioncompany, List<Movie> searchlist) {
        int searchIndex = 0;
        long TotalProfit = 0;
        long profit1 = 0;
        long P[] = new long[500];
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            if (m.getProductioncompany().equalsIgnoreCase(productioncompany)) {
                searchIndex = 1;
                profit1 = (m.getRevenue() - m.getBudget());
                profit1++;
                P[i] = profit1;

            }

        }
        for (int j = 0; j < P.length; j++) {
            TotalProfit = TotalProfit + P[j];

        }

        return TotalProfit;
    }

    static List ProductionCompany( List<Movie> searchlist) {
        List<String>A =new ArrayList<String>();
        int num = 0;
        String[] PDC = new String[100];
        for (int i = 0; i < searchlist.size(); i++) {
            Movie m = searchlist.get(i);
            PDC[num] = m.getProductioncompany();
            num++;

            }
        int [] fre=new int [PDC.length];
        int visited=-1;
        for(int i=0; i< PDC.length;i++) {
            int count = 1;
            for (int j = i + 1; j < PDC.length; j++) {
                if (PDC[i].equals(PDC[j])) {
                    count++;
                    fre[j] = visited;
                }
            }
            if (fre[i] != visited) {
                fre[i] = count;
            }
        }
        for(int i=0;i< fre.length;i++) {
            if(fre[i]!=visited) {
                A.add(searchlist.get(i).getProductioncompany()+","+ fre[i]);
            }
        }
        return A;
        }
    }
