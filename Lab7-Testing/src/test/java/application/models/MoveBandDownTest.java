package application.models;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class MoveBandDownTest {
	private String correctFestivalFilePath = "festival/correctFileFormat.csv";
	private String correctStagesFilePath = "stages/correctFileFormat.csv";
	private String pathFestival = "resources/festival.csv";
	private String pathStages = "resources/stage_bands.csv";
	
	private ClassLoader loader;

	@Before
	public void setup() {
		loader = getClass().getClassLoader();
	}


	@Test
	public void moveBandDownTest() {
		try {
			Festival festival = Festival.loadFestival(loader.getResource(correctFestivalFilePath).getPath());
			festival.loadFestivalStages(loader.getResource(correctStagesFilePath).getPath());
			String stage1="World Stage";
			String stage2="Space Stage";
			String stage3="Ground Stage";
			String stage4="Sky Stage";
			String stage5="Clueless Stage";
			String stage6="Empty Stage";
			String bandMember="ACDC";
			//Moving above min
			FestivalStage stage=festival.getStage(stage1);
			//System.out.println(stage);
			stage.moveDownByIndex(-1);
			assertEquals(1, stage.getIndexByName(bandMember));
			//System.out.println(stage);
			//Moving normally
			//System.out.println(stage);
			stage.moveDownByIndex(1);
			assertEquals(0, stage.getIndexByName(bandMember));
			//System.out.println(stage);
			
			//Moving above max
			//System.out.println(stage);
			stage.moveDownByIndex(0);
			assertEquals(0, stage.getIndexByName(bandMember));
			//System.out.println(stage);
			
			//Moving Non-existing member
			stage=festival.getStage(stage6);
			//System.out.println(stage);
			stage.moveDownByIndex(0);
			assertEquals(-1, stage.getIndexByName(bandMember));
			//System.out.println(stage);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
