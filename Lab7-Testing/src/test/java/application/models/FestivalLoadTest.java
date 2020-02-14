package application.models;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class FestivalLoadTest {

	private String correctFestivalFilePath = "festival/correctFileFormat.csv";
	private String incorrectFestivalFilePath = "festival/wrongFileFormat.csv";
	private String notFoundFestivalFilePath = "festival/notFound.csv";
	private ClassLoader loader;

	@Before
	public void setup() {
		loader = getClass().getClassLoader();
	}

	@Test(expected = FileNotFoundException.class)
	public void loadNotFoundFestival() throws FileNotFoundException {
		Festival correctFestival = Festival.loadFestival(notFoundFestivalFilePath);
	}

	@Test
	public void loadFestival() {		
		try {

			File f = new File(loader.getResource(correctFestivalFilePath).getPath());

			Scanner scan = new Scanner(f);
			ArrayList<String> values = new ArrayList<String>();

			while (scan.hasNextLine()) {
				String value = scan.nextLine();
				values.add(value);
			}
			scan.close();

			Festival correctFestival = Festival.loadFestival(loader.getResource(correctFestivalFilePath).getPath());

			assertEquals(values.get(0), correctFestival.getName());
			for(int i=0;i<correctFestival.getStages().size();i++) {
				assertEquals(values.get(i+1), correctFestival.getStage(values.get(i+1)).getName());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// fail("Not yet implemented");
	}

}
