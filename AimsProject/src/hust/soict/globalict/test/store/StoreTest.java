package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
//		**********************************************************
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Russo", 100, 90.91f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Holland", 87, 93.96f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Cruise", 99, 93.96f);
//		**********************************************************
		
		Book book1 = new Book("Conan", "Manga", "Special drama for the live-action of Detective Conan", 25.75f);
		book1.addAuthor("Gosho");
		book1.addAuthor("Thai");
		
		Book book2 = new Book("Doraemon", "Comic", "I can can the can, but the can cannot can me", 56.78f);
		book2.addAuthor("Fujio");
		
//		ADD
		System.out.println("__________ADD__________");
		store.addMedia(dvd1, dvd2, dvd3, dvd1);
		store.addMedia(dvd4, dvd5); // Add 2 elements
		store.addMedia(book1, book2);
		
//		REMOVE
		System.out.println("");
		System.out.println("__________REMOVE__________");
		store.removeMedia(dvd3);
		store.removeMedia(book1);
		System.out.println("");
		
		store.viewStore();
	}

}