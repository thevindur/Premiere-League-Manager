package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) throws Exception {
        /*manager.readFromFile();*/
        Scanner sc = new Scanner(System.in);
        int userInput;

        firstMenu:
        while(true){
            System.out.println("\n************* Welcome to the Premier League Championship System *************" + "\n\n");
            System.out.println("Option 1 - Add A New Football Club.");
            System.out.println("Option 2 - Delete A Football Club.");
            System.out.println("Option 3 - Print statistics of a Selected Football Club.");
            System.out.println("Option 4 - Display Premier League Table.");
            System.out.println("Option 5 - Add a Played Match.");
            System.out.println("Option 6 - Save Information to File.");
            System.out.println("Option 7 - Read Information from File.");
            System.out.println("Option 8 - Exit the Program.");
            System.out.print("\nSelect the Option you want and Enter the Number Only : ");
            userInput = sc.nextInt();

            secondMenu:
            if (userInput == 1) {
                System.out.println("\n************* Select the type of Football Club *************");
                System.out.println("Option 1 - Premier League Football Club. ");
                System.out.println("Option 2 - University Football Club. ");
                System.out.println("Option 3 - School League Football Club. ");
                System.out.println("Option 4 - Go back to Main Menu. ");
                System.out.print("\nSelect the Option you want and Enter the Number Only : ");
                userInput = sc.nextInt();

                if (userInput == 1){
                    newFootballClub();
                }else if (userInput == 2) {
                    newUniversityFootballClub();;
                } else if (userInput == 3) {
                    newSchoolFootballClub();
                } else if (userInput == 4) {
                    break secondMenu;
                }else{
                    System.out.println("Invalid Input !!");
                }
            } else if (userInput == 2){
                manager.deleteFootballClub();
            }else if (userInput == 3){
                manager.statisticsOfFootballClub();
            }else if (userInput == 4){
                manager.displayPremierLeagueTable();
            }else if (userInput == 5){
                manager.addPlayedMatch();
            }else if (userInput == 6){
                manager.saveToFile();
            }else if (userInput == 7){
                manager.readFromFile();
            }
            else if (userInput == 8){
                System.out.println("\n************* Thank You for using the Premier League Championship System !! *************");
                System.exit(0);
            }
        }
    }

    private final static PremierLeagueManager manager = new PremierLeagueManager();

    private static void newFootballClub() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter Club Name : ");
        String clubName = userInput.nextLine();
        System.out.print("Enter Club Location : ");
        String clubLocation = userInput.nextLine();
        System.out.print("Enter Number of Seasons Played : ");
        int noOfSeasonsPlayed = userInput.nextInt();
        System.out.print("Enter Club Wins : ");
        int clubWins = userInput.nextInt();
        System.out.print("Enter Club Defeats : ");
        int clubDefeat = userInput.nextInt();
        System.out.print("Enter Club Draws : ");
        int clubDraws = userInput.nextInt();
        System.out.print("Enter Club Points : ");
        int clubPoints = userInput.nextInt();
        System.out.print("Enter Number of Matches Played by the Club  : ");
        int noOfMatchesPlayed = userInput.nextInt();
        System.out.print("Enter Number of Goals Received : ");
        int goalsReceived = userInput.nextInt();
        System.out.print("Enter Number of Goals Scored : ");
        int goalsScored = userInput.nextInt();

        FootballClub club = new FootballClub(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored);
        manager.createFootballClub(club);
    }

    private static void newUniversityFootballClub() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter Club Name : ");
        String clubName = userInput.nextLine();
        System.out.print("Enter Club Location : ");
        String clubLocation = userInput.nextLine();
        System.out.print("Enter Number of Seasons Played : ");
        int noOfSeasonsPlayed = userInput.nextInt();
        System.out.print("Enter Club Wins : ");
        int clubWins = userInput.nextInt();
        System.out.print("Enter Club Defeats : ");
        int clubDefeat = userInput.nextInt();
        System.out.print("Enter Club Draws : ");
        int clubDraws = userInput.nextInt();
        System.out.print("Enter Club Points : ");
        int clubPoints = userInput.nextInt();
        System.out.print("Enter Number of Matches Played by the Club  : ");
        int noOfMatchesPlayed = userInput.nextInt();
        System.out.print("Enter Number of Goals Received : ");
        int goalsReceived = userInput.nextInt();
        System.out.print("Enter Number of Goals Scored : ");
        int goalsScored = userInput.nextInt();
        System.out.print("Enter the Name of University : ");
        String universityName = userInput.next();


        UniversityFootballClub club = new UniversityFootballClub(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored,universityName);
        manager.createFootballClub(club);
    }

    private static void newSchoolFootballClub() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter Club Name : ");
        String clubName = userInput.nextLine();
        System.out.print("Enter Club Location : ");
        String clubLocation = userInput.nextLine();
        System.out.print("Enter Number of Seasons Played : ");
        int noOfSeasonsPlayed = userInput.nextInt();
        System.out.print("Enter Club Wins : ");
        int clubWins = userInput.nextInt();
        System.out.print("Enter Club Defeats : ");
        int clubDefeat = userInput.nextInt();
        System.out.print("Enter Club Draws : ");
        int clubDraws = userInput.nextInt();
        System.out.print("Enter Club Points : ");
        int clubPoints = userInput.nextInt();
        System.out.print("Enter Number of Matches Played by the Club  : ");
        int noOfMatchesPlayed = userInput.nextInt();
        System.out.print("Enter Number of Goals Received : ");
        int goalsReceived = userInput.nextInt();
        System.out.print("Enter Number of Goals Scored : ");
        int goalsScored = userInput.nextInt();
        System.out.print("Enter the Name of School : ");
        String schoolName = userInput.nextLine();

        SchoolFootballClubs club = new SchoolFootballClubs(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored,schoolName);
        manager.createFootballClub(club);
    }
}