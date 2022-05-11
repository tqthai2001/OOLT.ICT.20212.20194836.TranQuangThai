package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public int getQtyOrdered() {
		return itemsOrdered.size();
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media: " + media.getTitle() + " has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void addMedia(Media ... mediaList) {
		if ((mediaList.length + itemsOrdered.size()) < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < mediaList.length; i++) {
				itemsOrdered.add(mediaList[i]);
				System.out.println("The media: " + mediaList[i].getTitle() + " has been added.");
			}
		}
		else {
			System.out.println("Can not add " + mediaList.length + " media(s).");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.size() <= 0)
			System.out.println("Cart is empty.");
		else {
			if (itemsOrdered.contains(media)) {
				itemsOrdered.remove(media);
				System.out.println("The media: " + media.getTitle() + " has been removed.");
			}
			else System.out.println("The media: " + media.getTitle() + " is not in the cart.");
		}
	}
	
	public Media getALuckyItem() {
		int luckyItem = (int)(Math.random() * itemsOrdered.size());
		return itemsOrdered.get(luckyItem);
	}
	
	public void updateLuckyItemInCart() {
		if (itemsOrdered.size() > 0) {
			Media luckyItem = getALuckyItem();
			if (luckyItem instanceof DigitalVideoDisc) {
				DigitalVideoDisc copyLuckyItem = ((DigitalVideoDisc) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
			}
			else if (luckyItem instanceof Book) {
				Book copyLuckyItem = ((Book) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
			}
			else if (luckyItem instanceof CompactDisc) {
				CompactDisc copyLuckyItem = ((CompactDisc) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
			}
		}
		else {
			System.out.println("Empty cart! Can not get lucky item.");
		}
	}

	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void removeByName(String title) {
		int count = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (title.equalsIgnoreCase(itemsOrdered.get(i).getTitle())) {
				removeMedia(itemsOrdered.get(i));
				count += 1;
			}
		}
		if (count == 0) System.out.println("Invalid title!");
	}
	
	public void emptyCart() {
		itemsOrdered.clear();
	}
	
	public void playByID(int id) {
		int count = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				if (itemsOrdered.get(i) instanceof Book) {
					System.out.println("Book cannot be played!");
				}
				else if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
					DigitalVideoDisc tmpDVD = (DigitalVideoDisc) itemsOrdered.get(i);
					tmpDVD.play();
				}
				else if (itemsOrdered.get(i) instanceof CompactDisc) {
					CompactDisc tmpCD = (CompactDisc) itemsOrdered.get(i);
					tmpCD.play();
				}
				count += 1;
			}
		}
		if (count == 0) System.out.println("No match is found.");
	}
	
	public void searchByID(int id) {
		int count = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println("Found: " + itemsOrdered.get(i).toString());
				count += 1;
			}
		}
		if (count == 0) System.out.println("No match is found.");
	}
	
	public void searchByTitle(String title) {
		int count = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(title)) {
				System.out.println("Found: " + itemsOrdered.get(i).toString());
				count += 1;
			}
		}
		if (count == 0) System.out.println("No match is found.");
	}
	
	public void printCartGeneral() {
		System.out.println("***********************CART***********************");
		if (itemsOrdered.size() <= 0) System.out.println("Empty cart!");
		else {
			for (int i = 1; i <= itemsOrdered.size(); i++) {
				System.out.println(i + ". " + itemsOrdered.get(i-1).toString());
			}
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void sortByAlphabetAndDecreasingCost() {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = 0; j < itemsOrdered.size() - i - 1; j++) {
				if ((itemsOrdered.get(j).getTitle().compareToIgnoreCase(itemsOrdered.get(j+1).getTitle())) > 0) {
					Collections.swap(itemsOrdered, j, j+1);
				}
				else if ((itemsOrdered.get(j).getTitle().compareToIgnoreCase(itemsOrdered.get(j+1).getTitle())) == 0
						&& itemsOrdered.get(j).getCost() < itemsOrdered.get(j+1).getCost()) {
					Collections.swap(itemsOrdered, j, j+1);
				}
			}
		}
	}
	
	public void sortByDecreasingCostAndAlphabet() {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = 0; j < itemsOrdered.size() - i - 1; j++) {
				if (itemsOrdered.get(j).getCost() < itemsOrdered.get(j+1).getCost()) {
					Collections.swap(itemsOrdered, j, j+1);
				}
				else if (itemsOrdered.get(j).getCost() == itemsOrdered.get(j+1).getCost()
						&& (itemsOrdered.get(j).getTitle().compareToIgnoreCase(itemsOrdered.get(j+1).getTitle())) > 0) {
					Collections.swap(itemsOrdered, j, j+1);
				}
			}
		}
	}
}