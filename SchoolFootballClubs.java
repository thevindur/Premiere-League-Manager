package com.company;

import java.io.Serializable;

public class SchoolFootballClubs extends FootballClub implements Serializable {
    private String schoolName;

    public SchoolFootballClubs(String clubName, String clubLocation, int noOfSeasonsPlayed, int clubWins, int clubDefeat, int clubDraws, int clubPoints, int noOfMatchesPlayed, int goalsReceived, int goalsScored, String schoolName) {
        super(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}