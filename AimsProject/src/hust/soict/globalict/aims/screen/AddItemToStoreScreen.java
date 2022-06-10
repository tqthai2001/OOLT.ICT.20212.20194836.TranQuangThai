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
				new CartScreen(cart);
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

}