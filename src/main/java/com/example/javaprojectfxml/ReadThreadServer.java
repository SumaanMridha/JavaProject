package com.example.javaprojectfxml;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadThreadServer implements Runnable {
    private Thread thr;
    private SocketWrapper socketWrapper;
    public HashMap<String, SocketWrapper> clientMap;
    String clientName;


    public ReadThreadServer(HashMap<String, SocketWrapper> map, SocketWrapper socketWrapper, String clientname) {
        this.clientMap = map;
        this.socketWrapper = socketWrapper;
        this.clientName = clientname;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
//                if (o instanceof Message) {
//                    Message obj = (Message) o;
//                    String to = obj.getTo();
//                    SocketWrapper nu = clientMap.get(to);
//                    if (nu != null) {
//                        nu.write(obj);
//                    }
//                }
                if (o instanceof ADDMOVIE) {
                    ADDMOVIE addd = (ADDMOVIE) o;
                    System.out.println(addd.getBudget());

                    Movie ma = new Movie(addd.getMovieName(), addd.getYear(), addd.getGenre1(), addd.getGenre2(), addd.getGenre3(), addd.getRunningtime(), addd.getProductioncompany(), addd.getBudget(), addd.getRevenue());
                    List<Movie> movieList = new ArrayList<>();
                    BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
                    while (true) {

                        String line = br.readLine();
                        if (line == null) break;
                        String[] MoviesPart = line.split(",");
                        String name = MoviesPart[0];
                        int year = Integer.parseInt(MoviesPart[1]);
                        String genre1 = MoviesPart[2];
                        String genre2 = MoviesPart[3];
                        String genre3 = MoviesPart[4];
                        long runningtime = Integer.parseInt(MoviesPart[5]);
                        String productioncompany = MoviesPart[6];
                        long budget = Integer.parseInt(MoviesPart[7]);
                        long revenue = Integer.parseInt(MoviesPart[8]);
                        Movie m = new Movie(name, year, genre1, genre2, genre3, runningtime, productioncompany, budget, revenue);
                        movieList.add(m);
                    }
                    br.close();
                    List<Movie> list2 = new ArrayList<>();
                    for (Movie movie : movieList) {
                        if (movie.getProductioncompany().equalsIgnoreCase(clientName)) {
                            list2.add(movie);
                        }
                    }
                    list2.add(ma);
                    movieList.add(ma);
                    System.out.println(list2.size());
                    socketWrapper.write(list2);
                    BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"));
                    for (int i = 0; i < movieList.size(); i++) {
                        bw.write(movieList.get(i).getMovieName() + "," + movieList.get(i).getYear() + "," + movieList.get(i).getGenre1() + "," + movieList.get(i).getGenre2() + "," + movieList.get(i).getGenre3() + "," + movieList.get(i).getRunningtime() + "," + movieList.get(i).getProductioncompany() + "," + movieList.get(i).getBudget() + "," + movieList.get(i).getRevenue() + ",");
                        bw.write(System.lineSeparator());
                    }
                    bw.close();
                    System.out.println(movieList);
                    if (o instanceof Message) {
                        Message m = (Message) o;
                        String bass = m.getTo();
                        Movie nw = m.getMovie();
                        for (int i = 0; i < Server.list.size(); i++) {
                            if (nw.getMovieName().equalsIgnoreCase(Server.list.get(i).getMovieName()))
                                Server.list.get(i).setProductioncompany(bass);
                        }
                        List<Movie> list = new ArrayList<>();
                        for (int j = 0; j < Server.list.size(); j++) {
                            if (bass.equalsIgnoreCase(Server.list.get(j).getProductioncompany()))
                                list.add(Server.list.get(j));
                        }
                        //SocketWrapper nu = clientMap.get(to);
                        SocketWrapper socketWrapper1 = clientMap.get(bass);
                        socketWrapper1.write(list);
                        BufferedWriter bw2 = new BufferedWriter(new FileWriter("movies.txt"));
                        for (int i = 0; i < Server.list.size(); i++) {
                            bw2.write(Server.list.get(i).getMovieName() + "," + Server.list.get(i).getYear() + "," + Server.list.get(i).getGenre1() + "," + Server.list.get(i).getGenre2() + "," + Server.list.get(i).getGenre3() + "," + Server.list.get(i).getRunningtime() + "," + Server.list.get(i).getProductioncompany() + "," + Server.list.get(i).getBudget() + "," + Server.list.get(i).getRevenue() + ",");
                            bw2.write(System.lineSeparator());

                        }
                    }
//                    System.out.println(movieList.size());
//                        List<Movie> list = new ArrayList<>();
//                        for (Movie movie : movieList) {
//                            if (movie.getProductioncompany().equalsIgnoreCase(clientName)) {
//                                list.add(movie);
//                            }
//                        }
//                        list.add(ma);
//                        movieList.add(ma);
//                        System.out.println(list.size());
//                        socketWrapper.write(list);
//                        BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"));
//                        for (int i = 0; i < movieList.size(); i++) {
//                            bw.write(movieList.get(i).getMovieName() + "," + movieList.get(i).getYear() + "," + movieList.get(i).getGenre1() + "," + movieList.get(i).getGenre2() + "," + movieList.get(i).getGenre3() + "," + movieList.get(i).getRunningtime() + "," + movieList.get(i).getProductioncompany() + "," + movieList.get(i).getBudget() + "," + movieList.get(i).getRevenue() + ",");
//                            bw.write(System.lineSeparator());
//                        }
//                        bw.close();
//                        System.out.println(movieList);
                    }
                }

            } catch(Exception e){
                System.out.println(e);
            } finally{
                try {
                    socketWrapper.closeConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



