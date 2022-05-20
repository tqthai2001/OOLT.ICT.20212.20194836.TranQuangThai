package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class TestMediaToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		Book book2 = new Book("Doraemon", "Comic", "I can can the can, but the can cannot can me", 56.78f);
		book2.addAuthor("Fujio");
		
		Track track1 = new Track("Bang Bang", 3);
		Track track2 = new Track("Bed", 3);
		Track track3 = new Track("Friday", 2);
		Track track4 = new Track("Follow You", 5);
		Track track5 = new Track("Baby Love", 5);
		
		CompactDisc cd1 = new CompactDisc("Workout Top Songs", "Power Music", "Spring", "V.A", 100.90f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		
		CompactDisc cd2 = new CompactDisc("World", "Pop", "Summer", "Alan Walker", 125.15f);
		cd2.addTrack(track3, track4, track5);
		
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(book2);
		mediae.add(cd1);
		mediae.add(cd2);
		
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}

}
