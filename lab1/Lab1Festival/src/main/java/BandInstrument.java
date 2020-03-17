public class BandInstrument {
    public String instrumentName;

    public BandInstrument(String name){
        instrumentName=name;
    }
    /**
     * Returns Instrument Name
     * @return String Instrument Name
     */
    public String getBandInstrument(){
        return instrumentName;
    }
    /**
     * Sets the Instrument Name
     * @param instrumentName Name of instrument
     */
    public void setinstrumentName(String instrumentName){
        this.instrumentName=instrumentName;
    }

    @Override
    public String toString() {
        return instrumentName;
    }
}
