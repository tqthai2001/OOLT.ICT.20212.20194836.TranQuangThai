package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track> {

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			if (track.title.equals(this.title) && track.length == this.length) return true;
		}
		return false;
	}
	
	public String toString() {
		return "Track: " + this.title + " - " + this.length;
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
	
	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		if (this.title.compareTo(o.title) == 0)
			return this.length - o.length;
		return this.title.compareTo(o.title);
	}

}