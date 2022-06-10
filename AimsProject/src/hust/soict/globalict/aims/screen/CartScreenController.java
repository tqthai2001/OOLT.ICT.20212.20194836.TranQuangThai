package hust.soict.globalict.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Store store;
	private Cart cart;
	private CartScreen cartScreen;

	@FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnGetLuckyItem;
    @FXML
    private TableColumn<Media, Integer> colMediaID;
	@FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label lbTotal;
    @FXML
    private RadioButton radioBtnFilterID;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
	
    public CartScreenController(Store store, Cart cart, CartScreen cartScreen) {
		super();
		this.store = store;
		this.cart = cart;
		this.cartScreen = cartScreen;
	}
    
    @FXML
    private void initialize() {
    	colMediaID.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			// TODO Auto-generated method stub
    			if (newValue != null) {
    				updateButtonBar(newValue);
    			}
    		}
		});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			// TODO Auto-generated method stub
    			showFilteredMedia(newValue);
    		}
		});
    	
    	lbTotal.setText(cart.totalCost() + " $");
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
			btnPlay.setVisible(false);
		}
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	new Dialog(media);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	lbTotal.setText(cart.totalCost() + " $");
    }
    
    @FXML
    void btnGetLuckyItemPressed(ActionEvent event) {
		cart.updateLuckyItemInCart();
		lbTotal.setText(cart.totalCost() + " $");
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Thank you!");
    	cart.emptyCart();
    	lbTotal.setText(cart.totalCost() + " $");
    }
    
    @FXML
    void menuItemViewStorePressed(ActionEvent event) {
    	cartScreen.setVisible(false);
    	new StoreScreen(store, cart);
    }
    
    @FXML
    void menuItemAddBookPressed(ActionEvent event) {
    	cartScreen.setVisible(false);
    	new AddBookToStoreScreen(store, cart);
    }

    @FXML
    void menuItemAddCDPressed(ActionEvent event) {
    	cartScreen.setVisible(false);
    	new AddCompactDiscToStoreScreen(store, cart);
    }

    @FXML
    void menuItemAddDVDPressed(ActionEvent event) {
    	cartScreen.setVisible(false);
    	new AddDigitalVideoDiscToStoreScreen(store, cart);
    }
    
    @FXML
    void radioBtnSortCostPressed(ActionEvent event) {
    	cart.sortByDecreasingCostAndAlphabet();
    }

    @FXML
    void radioBtnSortTitlePressed(ActionEvent event) {
    	cart.sortByAlphabetAndDecreasingCost();
    }
    
    void showFilteredMedia(String newValue) {
//    	Wrap the ObservableList in a FilteredList (initially display all data)
    	FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), media -> true);
//    	Set the filter Predicate whenever the filter changes
    	if (radioBtnFilterTitle.isSelected()) {
    		filteredList.setPredicate(media -> {
    			// If filter text is empty, display all persons
    			if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
    			if (media.getTitle().toLowerCase().indexOf(newValue.toLowerCase()) != -1) {
    				return true; // Filter matches
    			}
    			return false;
    		});
    	}
    	else if (radioBtnFilterID.isSelected()) {
    		filteredList.setPredicate(media -> {
    			// If filter text is empty, display all persons
    			if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
    			if (media.getId() == Integer.parseInt(newValue)) {
    				return true;
    			}
    			return false;
    		});
		}
//    	Add filtered data to the table
    	tblMedia.setItems(filteredList);
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

}
