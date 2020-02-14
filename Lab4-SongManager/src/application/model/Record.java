package application.model;

public class Record {
	private String name, id;
	
	private Band author;
	
	public Record(String recordName, String recordId, String recordAuthor) {
		name=recordName;
		id=recordId;
		author=new Band(recordAuthor);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Band getAuthor() {
		return author;
	}

	public void setAuthor(Band author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		String output="Title: "+name+"; ID: "+id+"\n";
		output+="Created by "+author;
		return output;
	}
}
