package controllers;

import java.io.IOException;
import java.text.ParseException;

public interface LeagueManager {
    void createFootballClub();
    boolean deleteFootballClub();
    void statisticsOfFootballClub();
    void displayPremierLeagueTable();
    void addPlayedMatch() throws ParseException;
    void saveToFile() throws IOException;
    void readFromFile() throws Exception;
}
