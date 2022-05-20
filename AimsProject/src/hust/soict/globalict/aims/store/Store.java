package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_ITEM = 50;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.size() < MAX_NUMBERS_ITEM) {
			itemsInStore.add(media);
			System.out.println("The media: " + media.getTitle() + " has been added.");
		}
		else {
			System.out.println("The store is almost full.");
		}
	}
	
	public void addMedia(Media ... mediaList) {
		if ((mediaList.length + itemsInStore.size()) < MAX_NUMBERS_ITEM) {
			for (int i = 0; i < mediaList.length; i++) {
				itemsInStore.add(mediaList[i]);
				System.out.println("The media: " + mediaList[i].getTitle() + " has been added.");
			}
		}
		else {
			System.out.println("Can not add " + mediaList.length + " media(s).");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.size() <= 0)
			System.out.println("Store is empty.");
		else {
			if (itemsInStore.contains(media)) {
				itemsInStore.remove(media);
				System.out.println("The media: " + media.getTitle() + " has been removed.");
			}
			else System.out.println("The media: " + media.getTitle() + " is not in the store.");
		}
	}
	
	public void viewStore() {
		System.out.println("***********************STORE***********************");
		if (itemsInStore.size() <= 0) System.out.println("Store is empty!");
		else {
			for (int i = 1; i <= itemsInStore.size(); i++) {
				System.out.println(i + ". " + itemsInStore.get(i-1).toString());
				System.out.println("");
			}
		}
		System.out.println("***************************************************");
	}
	
	public void viewStoreSpecific() {
		ArrayList<Media> dvdInStore = new ArrayList<Media>();
		System.out.println("***********************STORE***********************");
		if (itemsInStore.size() <= 0) System.out.println("Store is empty!");
		else {
			System.out.println("---------- BOOK & CD ----------");
			for (int i = 1; i <= itemsInStore.size(); i++) {
				if (itemsInStore.get(i-1) instanceof Book || itemsInStore.get(i-1) instanceof CompactDisc) {
					itemsInStore.get(i-1).seeDetail();
					System.out.println("");
				}
				else if (itemsInStore.get(i-1) instanceof DigitalVideoDisc) {
					dvdInStore.add(itemsInStore.get(i-1));
				}
			}
//			Sort DVD in store
			for (int i = 0; i < dvdInStore.size() - 1; i++) {
				for (int j = 0; j < dvdInStore.size() - i - 1; j++) {
					if ((dvdInStore.get(j).getTitle().compareToIgnoreCase(dvdInStore.get(j+1).getTitle())) > 0) {
						Collections.swap(dvdInStore, j, j+1);
					}
					else if ((dvdInStore.get(j).getTitle().compareToIgnoreCase(dvdInStore.get(j+1).getTitle())) == 0
							&& dvdInStore.get(j).getCost() < dvdInStore.get(j+1).getCost()) {
						Collections.swap(dvdInStore, j, j+1);
					}
				}
			}
			System.out.println("---------- DVD ----------");
			for (int i = 1; i <= dvdInStore.size(); i++) {
				System.out.println(dvdInStore.get(i-1).toString());
			}
		}
		System.out.println("***************************************************");
	}
	
	public Media searchByID(int id) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (id == itemsInStore.get(i).getId()) {
				return itemsInStore.get(i);
			}
		}
		return null;
	}
	
	public Media searchByTitle(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (title.equalsIgnoreCase(itemsInStore.get(i).getTitle())) {
				return itemsInStore.get(i);
			}
		}
		return null;
	}
	
	public void playByID(int id) {
		int count = 0;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getId() == id) {
				if (itemsInStore.get(i) instanceof Book) {
					System.out.println("Book cannot be played!");
				}
				else if (itemsInStore.get(i) instanceof DigitalVideoDisc) {
					DigitalVideoDisc tmpDVD = (DigitalVideoDisc) itemsInStore.get(i);
					tmpDVD.play();
				}
				else if (itemsInStore.get(i) instanceof CompactDisc) {
					CompactDisc tmpCD = (CompactDisc) itemsInStore.get(i);
					tmpCD.play();
				}
				count += 1;
			}
		}
		if (count == 0) System.out.println("No match is found.");
	}
}