package hust.soict.globalict.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	
	private Store store;
	private Cart cart;

	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setSize(1024, 768);
		this.setVisible(true);
		
		Platform.runLater(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
					CartScreenController controller = new CartScreenController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
//		---------------------------------------- INIT DATA ----------------------------------------
//		############################## DVD ##############################
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 14.95f);
		
		anOrder.addMedia(dvd2, dvd1);
		new CartScreen(anOrder);
	}

}
