package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ITEM = 50;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ITEM];
	private int qtyItem = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyItem < MAX_NUMBERS_ITEM) {
			itemsInStore[qtyItem] = disc;
			qtyItem += 1;
			System.out.println("The disc: " + disc.getTitle() + " has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void addDVD(DigitalVideoDisc ... dvdlist) {
		if (dvdlist.length + qtyItem < MAX_NUMBERS_ITEM) {
			for (int i = 0; i < dvdlist.length; i++) {
				itemsInStore[qtyItem] = dvdlist[i];
				qtyItem += 1;
				System.out.println("The disc: " + dvdlist[i].getTitle() + " has been added.");
			}
		}
		else {
			System.out.println("Can not add " + dvdlist.length + " disc(s).");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		int pos = -1;
		if (qtyItem <= 0) System.out.println("Store is empty.");
		else {
			for (int i = 0; i < qtyItem; i++) {
				if (itemsInStore[i] == disc) {
					pos = i;
				}
			}
			if (pos < 0 || pos > qtyItem) {
				System.out.println("The disc: " + disc.getTitle() + " is not in the store.");
			}
			else {
				for (int j = pos; j < qtyItem; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				qtyItem -= 1;
				System.out.println("The disc: " + disc.getTitle() + " has been removed.");
			}
		}
	}
	
	public void viewStore() {
		System.out.println("***********************STORE***********************");
		if (qtyItem <= 0) System.out.println("Store is empty!");
		else {
			for (int i = 1; i <= qtyItem; i++) {
				System.out.println(i + ". " + itemsInStore[i-1].toString());
			}
		}
		System.out.println("***************************************************");
	}
	
	public DigitalVideoDisc searchByTitle(String title) {
		for (int i = 0; i < qtyItem; i++) {
			if (title.equalsIgnoreCase(itemsInStore[i].getTitle())) {
//				itemsInStore[i].toString();
				return itemsInStore[i];
			}
		}
		return null;
	}
}