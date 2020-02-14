import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest1Test {

    @Test
    public void test(){
        String testFestivalName="Test Name", testBandName="Nemo and the Swordfish";

        Festival festival=new Festival(testFestivalName);
        //Check if name can be set/get
        assertEquals(testFestivalName, festival.getFestivalName());
        testFestivalName="Test 1 Name";
        festival.setFestivalName(testFestivalName);
        assertEquals(testFestivalName, festival.getFestivalName());

        Band band=new Band(testBandName);
        //Check if name can be set/get
        assertEquals(testBandName, band.getBandName());
        testBandName="Test 2 Name";
        band.setBandName(testBandName);
        assertEquals(testBandName, band.getBandName());


    }
}
