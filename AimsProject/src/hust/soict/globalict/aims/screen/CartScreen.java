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

	public CartScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		CartScreen cartScreen = this;
		
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
					CartScreenController controller = new CartScreenController(store, cart, cartScreen);
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
		Store anItem = new Store();
		Cart anOrder = new Cart();
		new CartScreen(anItem, anOrder);
	}

}
