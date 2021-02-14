package sample;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    public static List<FootballClub> footballClubList = new ArrayList<>();

    public static List<FootballClub> getFootballClubList() {
        return footballClubList;
    }

    public static List<FootBallMatch> footballFootBallMatchList = new ArrayList<>();

    public static List<FootBallMatch> getFootballMatchList() { return footballFootBallMatchList;}

    @Override
    public void createFootballClub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n************* Select the type of Football Club *************");
        System.out.println("Option 1 - Premier League Football Club. ");
        System.out.println("Option 2 - University Football Club. ");
        System.out.println("Option 3 - School League Football Club. ");
        System.out.println("Option 4 - Go back to Main Menu. ");
        System.out.print("\nSelect the Option you want and Enter the Number Only : ");
        int userInput = sc.nextInt();

        if (userInput == 1){
            System.out.print("Enter Club Name : ");
            String clubName = sc.next();
            System.out.print("Enter Club Location : ");
            String clubLocation = sc.next();
            System.out.print("Enter Number of Seasons Played : ");
            int noOfSeasonsPlayed = sc.nextInt();

            boolean flag = false;
            for (FootballClub footballClub : footballClubList) {
                if (clubName.equalsIgnoreCase(footballClub.getClubName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                FootballClub club = new FootballClub(clubName,clubLocation,noOfSeasonsPlayed);
                footballClubList.add(club);
                System.out.println("\nClub has been Added Successfully !!");
            }else {
                System.out.println("A Club with the Name of " + clubName + " already Exists.");
            }

        }else if (userInput == 2) {
            System.out.print("Enter Club Name : ");
            String clubName = sc.nextLine();
            System.out.print("Enter Club Location : ");
            String clubLocation = sc.nextLine();
            System.out.print("Enter Number of Seasons Played : ");
            int noOfSeasonsPlayed = sc.nextInt();
            System.out.print("Enter the Name of University : ");
            String universityName = sc.next();

            boolean flag = false;
            for (FootballClub footballClub : footballClubList) {
                if (clubName.equalsIgnoreCase(footballClub.getClubName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                UniversityFootballClub club = new UniversityFootballClub(clubName,clubLocation,noOfSeasonsPlayed,universityName);
                footballClubList.add(club);
                System.out.println("\nClub has been Added Successfully !!");
            }else {
                System.out.println("A Club with the Name of " + clubName + " already Exists.");
            }

        } else if (userInput == 3) {
            System.out.print("Enter Club Name : ");
            String clubName = sc.nextLine();
            System.out.print("Enter Club Location : ");
            String clubLocation = sc.nextLine();
            System.out.print("Enter Number of Seasons Played : ");
            int noOfSeasonsPlayed = sc.nextInt();
            System.out.print("Enter the Name of School : ");
            String schoolName = sc.nextLine();

            boolean flag = false;
            for (FootballClub footballClub : footballClubList) {
                if (clubName.equalsIgnoreCase(footballClub.getClubName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                SchoolFootballClubs club = new SchoolFootballClubs(clubName,clubLocation,noOfSeasonsPlayed,schoolName);
                footballClubList.add(club);
                System.out.println("\nClub has been Added Successfully !!");
            }else {
                System.out.println("A Club with the Name of " + clubName + " already Exists.");
            }

        }else{
            System.out.println("Invalid Input !!");
        }
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
                System.out.println("The Club has been Successfully Deleted.");
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
        boolean flag = false;
        int index = 0;

        for (int i = 0; i < footballClubList.size(); i++) {
            if (clubName.equalsIgnoreCase(footballClubList.get(i).getClubName())){
                flag = true;
                index = i;
                break;
            }
        }
        if(flag){
            System.out.println("\n****** Premier League FootBall Club ****** ");
            System.out.println("Club Name : " + footballClubList.get(index).getClubName());
            System.out.println("Club Location : "+ footballClubList.get(index).getClubLocation());
            System.out.println("No of Seasons Played : "+ footballClubList.get(index).getNoOfSeasonsPlayed());
            System.out.println("No of Wins : "+ footballClubList.get(index).getClubWins());
            System.out.println("No of Defeats : "+ footballClubList.get(index).getClubDefeat());
            System.out.println("No of Draws : "+ footballClubList.get(index).getClubDraws());
            System.out.println("No of Points : "+ footballClubList.get(index).getClubPoints());
            System.out.println("No of Matches Played : "+ footballClubList.get(index).getNoOfMatchesPlayed());
            System.out.println("No of Goals Received : "+ footballClubList.get(index).getGoalsReceived());
            System.out.println("No of Goals Scored : "+ footballClubList.get(index).getGoalsScored());
        }else {
            System.out.println("There is no Club Registered Under that Name !! ");
        }
    }

    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(footballClubList);
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|    Club Category    |    Club Name    |    Location    | Seasons Played | Wins | Defeats | Draws | Points | Matches Played | Goals Received | Goals Scored | Uni/Scl Name |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(FootballClub club: footballClubList){
            if (club instanceof UniversityFootballClub){
                System.out.print("  University Club         ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),((UniversityFootballClub) club).getUniversityName());
                System.out.println();
            }else if (club instanceof SchoolFootballClubs){
                System.out.print("  School Club             ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),((SchoolFootballClubs) club).getSchoolName());
                System.out.println();
            }else {
                System.out.print("  Premier League Club     ");
                System.out.format("%-18s%-21s%-12d%-9d%-9d%-8d%-13d%-16d%-17d%-15d%-1s",club.getClubName(),club.getClubLocation(),club.getNoOfSeasonsPlayed(),club.getClubWins(),club.getClubDefeat(),club.getClubDraws(),club.getClubPoints(),club.getNoOfMatchesPlayed(),club.getGoalsReceived(),club.getGoalsScored(),"-");
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void addPlayedMatch() throws ParseException {
        boolean flag1 = false;
        boolean flag2 = false;
        String clubNameOne = null;
        String clubNameTwo = null;

        Scanner sc = new Scanner(System.in);

        while(!flag1){
            System.out.print("Enter Club One's Name : ");
            clubNameOne = sc.nextLine();
            for (FootballClub club : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(club.getClubName())) {
                    flag1 = true;
                    break;
                }
            }
            if (!flag1){
                System.out.println("There is no such club named " + clubNameOne + ". Please Retry !!");
            }
        }
        while(!flag2){
            System.out.print("Enter Club Two's Name : ");
            clubNameTwo = sc.nextLine();
            for (FootballClub club : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(club.getClubName())) {
                    flag2 = true;
                    break;
                }
            }
            if (!flag2){
                System.out.println("There is no such club named " + clubNameTwo + ". Please Retry !!");
            }
        }
        System.out.print("Enter Club One's Score : ");
        int clubOneScore = sc.nextInt();
        System.out.print("Enter Club Two's Score : ");
        int clubTwoScore = sc.nextInt();
        System.out.print("Enter the Date (DD-MM-YYYY) :");
        String matchDate = sc.next();
        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(matchDate);


        if (clubOneScore>clubTwoScore){
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubWins(footballClub.getClubWins() + 1);
                    footballClub.setClubPoints(footballClub.getClubPoints()+3);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubTwoScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubOneScore);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDefeat(footballClub.getClubDefeat() + 1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubOneScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubTwoScore);
                }
            }
        }else if (clubTwoScore>clubOneScore){
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubWins(footballClub.getClubWins() + 1);
                    footballClub.setClubPoints(footballClub.getClubPoints()+3);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubOneScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubTwoScore);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDefeat(footballClub.getClubDefeat() + 1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubTwoScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubOneScore);
                }
            }
        }else{
            for (FootballClub footballClub : footballClubList) {
                if (clubNameTwo.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDraws(footballClub.getClubDraws() + 1);
                    footballClub.setClubPoints(footballClub.getClubPoints()+1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubOneScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubTwoScore);
                }
            }
            for (FootballClub footballClub : footballClubList) {
                if (clubNameOne.equalsIgnoreCase(footballClub.getClubName())) {
                    footballClub.setClubDraws(footballClub.getClubDraws() + 1);
                    footballClub.setClubPoints(footballClub.getClubPoints()+1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setNoOfMatchesPlayed(footballClub.getNoOfMatchesPlayed()+1);
                    footballClub.setGoalsReceived(footballClub.getGoalsReceived()+clubTwoScore);
                    footballClub.setGoalsScored(footballClub.getGoalsScored()+clubOneScore);
                }
            }
        }
        FootBallMatch footBallMatch = new FootBallMatch(clubNameOne, clubNameTwo, clubOneScore, clubTwoScore, newDate);
        footballFootBallMatchList.add(footBallMatch);
        System.out.println("Match has been Added Successfully !!");
    }

    @Override
    public void saveToFile() throws IOException {
        ObjectOutputStream footballOutput = new ObjectOutputStream(new FileOutputStream("football.data"));
        ObjectOutputStream footballMatch = new ObjectOutputStream(new FileOutputStream("Match.data"));
        for(FootballClub footballClub:footballClubList){
            footballOutput.writeObject(footballClub);
        }
        for(FootBallMatch footBallMatch : footballFootBallMatchList){
            footballMatch.writeObject(footBallMatch);
        }
        footballOutput.reset();
        footballMatch.reset();

        footballOutput.close();
        footballMatch.close();
    }

    @Override
    public void readFromFile() throws Exception {
        ObjectInputStream footballInput = new ObjectInputStream(new FileInputStream("football.data"));
        ObjectInputStream footballMatch = new ObjectInputStream(new FileInputStream("Match.data"));
        for (;;){
            try {
                FootballClub footballClub = (FootballClub) footballInput.readObject();
                footballClubList.add(footballClub);
            }catch (EOFException exception){
                break;
            }
        }
        for (;;){
            try {
                FootBallMatch footBallMatch = (FootBallMatch) footballMatch.readObject();
                footballFootBallMatchList.add(footBallMatch);
            }catch (EOFException exception){
                break;
            }
        }
        footballInput.close();
        footballMatch.close();
    }
}
