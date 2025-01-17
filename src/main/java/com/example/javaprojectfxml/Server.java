package com.example.javaprojectfxml;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Server {
    private static final String INPUT_FILE_NAME = "movies.txt";


    private ServerSocket serverSocket;
    public HashMap<String, SocketWrapper> clientMap;
    public static  List<Movie> list=new ArrayList<>();

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(12335);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("server accepts");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        List<Movie>movieList=new ArrayList<>();
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        String clientName = (String) socketWrapper.read();
        clientMap.put(clientName, socketWrapper);
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
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
       // System.out.println(movieList.size());
          br.close();
        list=movieList;

        List<Movie> list=new ArrayList<>();
        for (Movie movie :movieList) {
            if (movie.getProductioncompany().equalsIgnoreCase(clientName)) {
                list.add(movie);
            }
        }
        socketWrapper.write(list);
        list.clear();

       new ReadThreadServer(clientMap, socketWrapper,clientName);
    }
    public static void main(String[] args) {

        new Server();
    }
}
