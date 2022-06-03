package hust.soict.globalict.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {

	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem smAddBook = new JMenuItem("Add Book");
		smUpdateStore.add(smAddBook);
		smAddBook.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new AddBookToStoreScreen(store, cart);
			}
		});
		
		JMenuItem smAddCD = new JMenuItem("Add CD");
		smUpdateStore.add(smAddCD);
		smAddCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new AddCompactDiscToStoreScreen(store, cart);
			}
		});
		
		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(smAddDVD);
		smAddDVD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new AddDigitalVideoDiscToStoreScreen(store, cart);
			}
		});
		
		menu.add(smUpdateStore);
		JMenuItem smViewStore = new JMenuItem("View store"); 
		menu.add(smViewStore);
		smViewStore.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new StoreScreen(store, cart);
			}
		});
		
		JMenuItem smViewCart = new JMenuItem("View cart");
		menu.add(smViewCart);
		smViewCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				seeCurrentCart(cart);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		title.setForeground(Color.LIGHT_GRAY);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 30));
		cart.setMaximumSize(new Dimension(100, 30));
		cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				seeCurrentCart(StoreScreen.this.cart);
			}
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < store.getQuantityItemsInStore(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	public class MediaStore extends JPanel {
		private Media media;
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton btAddToCart = new JButton("Add to cart");
			container.add(btAddToCart);
			btAddToCart.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					cart.addMedia(media);
				}
			});
			
			if (media instanceof Playable) {
				JButton btPlay = new JButton("Play");
				container.add(btPlay);
				btPlay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Dialog(media);
					}
				});
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	public class Dialog extends JDialog {
		private Media media;
		public Dialog(Media media) {
			this.media = media;
			Container cp = getContentPane();
			cp.setLayout(new GridLayout(2, 1));
			if (media instanceof CompactDisc) {
				if (((CompactDisc) media).getLength() <= 0) cp.add(new JLabel("CD cannot play!"));
				else {
					cp.add(new JLabel("Playing CD: " + media.getTitle()));
					cp.add(new JLabel("CD length: " + ((CompactDisc) media).getLength()));
				}
			}
			else if (media instanceof DigitalVideoDisc) {
				if (((DigitalVideoDisc) media).getLength() <= 0) cp.add(new JLabel("DVD cannot play!"));
				else {
					cp.add(new JLabel("Playing DVD: " + media.getTitle()));
					cp.add(new JLabel("DVD length: " + ((DigitalVideoDisc) media).getLength()));
				}
			}
			setTitle("Play");
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setSize(250, 100);
			setVisible(true);
		}
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Store");
		setSize(800, 600);
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
		System.out.println("0. Back to Store Screen");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5-6");
	}
	
	public void seeCurrentCart(Cart anOrder) {
		int cartChoice;
		do {
		cartMenu();
		Scanner scanner = new Scanner(System.in);
		anOrder.printCartGeneral();
		cartMenu();
		System.out.print("Type here: ");
		cartChoice = scanner.nextInt();
		switch (cartChoice) {
		case 0: new StoreScreen(store, anOrder); break;
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
			System.out.println("Sort by TitleCost (1) or by CostTitle (2) or by TitleCategory (3).");
			System.out.print("Type 1 or 2 or 3: ");
			int choice = scanner.nextInt();
			if (choice == 1) anOrder.sortByAlphabetAndDecreasingCost();
			else if (choice == 2) anOrder.sortByDecreasingCostAndAlphabet();
			else if (choice == 3) anOrder.sortByAlphabetTitleCategory();
			else System.out.println("Unexpected value: " + choice);
			break;
		}
		case 3:
		{
			System.out.print("Enter the ID of the Media: ");
			int tmpID = scanner.nextInt();
			anOrder.playByID(tmpID);
			break;
		}
		case 4:
		{
			System.out.print("Enter the ID of the Media: ");
			int tmpID = scanner.nextInt();
			anOrder.removeByID(tmpID);
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store anItem = new Store();
		Cart anOrder = new Cart();
//		---------------------------------------- INIT DATA ----------------------------------------
//		############################## DVD ##############################
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
//		**********************************************************
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Russo", 0, 90.91f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers",
				"Fiction", "Holland", 87, 93.96f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Cruise", 99, 293.65f);
		
//		############################## BOOK ##############################		
		Book book1 = new Book("Conan", "Manga", "Special drama for the live-action of Detective Conan", 24.95f);
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
		Track track3 = new Track("Friday", 0);
		Track track4 = new Track("Baby Love", 5);
		Track track5 = new Track("Baby Love", 5);

//		############################## CD ##############################
		CompactDisc cd1 = new CompactDisc("Workout Top Songs", "Power Music", "Spring", "V.A", 100.90f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		
		CompactDisc cd2 = new CompactDisc("World", "Pop", "Summer", "Alan Walker", 125.15f);
		cd2.addTrack(track4, track5); // add 2 tracks with same title and same length
		
		CompactDisc cd3 = new CompactDisc("Baby", "Rock", "Winter", "MTP", 78.98f);
		cd3.addTrack(track3, track3); // add track has already in list
		cd3.removeTrack(track3); // test CD length = 0
		cd3.removeTrack(track1); // remove track not in list
		
//		Add item to store
		anItem.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, book3, cd1, cd3);
//		---------------------------------------- INIT DATA ----------------------------------------
		new StoreScreen(anItem, anOrder);
	}

}
