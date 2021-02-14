package sample;

public class FootballClub extends SportsClub implements Comparable<FootballClub> {
    private int clubWins;
    private int clubDefeat;
    private int clubDraws;
    private int clubPoints;
    private int noOfMatchesPlayed;
    private int goalsReceived;
    private int goalsScored;

    public FootballClub(String clubName, String clubLocation, int noOfSeasonsPlayed, int clubWins, int clubDefeat, int clubDraws, int clubPoints, int noOfMatchesPlayed, int goalsReceived, int goalsScored) {
        super(clubName,clubLocation,noOfSeasonsPlayed);
        this.clubWins = clubWins;
        this.clubDefeat = clubDefeat;
        this.clubDraws = clubDraws;
        this.clubPoints = clubPoints;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
    }

    public FootballClub(String clubName, String clubLocation, int noOfSeasonsPlayed){
        super(clubName,clubLocation,noOfSeasonsPlayed);
    }

    public int getClubWins() {
        return clubWins;
    }

    public int getClubDefeat() {
        return clubDefeat;
    }

    public int getClubDraws() {
        return clubDraws;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setClubWins(int clubWins) {
        this.clubWins = clubWins;
    }

    public void setClubDefeat(int clubDefeat) {
        this.clubDefeat = clubDefeat;
    }

    public void setClubDraws(int clubDraws) {
        this.clubDraws = clubDraws;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int compareTo(FootballClub club) {
        if (clubPoints == club.clubPoints) {
            if ((goalsScored-goalsReceived) < (club.goalsScored-club.goalsReceived)) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else if (clubPoints < club.clubPoints) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
