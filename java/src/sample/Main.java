package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Main extends Application {

    private final static PremierLeagueManager manager = new PremierLeagueManager();

    @Override
    public void start(Stage primaryStage){GuiMain.home(primaryStage);}

    public static void main(String[] args){
        try {
            manager.readFromFile();
            System.out.println("***** File Loading Successful. *****");
        } catch (Exception e) {
            System.out.println("There are no files to be loaded.");
        }

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int userInput;

                while(true){
                    System.out.println("\n************* Welcome to the Premier League Championship System *************" + "\n\n");
                    System.out.println("Option 1 - Add A New Football Club.");
                    System.out.println("Option 2 - Delete A Football Club.");
                    System.out.println("Option 3 - Print statistics of a Selected Football Club.");
                    System.out.println("Option 4 - Display Premier League Table.");
                    System.out.println("Option 5 - Add a Played Match.");
                    System.out.println("Option 6 - Save Information to File.");
                    System.out.println("Option 7 - Open the GUI");
                    System.out.println("Option 8 - Exit the Program.");
                    System.out.print("\nSelect the Option you want and Enter the Number Only : ");
                    userInput = sc.nextInt();

                    if (userInput == 1) {
                        manager.createFootballClub();
                    } else if (userInput == 2){
                        manager.deleteFootballClub();
                    }else if (userInput == 3){
                        manager.statisticsOfFootballClub();
                    }else if (userInput == 4){
                        manager.displayPremierLeagueTable();
                    }else if (userInput == 5){
                        manager.addPlayedMatch();
                    }else if (userInput == 6){
                        try {
                            manager.saveToFile();
                            System.out.println("***** File was Successfully Saved. *****");
                        } catch (IOException exception) {
                            System.out.println("There was problem in saving the file.");
                        }
                    }
                    else if (userInput == 7){
                        System.out.println("\t1. Open as an Application (JavaFx).");
                        System.out.println("\t2. Open as an Website (Angular).");
                        System.out.print("\tSelect the Option you want and Enter the Number Only : ");
                        userInput = sc.nextInt();

                        if (userInput==1){
                            launch(args);
                        }else if (userInput==2){
                            try {
                                Desktop gui = java.awt.Desktop.getDesktop();
                                URI guiURL = new URI("http://localhost:4200/");
                                gui.browse(guiURL);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("***** Invalid Selection *****");
                            break;
                        }
                    }
                    else if (userInput == 8){
                        System.out.println("\n************* Thank You for using the Premier League Championship System !! *************");
                        System.exit(0);
                    }
                }
            }catch (Exception exception){
                System.out.println("\nInvalid Input !!");
            }
        }
    }
}
