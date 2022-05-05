package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-Man",
				"Science Fiction", "Tom Holland", 87, 100.23f);
//		**********************************************************
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Russo", 100, 90.91f);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Holland", 87, 93.96f);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Cruise", 99, 93.96f);
//		**********************************************************
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Joe", 70, 86.90f);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Captain America",
				"Science Fiction", "Lucas", 79, 88.22f);
		
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Joe", 70, 86.90f);
		
		DigitalVideoDisc[] dvdlist = new DigitalVideoDisc[] {dvd10, dvd9, dvd8};
		
//		ADD
		System.out.println("__________ADD__________");
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvd4, dvd5); // Add 2 elements
		cart.addMedia(dvd6, dvd7);
		cart.addMedia(dvdlist); // Add many elements dvd8, dvd9, dvd10
		cart.printCartGeneral();
		
//		SEARCH BY TITLE
		System.out.println("__________SEARCH BY TITLE__________");
		cart.searchByTitle("Tiger King");
	}

}