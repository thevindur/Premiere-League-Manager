package com.company;

import java.io.Serializable;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String universityName;

    public UniversityFootballClub(String clubName, String clubLocation, int noOfSeasonsPlayed, int clubWins, int clubDefeat, int clubDraws, int clubPoints, int noOfMatchesPlayed, int goalsReceived, int goalsScored, String universityName) {
        super(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

}