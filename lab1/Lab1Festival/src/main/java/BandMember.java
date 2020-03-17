public class BandMember {
	
	private String memberName;
	private Sex gender;
	public BandInstrument[] instruments;

	public BandMember(String name, Sex gender){
		memberName=name;
		this.gender=gender;
		this.instruments=new BandInstrument[0];
	}

	/**
	 * Returns Member Name
	 * @return String Member Name
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the Member Name
	 * @param memberName Name of Member
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Returns Gender of Member
	 * @return Gender of Member
	 */
	public Sex getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the member
	 * @param gender Gender of Member
	 */
	public void setGender(Sex gender) {
		this.gender = gender;
	}

	/**
	 * Adds Instrument to Member
	 * @param instrument Instrument
	 */
	public void addInstrument(BandInstrument instrument){
		if(instruments==null){
			instruments=new BandInstrument[1];
			instruments[0]=instrument;
			return ;
		}
		int len=instruments.length;
		BandInstrument[] newInstruments=new BandInstrument[len+1];
		int i;
		for(i=0;i<len;i++)
			newInstruments[i]=instruments[i];
		newInstruments[i]=instrument;
		instruments=newInstruments;
	}

	@Override
	public String toString() {
		String s=memberName+" - ";
		int len=instruments.length;
		for (int i=0;i<len;i++) {
			s+=instruments[i];
			if(i+1<len)
				s+=", ";
		}
		return s;
	}
}