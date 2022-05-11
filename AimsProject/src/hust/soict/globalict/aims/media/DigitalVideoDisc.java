package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc {
	
	//	Constructor
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
//	public DigitalVideoDisc copyData() {
//		DigitalVideoDisc tmDigitalVideoDisc = new DigitalVideoDisc(this.title, this.category, this.director, this.length, this.cost);
//		tmDigitalVideoDisc.setId(this.id);
//		tmDigitalVideoDisc.setDateAdded(this.dateAdded);
//		return tmDigitalVideoDisc;
//	}
	
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