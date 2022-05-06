package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	
	//	Setter
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	//	Getter
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	//	Constructor
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	
	public String toString() {
		return "DVD - ID: " + this.id + " - " + this.title + " - " + this.category + " - " + this.director
				+ " - " + this.length + ": " + this.cost + " $";
	}
	
	public void seeDetail() {
		System.out.println("DVD - ID: " + this.id + " - " + this.title + " - " + this.category + " - " + this.director
				+ " - " + this.length + ": " + this.cost + " $");
	}

	public boolean isMatch(String title) {
		String [] tmpTitle = title.split(" ");
		String [] tmpDVDTitle = this.title.split(" ");
		for (int i = 0; i < tmpTitle.length; i++) {
			for (int j = 0; j < tmpDVDTitle.length; j++) {
				if (tmpDVDTitle[j].toLowerCase().contains(tmpTitle[i].toLowerCase())) return true;
			}
		}
		return false;
	}
}