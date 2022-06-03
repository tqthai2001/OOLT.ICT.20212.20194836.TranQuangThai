package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {

	protected JTextField tfTitle;
	protected JTextField tfCategory;
	protected JTextField tfCost;
	protected JButton btAdd;
	protected Store store;
	protected Cart cart;
	
	public AddItemToStoreScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
	}
	
	public AddItemToStoreScreen(JTextField tfTitle, JTextField tfCategory, JTextField tfCost, JButton btAdd,
			Store store, Cart cart) {
		super();
		this.tfTitle = tfTitle;
		this.tfCategory = tfCategory;
		this.tfCost = tfCost;
		this.btAdd = btAdd;
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
	}

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
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		return center;
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
		cartMenu();
		Scanner scanner = new Scanner(System.in);
		int cartChoice;
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
	}

}
