package com.example.javaprojectfxml;



import java.util.Scanner;

public class Client {
    public static SocketWrapper sock;

    public  Client(String serverAddress, int serverPort,String clientName) {
        try {

            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);
            sock=socketWrapper;
           // System.out.println(clientName);
            socketWrapper.write(clientName);
            new ReadThreadClient(socketWrapper);
         //   new WriteThreadClient(socketWrapper, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//
//    public static void main(String[] args) {
//        String serverAddress = "127.0.0.1";
//        int serverPort = 33335;
//        new Client(serverAddress, serverPort);
//    }
}


