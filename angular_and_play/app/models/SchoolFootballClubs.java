package models;

public class SchoolFootballClubs extends FootballClub{
    private String schoolName;

    public SchoolFootballClubs(String clubName, String clubLocation, int noOfSeasonsPlayed, int clubWins, int clubDefeat, int clubDraws, int clubPoints, int noOfMatchesPlayed, int goalsReceived, int goalsScored, String schoolName) {
        super(clubName,clubLocation,noOfSeasonsPlayed,clubWins,clubDefeat,clubDraws,clubPoints,noOfMatchesPlayed,goalsReceived,goalsScored);
        this.schoolName = schoolName;
    }

    public SchoolFootballClubs(String clubName, String clubLocation, int noOfSeasonsPlayed, String schoolName){
        super(clubName,clubLocation,noOfSeasonsPlayed);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
