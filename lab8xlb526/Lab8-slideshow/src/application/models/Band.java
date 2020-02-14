package application.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Band {
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	private ArrayList<BandMember> members;
	private String name;
	public Band() {
		members=new ArrayList<BandMember>();
		name="";
	}
	
	public Band(String bandName) {
		members=new ArrayList<BandMember>();
		name=bandName;
	}
	public BandMember getMember(int index) {
		return members.get(index);
	}
	public void addMember(BandMember member) {
		members.add(member);
	}
	
	public int size() {
		return members.size();
	}
	
	public static Band loadBand(String namesCsv) throws FileNotFoundException {
		Band band=null;
		File f = new File(namesCsv);
		Scanner scan=new Scanner(f);
		
		if (scan.hasNextLine())band=new Band(scan.nextLine());
		while(scan.hasNextLine()) {
			String[] args=scan.nextLine().split(",");
			BandMember member=new BandMember();
			FileInputStream fin=new FileInputStream(args[1]);
			Image img=new Image(fin);
			member.setName(args[0]);
			member.setImg(img);
			band.addMember(member);
		}
		return band;
	}
	
}
