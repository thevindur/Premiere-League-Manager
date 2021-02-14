package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballClubTest {

    @Test
    public void getClubWins() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(2,footballClub.getClubWins());
    }

    @Test
    public void getClubDefeat() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(1,footballClub.getClubDefeat());
    }

    @Test
    public void getClubDraws() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(1,footballClub.getClubDraws());
    }

    @Test
    public void getClubPoints() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(7,footballClub.getClubPoints());
    }

    @Test
    public void getNoOfMatchesPlayed() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(4,footballClub.getNoOfMatchesPlayed());
    }

    @Test
    public void getGoalsReceived() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(5,footballClub.getGoalsReceived());
    }

    @Test
    public void getGoalsScored() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        assertEquals(8,footballClub.getGoalsScored());
    }

    @Test
    public void setClubWins() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setClubWins(6);
        assertEquals(6,footballClub.getClubWins());
    }

    @Test
    public void setClubDefeat() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setClubDefeat(6);
        assertEquals(6,footballClub.getClubDefeat());
    }

    @Test
    public void setClubDraws() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setClubDraws(6);
        assertEquals(6,footballClub.getClubDraws());
    }

    @Test
    public void setClubPoints() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setClubPoints(6);
        assertEquals(6,footballClub.getClubPoints());
    }

    @Test
    public void setNoOfMatchesPlayed() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setNoOfMatchesPlayed(6);
        assertEquals(6,footballClub.getNoOfMatchesPlayed());
    }

    @Test
    public void setGoalsReceived() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setGoalsReceived(6);
        assertEquals(6,footballClub.getGoalsReceived());
    }

    @Test
    public void setGoalsScored() {
        FootballClub footballClub = new FootballClub("Arsenal","London",10,2,1,1,7,4,5,8);
        footballClub.setGoalsScored(6);
        assertEquals(6,footballClub.getGoalsScored());
    }

    @Test
    public void compareTo() {
    }
}
