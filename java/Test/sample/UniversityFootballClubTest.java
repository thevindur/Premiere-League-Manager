package sample;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityFootballClubTest {

    @Test
    public void getUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("IIT Football Club","Sri Lanka",10,2,1,1,7,4,5,8,"IIT");
        assertEquals("IIT",universityFootballClub.getUniversityName());
    }

    @Test
    public void setUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("IIT Football Club","Sri Lanka",10,2,1,1,7,4,5,8,"IIT");
        universityFootballClub.setUniversityName("SLIT Football Club");
        assertEquals("SLIT Football Club",universityFootballClub.getUniversityName());
    }
}
