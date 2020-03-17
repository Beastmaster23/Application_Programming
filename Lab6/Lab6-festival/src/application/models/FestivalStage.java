package application.models;

import java.util.ArrayList;

public class FestivalStage {
	private String name;
	
	private ArrayList<Band> bands;
	private Genre genre;
	
	public FestivalStage(String name) {
		this.name=name;
		bands=new ArrayList<Band>();
		genre=Genre.None;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBand(Band band) {
		
		this.bands.add(band);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public ArrayList<Band> getBands() {
		return bands;
	}

	public void setBands(ArrayList<Band> bands) {
		this.bands = bands;
	}	
}
