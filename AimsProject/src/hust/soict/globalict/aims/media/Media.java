package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	protected LocalDate dateAdded;
	
//	Getter
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public static int getNbMedia() {
		return nbMedia;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public Media() {
		// TODO Auto-generated constructor stub
		super();
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public Media(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia += 1;
		this.id = nbMedia;
	}
	public Media(int id, String title, String category, float cost, LocalDate dateAdded) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded;
	}
	
	public String toString() {
		return "ID: " + this.id + " - " + this.title + " - " + this.category +
				": " + this.cost + " $";
	}
	
	public void seeDetail() {
		System.out.println("ID: " + this.id + " - " + this.title + " - " + this.category +
				": " + this.cost + " $");
	}
	
	public boolean isMatch(String title) {
		String [] tmpTitle = title.split(" ");
		String [] tmpMediaTitle = this.title.split(" ");
		for (int i = 0; i < tmpTitle.length; i++) {
			for (int j = 0; j < tmpMediaTitle.length; j++) {
				if (tmpMediaTitle[j].toLowerCase().contains(tmpTitle[i].toLowerCase())) return true;
			}
		}
		return false;
	}

}