package com.company;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    private String clubName;
    private String clubLocation;
    private int noOfSeasonsPlayed;

    public SportsClub(String clubName, String clubLocation, int noOfSeasonsPlayed) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.noOfSeasonsPlayed = noOfSeasonsPlayed;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public int getNoOfSeasonsPlayed() {
        return noOfSeasonsPlayed;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public void setNoOfSeasonsPlayed(int noOfSeasonsPlayed) {
        this.noOfSeasonsPlayed = noOfSeasonsPlayed;
    }
}