package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfAuthors;
	private JTextField tfContent;
	
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Book");
		setVisible(true);
		setSize(800, 600);
	}
	
	public AddBookToStoreScreen(JTextField tfTitle, JTextField tfCategory, JTextField tfCost, JButton btAdd,
			Store store, Cart cart, JTextField tfAuthors, JTextField tfContent) {
		super(tfTitle, tfCategory, tfCost, btAdd, store, cart);
		this.tfAuthors = tfAuthors;
		this.tfContent = tfContent;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Book");
		setVisible(true);
		setSize(800, 600);
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("ADD BOOK");
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
				new CartScreen(store, AddBookToStoreScreen.this.cart);
			}
		});
		
		btAdd = new JButton("Add");
		btAdd.setPreferredSize(new Dimension(60, 30));
		btAdd.setMaximumSize(new Dimension(60, 30));
		btAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float cost = Float.parseFloat(tfCost.getText());
				Book tmpBook = new Book(tfTitle.getText(), tfCategory.getText(), tfContent.getText(), cost);
				tmpBook.addAuthor(tfAuthors.getText());
				try {
					store.addMedia(tmpBook);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				new StoreScreen(store, AddBookToStoreScreen.this.cart);
			}
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btAdd);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 1));
		
		center.add(new JLabel("Title:"));
		tfTitle = new JTextField("");
		center.add(tfTitle);
		center.add(new JLabel("Category:"));
		tfCategory = new JTextField("");
		center.add(tfCategory);
		center.add(new JLabel("Content:"));
		tfContent = new JTextField("");
		center.add(tfContent);
		center.add(new JLabel("Authors:"));
		tfAuthors = new JTextField("");
		center.add(tfAuthors);
		center.add(new JLabel("Cost:"));
		tfCost = new JTextField("");
		center.add(tfCost);

		return center;
	}
}
