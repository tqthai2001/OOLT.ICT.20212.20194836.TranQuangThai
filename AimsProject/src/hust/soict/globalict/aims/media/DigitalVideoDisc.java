package hust.soict.globalict.aims.media;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
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
	public DigitalVideoDisc(int id, String title, String category, float cost, LocalDate dateAdded, String director, int length) {
		super(id, title, category, cost, dateAdded, director, length);
	}
	
	public DigitalVideoDisc copyData() {
		DigitalVideoDisc tmpDigitalVideoDisc =
				new DigitalVideoDisc(this.id, this.title, this.category, 0f, this.dateAdded, this.director, this.length);
		return tmpDigitalVideoDisc;
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
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			JOptionPane.showMessageDialog(null, "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}

}