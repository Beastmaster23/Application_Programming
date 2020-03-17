package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * It holds Records
 * @author Interco
 */
public class RecordLabel {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	private String name;
	private ArrayList<Record> records;
	
	public RecordLabel() {
		name="";
		records=new ArrayList<Record>();
		
	}
	
	public RecordLabel(String labelName) {
		name=labelName;
		records=new ArrayList<Record>();
	}
	
	public static RecordLabel createRecordLabel(String labelName, String bandsPath, String recordsPath) {
		RecordLabel label=new RecordLabel(labelName);
		label.setRecords(label.loadRecords(recordsPath));
		label.loadBands(bandsPath);
		return label;
	}
	
	public static RecordLabel createRecordLabel(String bandsPath, String recordsPath) {
		RecordLabel label=new RecordLabel();
		label.setRecords(label.loadRecords(recordsPath));
		label.loadBands(bandsPath);
		return label;
	}
	/**
	 * Finds Band by Band name
	 * @param bandName Name of band
	 * @return Band
	 */
	public Band findBandByName(String bandName) {
		for(Record record:records) {
			if(record.getAuthor()!=null&&record.getAuthor().getName().compareTo(bandName)==0) {
				//System.out.println(""+record.getAuthor());
				return record.getAuthor();
			}
		}
		
		return null;
	}
	
	/**
	 * Finds Record by song name
	 * @param songName Name of song
	 * @return Record
	 */
	public Record findRecordBySong(String songName) {
		for(Record record:records) {
			if(record.getName().compareTo(songName)==0) {
				//System.out.println(""+record.getAuthor());
				return record;
			}
		}
		
		return null;
	}
	
	/**
	 * Finds Records by song name
	 * @param songName Name of song
	 * @return ArrayList<Record>
	 */
	public ArrayList<Record> findRecordsBySong(String songName) {
		ArrayList<Record> found=new ArrayList<Record>();
		for(Record record:records) {
			if(record.getName().toLowerCase().contains(songName.toLowerCase())) {
				//System.out.println(""+record.getAuthor());
				found.add(record);
			}
		}
		
		return found;
	}
	
	/**
	 * Add BandMembers into their respecting Band
	 * @param bandsPath path of band file
	 */
	public void loadBands(String bandsPath) {
		try {
			File recordsFile=new File(bandsPath);
			if(recordsFile.isFile()&&recordsFile.canRead()) {
				try {
					Scanner csvParser=new Scanner(recordsFile);
					
					while(csvParser.hasNextLine()) {
						String[] csv=csvParser.nextLine().split(",");
						if(csv.length<2) {
							System.err.println("File isn't in the right format. 2 coloumns");
						}
						Band band=findBandByName(csv[0]);
						if(band!=null) {
							band.addMember(csv[1]);
						}
					}
				} catch (FileNotFoundException e) {
					System.err.println("File couldn't be found");
				}
				
			}
		}catch(NullPointerException e){
			System.err.println("Path is null");
		}
		//System.out.println("Bands loaded"+records);
	}
	
	/**
	 * Add Records onto records
	 * @param recordsPath path of Record file
	 * @return
	 */
	public static ArrayList<Record> loadRecords(String recordsPath) {
		ArrayList<Record> loadedRecords=new ArrayList<Record>();
		try {
			File recordsFile=new File(recordsPath);
			if(recordsFile.isFile()&&recordsFile.canRead()) {
				try {
					Scanner csvParser=new Scanner(recordsFile);
					while(csvParser.hasNextLine()) {
						String[] csv=csvParser.nextLine().split(",");
						loadedRecords.add(new Record(csv[1], csv[0], csv[2]));
					}
				} catch (FileNotFoundException e) {
					System.err.println("File couldn't be found");
				}
				
			}
		}catch(NullPointerException e){
			System.err.println("Path is null");
		}
		//System.out.println("Records loaded"+loadedRecords);
		return loadedRecords;
	}
	
}
