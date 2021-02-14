package sample;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsClubTest {

    @Test
    public void getClubName() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        assertEquals("Arsenal",sportsClub.getClubName());
    }

    @Test
    public void getClubLocation() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        assertEquals("London",sportsClub.getClubLocation());
    }

    @Test
    public void getNoOfSeasonsPlayed() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        assertEquals("London",sportsClub.getClubLocation());
    }

    @Test
    public void setClubName() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        sportsClub.setClubName("Manchester");
        assertEquals("Manchester",sportsClub.getClubName());
    }

    @Test
    public void setClubLocation() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        sportsClub.setClubLocation("UK");
        assertEquals("UK",sportsClub.getClubLocation());
    }

    @Test
    public void setNoOfSeasonsPlayed() {
        SportsClub sportsClub = new SportsClub("Arsenal", "London", 10) {
            @Override
            public int compareTo(FootballClub club) {
                return 0;
            }
        };
        sportsClub.setNoOfSeasonsPlayed(2);
        assertEquals(2,sportsClub.getNoOfSeasonsPlayed());
    }

    @Test
    public void compareTo() {
    }
}
