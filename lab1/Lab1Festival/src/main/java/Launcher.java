public class Launcher {
    public static void main(String[] args) {

        Festival festival=new Festival("Texas Metal Lords");
        Band thunder=new Band("Thunderdome");

        BandMember axel=new BandMember("Axel Gauntlet", Sex.Male);
        BandInstrument[] instruments={
                new BandInstrument("Vocals"),
                new BandInstrument("Harmonica")
        };
        axel.instruments=instruments;
        thunder.addBandMember(axel);

        BandMember spleen=new BandMember("The Spleen", Sex.Male);
        spleen.addInstrument(new BandInstrument("lead guitar"));
        thunder.addBandMember(spleen);

        BandMember smithers=new BandMember("Jimbob Smithers", Sex.Male);
        smithers.addInstrument(new BandInstrument("bass guitar"));
        thunder.addBandMember(smithers);

        BandMember smith=new BandMember("Bob Smith IV", Sex.Male);
        smith.addInstrument(new BandInstrument("drums"));
        thunder.addBandMember(smith);

        festival.addBand(thunder);

        String[] celticMembers={
                "Angus McMurder",
                "Susan",
                "Trevor Williams",
                "Furious George"
        };
        Sex[] celticGenders={
                Sex.Male,
                Sex.Female,
                Sex.Male,
                Sex.Other
        };
        String[][] celticInstruments={
                {"vocals"},
                {"vocals"},
                {"bagpipes"},
                {"cymbals"}
        };
        festival.addBand(createBand("Celtic Death Fist", celticMembers, celticGenders, celticInstruments));
        System.out.println("Welcome to "+festival+" Festival");
        for(int i=0;i<festival.bands.length;i++){
            Band band=festival.bands[i];
            System.out.println("Band : "+band.getBandName());

            for(int j=0;j<band.bandMembers.length;j++){
                BandMember bandMember=band.bandMembers[j];
                System.out.println("       "+bandMember);
            }
        }
    }

    /**
     * Testing Method that creates a Band
     * @param bandName Name of Band
     * @param members Member Names
     * @param genders Genders of members
     * @param instruments Instruments For each member
     * @return Band
     */
    public static Band createBand(String bandName, String[] members, Sex[] genders, String[][] instruments){
        Band band=new Band(bandName);
        for (int i=0;i<members.length;i++) {
            BandMember bandMember=new BandMember(members[i], genders[i]);
            for(int j=0;j<instruments[i].length;j++){
                bandMember.addInstrument(new BandInstrument(instruments[i][j]));
            }
            band.addBandMember(bandMember);
        }
        return band;
    }
}
