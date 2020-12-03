package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements Serializable,LeagueManager {

    public static List<FootballClub> footballClubList = new ArrayList<>();

    @Override
    public void createFootballClub(FootballClub footballClub) {
        footballClubList.add(footballClub);
        System.out.println("\nClub has been Added Successfully !!");
    }

    @Override
    public boolean deleteFootballClub() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the club : ");
        String clubName = sc.nextLine();

        for (int i = 0; i < footballClubList.size(); i++) {
            if (clubName.equalsIgnoreCase(footballClubList.get(i).getClubName())){
                flag = true;
                footballClubList.remove(i);
                break;
            }
        }
        if(!flag){
            System.out.println("This Club Does not Exist !! Please check the Name Again.");
        }
        return flag;
    }

    @Override
    public void statisticsOfFootballClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the club : ");
        String clubName = sc.nextLine();

        for (int i = 0; i < footballClubList.size(); i++) {
            if (clubName.equalsIgnoreCase(footballClubList.get(i).getClubName())){
                for(FootballClub club:footballClubList){
                    if (club instanceof FootballClub){
                        System.out.println("****** Club Category : Premier League FootBall Club ****** ");
                    }else if (club instanceof UniversityFootballClub){
                        System.out.println("****** Club Category : University FootBall Club ****** ");
                        System.out.println(((UniversityFootballClub) club).getUniversityName());
                    }else if (club instanceof SchoolFootballClubs){
                        System.out.println("****** Club Category : School FootBall Club ****** ");
                        System.out.println(((SchoolFootballClubs) club).getSchoolName());
                    }
                    System.out.println("Club Name : " + club.getClubName());
                    System.out.println("Club Location : "+club.getClubLocation());
                    System.out.println("No of Seasons Played : "+club.getNoOfSeasonsPlayed());
                    System.out.println("No of Wins : "+club.getClubWins());
                    System.out.println("No of Defeats : "+club.getClubDefeat());
                    System.out.println("No of Draws : "+club.getClubDraws());
                    System.out.println("No of Points : "+club.getClubPoints());
                    System.out.println("No of Matches Played : "+club.getNoOfMatchesPlayed());
                    System.out.println("No of Goals Received : "+club.getGoalsReceived());
                    System.out.println("No of Goals Scored : "+club.getGoalsScored());

                }
            }else{
                System.out.println("There is no Club Registered Under that Name !! ");
            }
        }
    }

    @Override
    public void displayPremierLeagueTable() {
        FootballClub[] arr = footballClubList.toArray(new FootballClub[] {});
        FootballClubSortingList.bubbleSort(arr);
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|    Club Category    |    Club Name    |    Location    | Seasons Played | Wins | Defeats | Draws | Points | Matches Played | Goals Received | Goals Scored | Uni/Scl Name |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(FootballClub club: arr){
            if (club instanceof UniversityFootballClub){
                System.out.print("  University Club         ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),+club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),((UniversityFootballClub) club).getUniversityName());
                System.out.println();
            }else if (club instanceof SchoolFootballClubs){
                System.out.print("  School Club             ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),+club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),((SchoolFootballClubs) club).getSchoolName());
                System.out.println();
            }else {
                System.out.print("  Premier League Club     ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),+club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),"-");
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void addPlayedMatch() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Club One's Name : ");
        String clubNameOne = sc.next();
        System.out.print("Enter Club Two's Name : ");
        String clubNameTwo = sc.next();
        System.out.print("Enter Club One's Score : ");
        int clubOneScore = sc.nextInt();
        System.out.print("Enter Club Two's Score : ");
        int clubTwoScore = sc.nextInt();
        System.out.print("Enter the Date :");
        String date = sc.next();


        if (clubOneScore>clubTwoScore){
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubWins(footballClub.getClubWins() + 1);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDefeat(footballClub.getClubDefeat() + 1);
                }
            }
        }else if (clubTwoScore>clubOneScore){
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubWins(footballClub.getClubWins() + 1);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDefeat(footballClub.getClubDefeat() + 1);
                }
            }
        }else{
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDraws(footballClub.getClubDraws() + 1);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDraws(footballClub.getClubDraws() + 1);
                }
            }
        }
    }

    @Override
    public void saveToFile() throws IOException {
        FileOutputStream writer = new FileOutputStream("FootBall.txt",true);
        ObjectOutputStream footballOutput = new ObjectOutputStream(writer);
        Object[] objArray = footballClubList.toArray();
        footballOutput.writeObject(objArray);
        footballOutput.close();
    }

    @Override
    public void readFromFile() throws Exception {
        FileInputStream writer = new FileInputStream("FootBall.txt");
        ObjectInputStream footballInput = new ObjectInputStream(writer);
        FootballClub club = (FootballClub) footballInput.readObject();
        System.out.println(club);
        footballInput.close();
    }
}