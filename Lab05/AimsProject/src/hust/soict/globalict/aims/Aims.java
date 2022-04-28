package hust.soict.globalict.aims;

import java.util.Scanner;

import javax.swing.text.View;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.utils.DVDUtils;
import hust.soict.globalict.test.disc.TestPassingParameter;

public class Aims {

	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		Store anItem = new Store();
		Scanner scanner = new Scanner(System.in);
		int mainChoice, storeChoice, cartChoice;
		
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
		
		anItem.addDVD(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10);
		
		do {
			showMenu();
			System.out.print("Type here: ");
			mainChoice = scanner.nextInt();
			
			switch (mainChoice) {
			case 0: break;
//			__________VIEW STORE__________
			case 1:
			{
				do {
					anItem.viewStore();
					storeMenu();
					System.out.print("Type here: ");
					storeChoice = scanner.nextInt();
					
					switch (storeChoice) {
					case 0: break;
					case 1:
					{
						System.out.print("Enter the title of the DVD: ");
						scanner.nextLine(); // clear buffer stdin
						String tmpTitle = scanner.nextLine();
						DigitalVideoDisc tmpDVD = anItem.searchByTitle(tmpTitle);
						if (tmpDVD == null) System.out.println("Invalid title!");
						else {
							System.out.println(tmpDVD.toString());
							System.out.println("Do you want to add this DVD to your cart?");
							System.out.print("Type Y/N: ");
							char c = scanner.next().charAt(0);
							if (c == 'Y' || c == 'y') {
								anOrder.addDigitalVideoDisc(tmpDVD);
							}
							else System.out.println("Thank you.");
						}
						break;
					}
					case 2:
					{
						System.out.print("Enter the title of the DVD: ");
						scanner.nextLine();
						String tmpTitle = scanner.nextLine();
						DigitalVideoDisc tmpDVD = anItem.searchByTitle(tmpTitle);
						if (tmpDVD == null) System.out.println("Invalid title!");
						else {
							anOrder.addDigitalVideoDisc(tmpDVD);
							System.out.println("The number of DVDs in the cart: " + anOrder.getQtyOrdered());
						}
						break;
					}
					case 3:
					{
						do {
							anOrder.printCartGeneral();
							cartMenu();
							System.out.print("Type here: ");
							cartChoice = scanner.nextInt();
							switch (cartChoice) {
							case 0: break;
							case 1:
							{
								System.out.println("Filter by ID (1) or by title (2).");
								System.out.println("Type 1 or 2: ");
								int choice = scanner.nextInt();
								if (choice == 1) {
									System.out.print("Type ID here: ");
									int id = scanner.nextInt();
									anOrder.searchByID(id);
								}
								else if (choice == 2) {
									System.out.print("Type title here: ");
									scanner.nextLine();
									String title = scanner.nextLine();
									anOrder.searchByTitle(title);
								}
								else System.out.println("Unexpected value: " + choice);
								break;
							}
							case 2:
							{
								System.out.println("Sort by title (1) or by cost (2).");
								System.out.println("Type 1 or 2: ");
								int choice = scanner.nextInt();
								if (choice == 1) anOrder.sortByAlphabetAndDecreasingCost();
								else if (choice == 2) anOrder.sortByDecreasingCostAndAlphabet();
								else System.out.println("Unexpected value: " + choice);
								break;
							}
							case 3:
							{
								System.out.print("Enter the title of the DVD: ");
								scanner.nextLine();
								String tmpTitle = scanner.nextLine();
								anOrder.removeByName(tmpTitle);
								break;
							}
							case 4:
							{
								anOrder.emptyCart();
								System.out.println("An order is created.");
								break;
							}
							default:
								System.out.println("Unexpected value: " + cartChoice);
							}
						} while (cartChoice != 0);
						break;
					}
					default:
						System.out.println("Unexpected value: " + storeChoice);
					}
				} while (storeChoice != 0);
				break;
			}
//			__________END VIEW STORE__________
			
//			__________UPDATE STORE__________
			case 2:
			{
				anItem.viewStore();
				System.out.println("Do you want to ADD (1) or REMOVE (2) a DVD?");
				System.out.println("Type 1 or 2: ");
				int choice = scanner.nextInt();
				if (choice == 1) {
					System.out.print("Title: ");
					scanner.nextLine();
					String title = scanner.nextLine();
					System.out.println("Category: ");
					String category = scanner.nextLine();
					System.out.println("Director: ");
					String director = scanner.nextLine();
					System.out.println("Length: ");
					int length = scanner.nextInt();
					System.out.println("Cost: ");
					float cost = scanner.nextFloat();
					anItem.addDVD(new DigitalVideoDisc(title, category, director, length, cost));
				}
				else if (choice == 2) {
					System.out.print("Enter the title of the DVD: ");
					scanner.nextLine();
					String tmpTitle = scanner.nextLine();
					DigitalVideoDisc tmpDVD = anItem.searchByTitle(tmpTitle);
					if (tmpDVD != null) anItem.removeDVD(tmpDVD);
					else System.out.println("Invalid title!");
				}
				else System.out.println("Unexpected value: " + choice);
				break;
			}
//			__________END UPDATE STORE__________
			
//			__________SEE CURRENT CART__________
			case 3:
			{
				do {
					anOrder.printCartGeneral();
					cartMenu();
					System.out.print("Type here: ");
					cartChoice = scanner.nextInt();
					switch (cartChoice) {
					case 0: break;
					case 1:
					{
						System.out.println("Filter by ID (1) or by title (2).");
						System.out.println("Type 1 or 2: ");
						int choice = scanner.nextInt();
						if (choice == 1) {
							System.out.print("Type ID here: ");
							int id = scanner.nextInt();
							anOrder.searchByID(id);
						}
						else if (choice == 2) {
							System.out.print("Type title here: ");
							scanner.nextLine();
							String title = scanner.nextLine();
							anOrder.searchByTitle(title);
						}
						else System.out.println("Unexpected value: " + choice);
						break;
					}
					case 2:
					{
						System.out.println("Sort by title (1) or by cost (2).");
						System.out.println("Type 1 or 2: ");
						int choice = scanner.nextInt();
						if (choice == 1) anOrder.sortByAlphabetAndDecreasingCost();
						else if (choice == 2) anOrder.sortByDecreasingCostAndAlphabet();
						else System.out.println("Unexpected value: " + choice);
						break;
					}
					case 3:
					{
						System.out.print("Enter the title of the DVD: ");
						scanner.nextLine();
						String tmpTitle = scanner.nextLine();
						anOrder.removeByName(tmpTitle);
						break;
					}
					case 4:
					{
						anOrder.emptyCart();
						System.out.println("An order is created.");
						break;
					}
					default:
						System.out.println("Unexpected value: " + cartChoice);
					}
				} while (cartChoice != 0);
				break;
			}
//			__________END SEE CURRENT CART__________
			default:
				System.out.println("Unexpected value: " + mainChoice);
			}
		} while (mainChoice != 0);
		
	}

}