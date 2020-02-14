package application.models;

import java.util.ArrayList;

public class FestivalStage {
	private String name;

	private ArrayList<Band> bands;
	private Genre genre;
	private int maxBands = 5;

	public FestivalStage(String name) {
		this.name = name;
		bands = new ArrayList<Band>();
		genre = Genre.None;
	}

	public void relocateBand(int index, FestivalStage stage) {
		if (stage.bands.size() >= stage.maxBands)
			return;
		Band band = bands.remove(index);
		if (band != null) {
			stage.addBand(band);
		}
	}

	public void relocateBand(String name, FestivalStage stage) {
		if (stage.bands.size() >= stage.maxBands)
			return;
		Band band = bands.remove(getIndexByName(name));
		if (band != null) {
			stage.addBand(band);
		}
	}

	public int getIndexByName(String name) {
		for (int i = 0; i < bands.size(); i++) {
			if (bands.get(i).getName().compareTo(name) == 0) {
				return i;
			}
		}
		return -1;
	}

	public void moveUpByIndex(int i) {
		if (bands.size() > 1 && i > -1 && i + 1 < bands.size())
			bands.add(i + 1, bands.remove(i));
	}

	public void moveDownByIndex(int i) {
		if (bands.size() != 1 && i > 0)
			bands.add(i - 1, bands.remove(i));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Band removeBand(Band band) {
		Band removed = null;
		if (this.bands.remove(band)) {
			removed = band;
		}
		return removed;
	}

	public Band removeBandByIndex(int index) {
		return this.bands.remove(index);
	}

	public void addBand(Band band) {
		if (bands.size() < maxBands)
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

	@Override
	public String toString() {
		return "FestivalStage [name=" + name + ", bands=" + bands + ", genre=" + genre + "]";
	}
}
