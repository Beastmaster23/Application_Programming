package application.models;

public class Band {
	private String name;
	private Genre genre;

	public Band(String name) {
		this.name = name;
		genre = Genre.None;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Band [name=" + name + ", genre=" + genre + "]";
	}

}
