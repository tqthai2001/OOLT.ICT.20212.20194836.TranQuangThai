package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
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
		
		store.addDVD(dvd10);
		store.addDVD(dvd9);
		store.addDVD(dvd1, dvd2, dvd3);
		store.viewStore();
		
		System.out.println("");
		store.removeDVD(dvd10);
		store.removeDVD(dvd5);
		store.viewStore();
	}

}