package sample;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolFootballClubsTest {

    @Test
    public void getSchoolName() {
        SchoolFootballClubs schoolFootballClubs = new SchoolFootballClubs("STC Football Club","Sri Lanka",10,2,1,1,7,4,5,8,"STC");
        assertEquals("STC",schoolFootballClubs.getSchoolName());
    }

    @Test
    public void setSchoolName() {
        SchoolFootballClubs schoolFootballClubs = new SchoolFootballClubs("STC Football Club","Sri Lanka",10,2,1,1,7,4,5,8,"STC");
        schoolFootballClubs.setSchoolName("RC");
        assertEquals("RC",schoolFootballClubs.getSchoolName());
    }
}
