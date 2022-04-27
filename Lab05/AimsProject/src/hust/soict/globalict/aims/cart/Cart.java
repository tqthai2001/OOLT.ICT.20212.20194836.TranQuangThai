package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;
import hust.soict.globalict.test.disc.TestPassingParameter;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc: " + disc.getTitle() + " has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdlist) {
//		if (dvdlist.length + qtyOrdered < MAX_NUMBERS_ORDERED) {
//			for (int i = 0; i < dvdlist.length; i++) {
//				itemsOrdered[qtyOrdered] = dvdlist[i];
//				qtyOrdered += 1;
//				System.out.println("The disc: " + dvdlist[i].getTitle() + " has been added.");
//			}
//		}
//		else {
//			System.out.println("Can not add " + dvdlist.length + " disc(s).");
//		}
//	}
	
//	Pass an arbitrary number of arguments
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdlist) {
		if (dvdlist.length + qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdlist.length; i++) {
				itemsOrdered[qtyOrdered] = dvdlist[i];
				qtyOrdered += 1;
				System.out.println("The disc: " + dvdlist[i].getTitle() + " has been added.");
			}
		}
		else {
			System.out.println("Can not add " + dvdlist.length + " disc(s).");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (2 + qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 2;
			System.out.println("The disc: " + dvd1.getTitle() + " has been added.");
			System.out.println("The disc: " + dvd2.getTitle() + " has been added.");
		}
		else {
			System.out.println("Can not add 2 discs.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int pos = -1;
		if (qtyOrdered <= 0) System.out.println("Cart is empty.");
		else {
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i] == disc) {
					pos = i;
				}
			}
			if (pos < 0 || pos > qtyOrdered) {
				System.out.println("The disc: " + disc.getTitle() + " is not in the cart.");
			}
			else {
				for (int j = pos; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered -= 1;
				System.out.println("The disc: " + disc.getTitle() + " has been removed.");
			}
		}
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public void sortCartByCost() {
		DigitalVideoDisc[] tmpCart = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			tmpCart[i] = itemsOrdered[i];
		}
		tmpCart = DVDUtils.sortByCost(tmpCart);
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(tmpCart[i].toString());
		}
	}
	
	public void sortCartByTitle() {
		DigitalVideoDisc[] tmpCart = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			tmpCart[i] = itemsOrdered[i];
		}
		tmpCart = DVDUtils.sortByTitle(tmpCart);
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(tmpCart[i].toString());
		}
	}
	
	public void searchByID(int id) {
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Found: " + itemsOrdered[i].toString());
				count += 1;
			}
		}
		if (count == 0) System.out.println("No match is found.");
	}
	
	public void printCart() {
		for (int i = 0; i < qtyOrdered - 1; i++) {
			for (int j = 0; j < qtyOrdered - i - 1; j++) {
				if (DVDUtils.compareByTitle(itemsOrdered[j], itemsOrdered[j+1]) > 0) {
					TestPassingParameter.swap(itemsOrdered[j], itemsOrdered[j+1]);
				}
				else if (DVDUtils.compareByTitle(itemsOrdered[j], itemsOrdered[j+1]) == 0
						&& DVDUtils.compareByCost(itemsOrdered[j], itemsOrdered[j+1]) < 0) {
					TestPassingParameter.swap(itemsOrdered[j], itemsOrdered[j+1]);
				}
				else if (DVDUtils.compareByTitle(itemsOrdered[j], itemsOrdered[j+1]) == 0
						&& DVDUtils.compareByCost(itemsOrdered[j], itemsOrdered[j+1]) == 0
						&& itemsOrdered[j].getLength() < itemsOrdered[j+1].getLength()) {
					TestPassingParameter.swap(itemsOrdered[j], itemsOrdered[j+1]);
				}
			}
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <= qtyOrdered; i++) {
			System.out.println(i + ". " + itemsOrdered[i-1].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
}