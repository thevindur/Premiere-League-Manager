package com.company;

import java.io.IOException;

public interface LeagueManager {
    void createFootballClub(FootballClub footballClub);
    boolean deleteFootballClub();
    void statisticsOfFootballClub();
    void displayPremierLeagueTable();
    void addPlayedMatch();
    void saveToFile() throws IOException;
    void readFromFile() throws Exception;
}
