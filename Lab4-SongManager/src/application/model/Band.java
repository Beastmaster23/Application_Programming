package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Band {
	public ArrayList<BandMember> getBandMembers() {
		return bandMembers;
	}

	public void setBandMembers(ArrayList<BandMember> bandMembers) {
		this.bandMembers = bandMembers;
	}

	private String name;
	private ArrayList<BandMember> bandMembers;
	
	public Band() {
		setName("");
		bandMembers=new ArrayList<BandMember>();
		
	}
	
	public void addMember(String member) {
		bandMembers.add(new BandMember(member));
	}
	
	public Band(String bandname) {
		setName(bandname);
		bandMembers=new ArrayList<BandMember>();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String output=name+"; Members:\n";
		for(BandMember member:bandMembers) {
			output+="\t- "+member+"\n";
		}
		return output;
	}
}
