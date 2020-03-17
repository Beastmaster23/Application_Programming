public class Band {
	
	private String bandName;
	public BandMember[] bandMembers;

	public Band(String name){
		bandName=name;

		bandMembers=new BandMember[0];
	}

	/**
	 * Returns Band Name
	 * @return String Band Name
	 */
	public String getBandName(){
		return bandName;
	}
	/**
	 * Sets the Band Name
	 * @param bandName Name of Band
	 */
	public void setBandName(String bandName){
		this.bandName=bandName;
	}

	/**
	 * Adds a Band member
	 * @param member Band member
	 */
	public void addBandMember(BandMember member){
		if(bandMembers==null){
			bandMembers=new BandMember[1];
			bandMembers[0]=member;
			return ;
		}
		int len=bandMembers.length;
		BandMember[] newBandMembers=new BandMember[len+1];
		int i;
		for(i=0;i<len;i++)
			newBandMembers[i]=bandMembers[i];
		newBandMembers[i]=member;
		bandMembers=newBandMembers;
	}

	@Override
	public String toString(){
		return bandName+" Band";
	}
}
