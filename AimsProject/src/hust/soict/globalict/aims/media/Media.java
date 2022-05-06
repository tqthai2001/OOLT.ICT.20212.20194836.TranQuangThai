package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {

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

//	Setter
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
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
	
	public String toString() {
		return "ID: " + this.id + " - " + this.title + " - " + this.category +
				": " + this.cost + " $";
	}
	
	public void seeDetail() {
		System.out.println("ID: " + this.id + " - " + this.title + " - " + this.category +
				": " + this.cost + " $");
	}

}