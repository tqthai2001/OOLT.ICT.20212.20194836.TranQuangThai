package hust.soict.globalict.aims.media;

public class Track implements Playable {

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
	
	public String toString() {
		return "Track: " + this.title + " - " + this.length;
	}
	
	public void play() {
		if (this.getLength() <= 0) System.out.println("Track cannot be played!");
		else {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}

}