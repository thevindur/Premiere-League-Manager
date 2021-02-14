package models;

import java.io.Serializable;
import java.util.Date;

public class FootBallMatch implements Serializable {
    private String clubOneName;
    private String clubTwoName;
    private int clubOneScore;
    private int clubTwoScore;
    private Date matchDate;

    public FootBallMatch(String clubOneName, String clubTwoName, int clubOneScore, int clubTwoScore, Date matchDate) {
        this.clubOneName = clubOneName;
        this.clubTwoName = clubTwoName;
        this.clubOneScore = clubOneScore;
        this.clubTwoScore = clubTwoScore;
        this.matchDate = matchDate;
    }

    public FootBallMatch() {

    }

    public String getClubOneName() {
        return clubOneName;
    }

    public String getClubTwoName() {
        return clubTwoName;
    }

    public int getClubOneScore() {
        return clubOneScore;
    }

    public int getClubTwoScore() {
        return clubTwoScore;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setClubOneName(String clubOneName) {
        this.clubOneName = clubOneName;
    }

    public void setClubTwoName(String clubTwoName) {
        this.clubTwoName = clubTwoName;
    }

    public void setClubOneScore(int clubOneScore) {
        this.clubOneScore = clubOneScore;
    }

    public void setClubTwoScore(int clubTwoScore) {
        this.clubTwoScore = clubTwoScore;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
}
