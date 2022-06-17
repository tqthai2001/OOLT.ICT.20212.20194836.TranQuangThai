package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfDirector;
	private JTextField tfArtist;
	
	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add CD");
		setVisible(true);
		setSize(800, 600);
	}
	
	public AddCompactDiscToStoreScreen(JTextField tfTitle, JTextField tfCategory, JTextField tfCost, JButton btAdd,
			Store store, Cart cart, JTextField tfDirector, JTextField tfArtist) {
		super(tfTitle, tfCategory, tfCost, btAdd, store, cart);
		this.tfDirector = tfDirector;
		this.tfArtist = tfArtist;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add CD");
		setVisible(true);
		setSize(800, 600);
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("ADD CD");
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
				new CartScreen(store, AddCompactDiscToStoreScreen.this.cart);
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
				CompactDisc tmpCompactDisc = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), tfArtist.getText(), cost);
				try {
					store.addMedia(tmpCompactDisc);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				new StoreScreen(store, AddCompactDiscToStoreScreen.this.cart);
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
		center.add(new JLabel("Director:"));
		tfDirector = new JTextField("");
		center.add(tfDirector);
		center.add(new JLabel("Artist:"));
		tfArtist = new JTextField("");
		center.add(tfArtist);
		center.add(new JLabel("Cost:"));
		tfCost = new JTextField("");
		center.add(tfCost);

		return center;
	}
}
