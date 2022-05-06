package hust.soict.globalict.aims.store;

import java.util.ArrayList;

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
			}
		}
		System.out.println("***************************************************");
	}
	
	public Media searchByTitle(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (title.equalsIgnoreCase(itemsInStore.get(i).getTitle())) {
				return itemsInStore.get(i);
			}
		}
		return null;
	}
}