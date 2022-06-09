package hust.soict.globalict.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	private Cart cart;

	@FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
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
    private RadioButton rbtnByID;
    @FXML
    private RadioButton rbtnByTitle;
    @FXML
    private TextField tfTextFilter;
	
    public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
    
    @FXML
    private void initialize() {
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
