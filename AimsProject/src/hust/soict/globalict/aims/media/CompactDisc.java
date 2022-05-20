package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private List<Track> tracks = new ArrayList<Track>();
	private String artist;

	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public CompactDisc(String title, String category, String director, String artist, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	public CompactDisc(int id, String title, String category, float cost, LocalDate dateAdded, String director,
			int length, List<Track> tracks, String artist) {
		super(id, title, category, cost, dateAdded, director, length);
		this.tracks = tracks;
		this.artist = artist;
	}

	public void addTrack(Track track) {
		int count = 0;
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).equals(track)) count += 1;
		}
		if (count != 0)
			System.out.println("Track: " + track.getTitle() + " is already in CD!");
		else {
			tracks.add(track);
		}
	}
	
	public void addTrack(Track ... tracklist) {
		for (int i = 0; i < tracklist.length; i++) {
			int count = 0;
			for (int j = 0; j < tracks.size(); j++) {
				if (tracks.get(j).equals(tracklist[i])) count += 1;
			}
			if (count != 0)
				System.out.println("Track: " + tracklist[i].getTitle() + " is already in CD!");
			else {
				tracks.add(tracklist[i]);
			}
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		}
		else System.out.println("Track: " + this.getTitle() + " is not in list!");
	}
	
	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}
	
	public CompactDisc copyData() {
		CompactDisc tmpCompactDisc =
				new CompactDisc(this.id, this.title, this.category, 0f, this.dateAdded, this.director, this.getLength(),
						this.tracks, this.artist);
		return tmpCompactDisc;
	}
	
	public String toString() {
		return "CD - ID: " + this.id + " - " + this.title + " - " + this.category + " - " + this.director
				+ " - " + this.artist + " - " + this.getLength() + ": " + this.cost + " $";
	}
	
	public void seeDetail() {
		System.out.println("CD - ID: " + this.id + " - " + this.title + " - " + this.category + " - " + this.director
				+ " - " + this.artist + " - " + this.getLength() + ": " + this.cost + " $");
		System.out.println("..........Tracklist..........");
		for (int i = 0; i < tracks.size(); i++) {
			System.out.println(tracks.get(i).toString());
		}
	}
	
	public void play() {
		if (this.getLength() <= 0) System.out.println("CD: " + this.getTitle() + " cannot be played!");
		else {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			System.out.println("..........Tracklist..........");
			for (int i = 0; i < tracks.size(); i++) {
				tracks.get(i).play();
			}
		}
	}

}