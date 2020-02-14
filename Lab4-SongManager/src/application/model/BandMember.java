package application.model;

public class BandMember {
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private String name;
	public BandMember(String member) {
		name=member;
	}
	
	
	public String toString() {
		String output=name;
		return output;
	}
}
