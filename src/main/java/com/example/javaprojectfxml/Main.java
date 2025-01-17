package com.example.javaprojectfxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE_NAME = "movies.txt";

    //private static final String OUTPUT_FILE_NAME = "movies.txt";

    public static void main(String[] args) throws Exception {
        List<Movie> movielist = new ArrayList<Movie>();
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
            movielist.add(m);
        }
        br.close();
        int op1=0;
        while (true) {
            int mainmenucount;
            Scanner sc = new Scanner(System.in);
            System.out.println("1) Movies Search : ");
            System.out.println("2) Search Production Company: ");
            System.out.println("3) Add Movie : ");
            System.out.println("4) Exit System : ");
            System.out.println("Enter your option : ");
            mainmenucount = sc.nextInt();
            switch (mainmenucount) {
                case 1: {
                    while (true) {
                        int option1;

                        sc = new Scanner(System.in);
                        System.out.println("1) By Movie Title : ");
                        System.out.println("2) By Release Year: ");
                        System.out.println("3) By Genre  : ");
                        System.out.println("4) By Production Company  : ");
                        System.out.println("5) By Running Time  : ");
                        System.out.println("6)Top 10 Movies  : ");
                        System.out.println("7) Back to Main Menu : ");
                        System.out.println("Enter your option : ");
                        option1 = sc.nextInt();
                        switch (option1) {
                            case 1: {
                                System.out.println("Enter your movie name :");
                                Scanner moviename = new Scanner(System.in);
                                String m = moviename.nextLine();
                                Movie m1=MovieSearch.SearchName(m, movielist);
                                if(m1!=null)
                                {
                                    System.out.println(m1.getMovieName() + ", " +m1.getYear() + ", " + m1.getGenre1() + ", " + m1.getGenre2() + ", " + m1.getGenre3() + ", " + m1.getRunningtime() + ", " + m1.getProductioncompany() + ", " + m1.getBudget() + ", " + m1.getRevenue());
                                }
                                else System.out.println("No such movie with this name");
                                break;
                            }
                            case 2: {
                                System.out.println("Enter movie year :");
                                Scanner releaseyear = new Scanner(System.in);
                                int y = releaseyear.nextInt();
                                List<Movie> m1= MovieSearch.Releaseyear(y, movielist);
                                if(m1!=null)
                                {
                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }

                                else System.out.println("No such movie with this release year");
                                break;
                            }
                            case 3: {
                                System.out.println("Enter movie genre: ");
                                Scanner genre = new Scanner(System.in);
                                String g = genre.nextLine();
                                List<Movie> m1= MovieSearch.Genre(g, movielist);
                                if(m1!=null)
                                {
                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }
                                else System.out.println("No such movie with this genre");
                                break;
                            }
                            case 4: {
                                System.out.println("Enter Production company Name : ");
                                Scanner production = new Scanner(System.in);
                                String pc = production.nextLine();
                                List<Movie> m1 = MovieSearch.Production(pc, movielist);
                                if(m1!=null)
                                {
                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }
                                else System.out.println("No such movie with this production company");
                                break;
                            }
                            case 5: {
                                System.out.println("Enter movie running time :");
                                Scanner runningtime = new Scanner(System.in);
                                long rt = runningtime.nextInt();
                                long rt1= runningtime.nextInt();
                                List<Movie> m1 = MovieSearch.RunningTime(rt,rt1, movielist);
                                if(m1!=null)
                                {
                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }
                                else System.out.println("No such movie with this duration of running time");
                                break;
                            }
                            case 6: {
                                List<Movie> m1 = MovieSearch.TopTenMovies( movielist);

                                for(int i=0;i<m1.size();i++) {
                                    System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                }
                                break;
                            }
                            case 7: {
                                      op1=1;
                                      break;
                                    }
                            }
                            if(op1==1) {
                                break;
                            }
                        }



                    }
                  break;
                case 2: {
                    while (true) {
                        int option2;

                        sc = new Scanner(System.in);
                        System.out.println("1) Most Recent Movies : ");
                        System.out.println("2) Movies with the Maximum Revenue: ");
                        System.out.println("3) Total Profit : ");
                        System.out.println("4) List of Production Companies and the Count of their Produced Movies  : ");
                        System.out.println("5) Back to Main Menu  : ");
                        option2 = sc.nextInt();
                        switch (option2) {
                            case 1: {
                                System.out.println("Enter Production Company name :");
                                Scanner procomname = new Scanner(System.in);
                                String p = procomname.nextLine();
                                List<Movie> m1 = SearchProductionCompany.ProductionCompanyName(p, movielist);
                                if(m1!=null){

                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }
                                else System.out.println("No such movie with this production company");

                                break;
                            }
                            case 2: {
                                System.out.println("Enter Production Company name :");
                                Scanner procomname1 = new Scanner(System.in);
                                String p = procomname1.nextLine();
                                List<Movie> m1 = SearchProductionCompany.ProductionCompanyName1(p, movielist);
                                if(m1!=null){

                                    for(int i=0;i<m1.size();i++) {
                                        System.out.println(m1.get(i).getMovieName() + ", " + m1.get(i).getYear() + ", " + m1.get(i).getGenre1() + ", " + m1.get(i).getGenre2() + ", " + m1.get(i).getGenre3() + ", " + m1.get(i).getRunningtime() + ", " + m1.get(i).getProductioncompany() + ", " + m1.get(i).getBudget() + ", " + m1.get(i).getRevenue());
                                    }
                                }
                                else System.out.println("No such movie with this production company");
                                break;
                            }
                            case 3: {
                                System.out.println("Enter Production Company name :");
                                Scanner procomname2 = new Scanner(System.in);
                                String p = procomname2.nextLine();
                                long a=SearchProductionCompany.ProductionCompanyName2(p, movielist);
                                System.out.println(a);
                                break;
                            }
                            case 4: {

                               List<String>m1= SearchProductionCompany.ProductionCompany(movielist);
                               for(int i=0;i< m1.size();i++) {
                                   System.out.println(m1.get(i));
                               }
                                   break;

                            }
                            case 5:
                            {
                                op1=1;
                                break;
                            }
                        }
                        if(op1==1)
                        {
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter new movie name");
                    Scanner object= new Scanner(System.in);
                    String newMovie=object.nextLine();
                    System.out.println("Enter release year");
                    int newmovieyear=object.nextInt();
                    System.out.println("Enter new movie genre1");
                    String newgenre1=object.next();

                    System.out.println("Enter new movie genre2");
                    String newgenre2=object.next();

                    System.out.println("Enter new movie genre3");
                    String newgenre3=object.next();
                    System.out.print("New Movie running time");
                    long newmovierunningtime=object.nextInt();

                    System.out.println("Enter new movie production company");
                    Scanner object1= new Scanner(System.in);
                    String newproductioncompany=object1.nextLine();

                    System.out.println("Enter new movie budget");
                    long newbudget=object.nextInt();

                    System.out.println("Enter new movie revenue");
                    long newrevenue=object.nextInt();

                    Movie m=new Movie(newMovie,newmovieyear,newgenre1,newgenre2,newgenre3,newmovierunningtime,newproductioncompany,newbudget,newrevenue );
                    movielist.add(m); 
                    break;
                }
                case 4:
                {
                    BufferedWriter bw = new BufferedWriter(new FileWriter( INPUT_FILE_NAME));
                    for(int i=0;i<movielist.size();i++) {
                        bw.write(movielist.get(i).getMovieName()+","+movielist.get(i).getYear()+","+movielist.get(i).getGenre1()+","+movielist.get(i).getGenre2()+","+movielist.get(i).getGenre3()+","+movielist.get(i).getRunningtime()+","+movielist.get(i).getProductioncompany()+","+movielist.get(i).getBudget()+","+movielist.get(i).getRevenue()+",");
                        bw.write(System.lineSeparator());
                    }
                    bw.close();
                    System.exit(0);
                    break;
                }
            }

        }
    }
}

