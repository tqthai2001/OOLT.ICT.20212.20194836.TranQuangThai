package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

	private List<String> tracks = new ArrayList<String>();
	private String artist;

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addAuthor(String trackName) {
		if (tracks.contains(trackName))
			System.out.println("Track is already!");
		else {
			tracks.add(trackName);
		}
	}
	
	public void removeAuthor(String trackName) {
		if (tracks.contains(trackName)) {
			tracks.remove(trackName);
		}
		else System.out.println("Track is not in list!");
	}
	
	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
		}
		return length;
	}

}
