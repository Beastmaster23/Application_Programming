public class Festival {
	public Band[] bands;
	private String festivalName;
	public Festival(String name){
		bands=new Band[0];
		festivalName=name;
	}

	/**
	 * Gets Name of Festival Name
	 * @return Name of Festival
	 */
	public String getFestivalName() {
		return festivalName;
	}

	/**
	 * Sets Name of Festival Name
	 * @param festivalName Name of Festival Name
	 */
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	/**
	 * Adds a Band to Festival
	 * @param band Band
	 */
	public void addBand(Band band){
		if(bands==null){
			bands=new Band[1];
			bands[0]=band;
			return ;
		}

		int len=bands.length;
		Band[] newBands=new Band[len+1];
		int i;
		for(i=0;i<len;i++)
			newBands[i]=bands[i];
		newBands[i]=band;
		bands=newBands;
	}

	@Override
	public String toString(){
		return festivalName;
	}
}
