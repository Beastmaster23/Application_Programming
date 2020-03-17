import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BandMemberTest extends TestCase {

    public String name, name2, instrumentName, instrumentName2;
    public Sex gender, gender2;
    public BandInstrument instrument;

    @Before
    public void setup(){
        name="Test name";
        name2="Test name 2";
        gender=Sex.Other;
    }

    @Test
    public void testMember(){
        BandMember bandMember=new BandMember(name, gender);
        //Member name
        assertEquals(name, bandMember.getMemberName());
        bandMember.setMemberName(name2);
        assertEquals(name2, bandMember.getMemberName());
        assertEquals(gender, bandMember.getGender());
        bandMember.setGender(gender2);
        assertEquals(gender2, bandMember.getGender());
        BandInstrument instrument=new BandInstrument(instrumentName);
        assertEquals(instrumentName, instrument.getBandInstrument());
        bandMember.addInstrument(instrument);
        assertEquals(1, bandMember.instruments.length);
    }

    @Override
    public void tearDown() {

    }
}
