package application.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Festival {
	private String name;
	private static boolean autoSave=false;
	
	private HashMap<String, FestivalStage> stages;

	public Festival(String name) {
		this.name = name;
		stages = new HashMap<String, FestivalStage>();
	}
	
	public static void setAutoSave(boolean b) {
		autoSave=b;
	}
	public static boolean getAutoSave() {
		return autoSave;
	}
	public void addStage(FestivalStage stage) {
		stages.put(stage.getName(), stage);
	}

	public FestivalStage getStage(String name) {
		return stages.get(name);
	}

	public Collection<FestivalStage> getStages() {
		return stages.values();
	}

	public Set<String> getStageNames() {
		return stages.keySet();
	}

	public static Festival loadFestival(String path) throws FileNotFoundException {
		Festival festival = null;
		File f = new File(path);

		Scanner scan = new Scanner(f);

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			if (festival == null) {
				festival = new Festival(name);
			} else {
				FestivalStage stage = new FestivalStage(name);
				festival.addStage(stage);
			}
		}
		return festival;
	}

	public void loadFestivalStages(String path) throws FileNotFoundException {
		File f = new File(path);

		Scanner scan = new Scanner(f);

		while (scan.hasNextLine()) {
			String[] args = scan.nextLine().split(",");
			FestivalStage stage = getStage(args[0]);
			if (stage == null) {
				stage = new FestivalStage(args[0]);
			}
			Band b=new Band(args[1]);
			stage.addBand(b);
			b.setGenre(Genre.valueOf(args[2].replaceAll(" ", "_")));
			addStage(stage);
		}
		// System.out.println(this);
	}

	public void saveStages(String path) throws IOException {
		File f = new File(path);

		FileWriter fw = new FileWriter(f);
		fw.write(getName()+"\n");
		for (String s : getStageNames()) {
			fw.write(s + "\n");
		}
		fw.close();
		// System.out.println(this);
	}

	public void saveBands(String path) throws IOException {
		File f = new File(path);

		FileWriter fw = new FileWriter(f);

		for (FestivalStage s : stages.values()) {
			for (Band b : s.getBands()) {
				
				fw.write(s.getName() + "," + b.getName() + "," + b.getGenre().toString().replaceAll("_", " ") + "\n");
				//System.out.println(b.getGenre());
			}
		}
		fw.close();
		// System.out.println(this);
	}

	@Override
	public String toString() {
		return "Festival [name=" + name + ", stages=" + stages + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
