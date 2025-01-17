package com.example.javaprojectfxml;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;
    static List<Movie> p;
    static List<Movie> m;
    static List<Movie> mr;
    static  long totalprofit;

    public ReadThreadClient(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
                p = new ArrayList<>();
                if (o instanceof ArrayList) {
                    p = (ArrayList) o;
                }
                int year=p.get(0).getYear();
                for(int i=0;i<p.size();i++){
                    if(year<p.get(i).getYear()){
                        year=p.get(i).getYear();
                    }
                }
                m= new ArrayList<>();
                for(int j=0;j<p.size();j++){
                    if(p.get(j).getYear()==year){
                        m.add(p.get(j));
                    }
                }
                long maxrevenue=p.get(0).getRevenue();
                for(int i=0;i<p.size();i++){
                    if(maxrevenue<p.get(i).getRevenue()){
                        maxrevenue=p.get(i).getRevenue();
                    }
                    mr= new ArrayList<>();
                    for(int j=0;j<p.size();j++){
                        if(p.get(j).getRevenue()==maxrevenue){
                            mr.add(p.get(j));
                        }
                    }
                }
                totalprofit=0;
                for(int i=0;i<p.size();i++){
                    totalprofit += p.get(i).getRevenue()-p.get(i).getBudget();
                }
                //System.out.println(totalprofit);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



