package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.exception.ThresholdException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public int getQtyOrdered() {
		return itemsOrdered.size();
	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media: " + media.getTitle() + " has been added.");
			JOptionPane.showMessageDialog(null, "The media: " + media.getTitle() + " has been added.");
		}
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit.");
		}
	}
	
	public void addMedia(Media ... mediaList) throws LimitExceededException {
		if ((mediaList.length + itemsOrdered.size()) < MAX_NUMBERS_ORDERED) {
			for (int k = 0; k < mediaList.length; k++) {
				itemsOrdered.add(mediaList[k]);
				System.out.println("The media: " + mediaList[k].getTitle() + " has been added.");
			}
		}
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit.");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.size() <= 0)
			System.out.println("Cart is empty.");
		else {
			int count = 0;
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (itemsOrdered.get(i).equals(media)) {
					itemsOrdered.remove(media);
					System.out.println("The media: " + media.getTitle() + " has been removed.");
					count += 1;
				}
			}
			if (count == 0) System.out.println("The media: " + media.getTitle() + " is not in the cart.");
		}
	}
	
	public Media getALuckyItem() throws ThresholdException {
		if (itemsOrdered.size() < 5 || this.totalCost() < 200) {
			JOptionPane.showMessageDialog(null, "You need buy more to get lucky item!");
			throw new ThresholdException("You need buy more to get lucky item!");
		}
		else {
			float limit = 0;
			ArrayList<Media> itemsCanGetFree = new ArrayList<Media>();
			if (this.totalCost() < 300) {
				limit = 50;
			}
			else if (this.totalCost() >= 300 && this.totalCost() < 500) {
				limit = 100;
			}
			else {
				limit = 200;
			}
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (itemsOrdered.get(i).getCost() <= limit) {
					itemsCanGetFree.add(itemsOrdered.get(i));
				}
			}
//			Probability = 50%
			boolean fixedProbability = new Random().nextBoolean() ? true : false;			
			if (fixedProbability) {
				int luckyItem = (int)(Math.random() * itemsCanGetFree.size());
				return itemsCanGetFree.get(luckyItem);
			}
			else {
				JOptionPane.showMessageDialog(null, "Wish you luck next time!");
				throw new ThresholdException("Wish you luck next time!");
			}
		}
	}
	
	public void updateLuckyItemInCart() {
		Media luckyItem = null;
		try {
			luckyItem = getALuckyItem();
		} catch (ThresholdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (luckyItem != null) {
			if (luckyItem instanceof DigitalVideoDisc) {
				DigitalVideoDisc copyLuckyItem = ((DigitalVideoDisc) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
				JOptionPane.showMessageDialog(null, "Lucky Item: " + copyLuckyItem.getTitle());
			}
			else if (luckyItem instanceof Book) {
				Book copyLuckyItem = ((Book) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
				JOptionPane.showMessageDialog(null, "Lucky Item: " + copyLuckyItem.getTitle());
			}
			else if (luckyItem instanceof CompactDisc) {
				CompactDisc copyLuckyItem = ((CompactDisc) luckyItem).copyData();
				itemsOrdered.remove(luckyItem);
				itemsOrdered.add(copyLuckyItem);
				System.out.println("Lucky Item: ID: " + copyLuckyItem.getId() + " - " + copyLuckyItem.getTitle());
				JOptionPane.showMessageDialog(null, "Lucky Item: " + copyLuckyItem.getTitle());
			}
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
	
	public void removeByID(int id) {
		int count = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (id == itemsOrdered.get(i).getId()) {
				removeMedia(itemsOrdered.get(i));
				count += 1;
			}
		}
		if (count == 0) System.out.println("Invalid ID!");
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
					try {
						tmpDVD.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (itemsOrdered.get(i) instanceof CompactDisc) {
					CompactDisc tmpCD = (CompactDisc) itemsOrdered.get(i);
					try {
						tmpCD.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				System.out.println("");
			}
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void sortByAlphabetAndDecreasingCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByDecreasingCostAndAlphabet() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void sortByAlphabetTitleCategory() {
		Collections.sort(itemsOrdered);
	}
}