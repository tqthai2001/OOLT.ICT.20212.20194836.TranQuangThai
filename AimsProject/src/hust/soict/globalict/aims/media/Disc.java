package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Disc extends Media {

	protected String director;
	protected int length;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public Disc(int id, String title, String category, float cost, LocalDate dateAdded, String director, int length) {
		super(id, title, category, cost, dateAdded);
		this.director = director;
		this.length = length;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String director, int length) {
		super(title);
		this.director = director;
		this.length = length;
	}
	public Disc(String title) {
		super(title);
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}

}