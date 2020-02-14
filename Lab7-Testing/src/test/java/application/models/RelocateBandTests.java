package application.models;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import application.models.Band;
import application.models.Festival;
import application.models.FestivalStage;

public class RelocateBandTests {
	private String correctFestivalFilePath = "festival/correctFileFormat.csv";
	private String correctStagesFilePath = "stages/correctFileFormat.csv";
	private String pathFestival = "resources/festival.csv";
	private String pathStages = "resources/stage_bands.csv";

	private String validStageName = "Space Stage";
	private String validBandName = "HALO";
	private int validIndex = 0;

	private ClassLoader loader;

	@Before
	public void setup() {
		loader = getClass().getClassLoader();
	}

	@Test
	public void relocateToNext() {
		Festival festival;
		try {
			festival = Festival.loadFestival(loader.getResource(correctFestivalFilePath).getPath());
			
			festival.loadFestivalStages(loader.getResource(correctStagesFilePath).getPath());
			String stage1="World Stage";
			String stage2="Space Stage";
			String stage3="Ground Stage";
			String stage4="Sky Stage";
			String stage5="Clueless Stage";
			String stage6="Empty Stage";
			
			//Moving member to full
			FestivalStage stage=festival.getStage(stage1);
			FestivalStage stageTwo=festival.getStage(stage2);
			Band band=stage.getBands().get(0);
			
			System.out.println(stage);
			stage.relocateBand(0, stageTwo);
			
			System.out.println(stage);
			System.out.println(stageTwo);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
