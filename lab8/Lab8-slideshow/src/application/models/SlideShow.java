package application.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class SlideShow {

	/**
	 * @return the band
	 */
	public Band getBand() {
		return band;
	}
	/**
	 * @param band the band to set
	 */
	public void setBand(Band band) {
		this.band = band;
	}
	/**
	 * @return the currentIndex
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}
	/**
	 * @param currentIndex the currentIndex to set
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	private Band band;
	
	private int currentIndex;
	public SlideShow(Band b) {
		band=b;
		currentIndex=0;
	}
	public void next() {
		currentIndex += 1;
		if(currentIndex>=band.size()) {
			currentIndex=0;
		}
	}
	public void previous() {
		currentIndex -= 1;
		if(currentIndex<0) {
			currentIndex=band.size()-1;
		}
	}
	
	public BandMember getCurrent() {
		return band.getMember(currentIndex);
	}
}
