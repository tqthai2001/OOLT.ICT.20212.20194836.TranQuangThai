package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class Aims {

	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("4. View store (Split Book - DVD)");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media’s details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. Play a Media in store");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Play a Media in cart");
		System.out.println("4. Remove Media from cart");
		System.out.println("5. Get a lucky item from cart");
		System.out.println("6. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void main(String[] args) {
//		MemoryDaemon memDaemon = new MemoryDaemon();
//		memDaemon.run();
		Thread thread = new Thread(new MemoryDaemon());
		thread.setDaemon(true);
		thread.start();
		
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		Store anItem = new Store();
		Scanner scanner = new Scanner(System.in);
		int mainChoice, storeChoice, cartChoice;
		
//		############################## DVD ##############################
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
//		**********************************************************
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Russo", 0, 90.91f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Holland", 87, 93.96f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Cruise", 99, 93.96f);
		
//		############################## BOOK ##############################		
		Book book1 = new Book("Conan", "Manga", "Special drama for the live-action of Detective Conan", 25.75f);
		book1.addAuthor("Gosho");
		book1.addAuthor("Howard");
		
		Book book2 = new Book("Doraemon", "Comic", "I can can the can, but the can cannot can me", 56.78f);
		book2.addAuthor("Fujio");
		
		Book book3 = new Book("Elsa", "Comic", "East or West, home is best", 12.34f);
		book3.addAuthor("Robert");
		book3.addAuthor("Camp");
		book3.addAuthor("Carter");
		
//		############################## TRACK ##############################
		Track track1 = new Track("Bang Bang", 3);
		Track track2 = new Track("Bed", 3);
		Track track3 = new Track("Friday", 2);
		Track track4 = new Track("Follow You", 5);
		Track track5 = new Track("Baby Love", 5);

//		############################## CD ##############################
		CompactDisc cd1 = new CompactDisc("Workout Top Songs", "Power Music", "Spring", "V.A", 100.90f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		
		CompactDisc cd2 = new CompactDisc("World", "Pop", "Summer", "Alan Walker", 125.15f);
		cd2.addTrack(track3, track4, track5);
		
		CompactDisc cd3 = new CompactDisc("Baby", "Rock", "Winter", "MTP", 78.98f);
		cd3.addTrack(track5, track5); // add track has already in list
		cd3.removeTrack(track5); // test CD length = 0
		cd3.removeTrack(track1); // remove track not in list
		
//		Add item to store
		anItem.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, book1, book2, book3, cd1, cd2, cd3);
		
		do {
			showMenu();
			System.out.print("Type here: ");
			mainChoice = scanner.nextInt();
			
			switch (mainChoice) {
			case 0: break;
			case 4:
			{
				anItem.viewStoreSpecific();
				break;
			}
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
						System.out.print("Enter the title of the Media: ");
						scanner.nextLine(); // clear buffer from keyboard
						String tmpTitle = scanner.nextLine();
						Media tmpMedia = anItem.searchByTitle(tmpTitle);
						if (tmpMedia == null) System.out.println("Invalid title!");
						else {
							tmpMedia.seeDetail();
							System.out.println("Do you want to add this Media to your cart?");
							System.out.print("Type Y/N: ");
							char c = scanner.next().charAt(0);
							if (c == 'Y' || c == 'y') {
								anOrder.addMedia(tmpMedia);
							}
							else System.out.println("Thank you.");
						}
						break;
					}
					case 2:
					{
						System.out.print("Enter the title of the Media: ");
						scanner.nextLine();
						String tmpTitle = scanner.nextLine();
						Media tmpMedia = anItem.searchByTitle(tmpTitle);
						if (tmpMedia == null) System.out.println("Invalid title!");
						else {
							anOrder.addMedia(tmpMedia);
							System.out.println("The number of Media in the cart: " + anOrder.getQtyOrdered());
						}
						break;
					}
					case 3:
					{
						System.out.println("Enter the ID of the Media: ");
						int tmpID = scanner.nextInt();
						anItem.playByID(tmpID);
						break;
					}
//					__________SEE CURRENT CART__________
					case 4:
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
								System.out.print("Type 1 or 2: ");
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
								System.out.print("Type 1 or 2: ");
								int choice = scanner.nextInt();
								if (choice == 1) anOrder.sortByAlphabetAndDecreasingCost();
								else if (choice == 2) anOrder.sortByDecreasingCostAndAlphabet();
								else System.out.println("Unexpected value: " + choice);
								break;
							}
							case 3:
							{
								System.out.println("Enter the ID of the Media: ");
								int tmpID = scanner.nextInt();
								anOrder.playByID(tmpID);
								break;
							}
							case 4:
							{
								System.out.print("Enter the title of the Media: ");
								scanner.nextLine();
								String tmpTitle = scanner.nextLine();
								anOrder.removeByName(tmpTitle);
								break;
							}
							case 5:
							{
								anOrder.updateLuckyItemInCart();
								break;
							}
							case 6:
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
//					__________END SEE CURRENT CART__________
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
				System.out.println("Do you want to ADD (1) or REMOVE (2) a Media?");
				System.out.print("Type 1 or 2: ");
				int choice = scanner.nextInt();
				if (choice == 1) {
					System.out.println("Do you want to ADD DVD (1) or ADD BOOK (2) or ADD CD (3)?");
					System.out.print("Type 1 or 2 or 3: ");
					int select = scanner.nextInt();
					if (select == 1) {
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
						anItem.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
					}
					else if (select == 2) {
						System.out.print("Title: ");
						scanner.nextLine();
						String title = scanner.nextLine();
						System.out.println("Category: ");
						String category = scanner.nextLine();
						System.out.println("Author: ");
						String author = scanner.nextLine();
						System.out.println("Content: ");
						String content = scanner.nextLine();
						System.out.println("Cost: ");
						float cost = scanner.nextFloat();
						Book tmpBook = new Book(title, category, content, cost);
						tmpBook.addAuthor(author);
						anItem.addMedia(tmpBook);
					}
					else if (select == 3) {
						System.out.print("Title: ");
						scanner.nextLine();
						String title = scanner.nextLine();
						System.out.println("Category: ");
						String category = scanner.nextLine();
						System.out.println("Director: ");
						String director = scanner.nextLine();
						System.out.println("Artist: ");
						String artist = scanner.nextLine();
						System.out.println("Cost: ");
						float cost = scanner.nextFloat();
						System.out.println("Number of tracks: ");
						int num = scanner.nextInt();
						CompactDisc tmpCompactDisc = new CompactDisc(title, category, director, artist, cost);
						for (int i = 0; i < num; i++) {
							System.out.println("Track title: ");
							scanner.nextLine();
							String trackTitle = scanner.nextLine();
							System.out.println("Track length: ");
							int trackLength = scanner.nextInt();
							tmpCompactDisc.addTrack(new Track(trackTitle, trackLength));
						}
						anItem.addMedia(tmpCompactDisc);
					}
					else System.out.println("Unexpected value: " + choice);
				}
				else if (choice == 2) {
					System.out.print("Enter the title of the Media: ");
					scanner.nextLine();
					String tmpTitle = scanner.nextLine();
					Media tmpMedia = anItem.searchByTitle(tmpTitle);
					if (tmpMedia != null) anItem.removeMedia(tmpMedia);
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
						System.out.print("Type 1 or 2: ");
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
						System.out.print("Type 1 or 2: ");
						int choice = scanner.nextInt();
						if (choice == 1) anOrder.sortByAlphabetAndDecreasingCost();
						else if (choice == 2) anOrder.sortByDecreasingCostAndAlphabet();
						else System.out.println("Unexpected value: " + choice);
						break;
					}
					case 3:
					{
						System.out.println("Enter the ID of the Media: ");
						int tmpID = scanner.nextInt();
						anOrder.playByID(tmpID);
						break;
					}
					case 4:
					{
						System.out.print("Enter the title of the Media: ");
						scanner.nextLine();
						String tmpTitle = scanner.nextLine();
						anOrder.removeByName(tmpTitle);
						break;
					}
					case 5:
					{
						anOrder.updateLuckyItemInCart();
						break;
					}
					case 6:
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