package hust.soict.globalict.fx;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyController implements Initializable {

    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// TODO Auto-generated method stub
    }
    
    @FXML
    void showDateTime(ActionEvent event) {
    	Date nowDate = new Date();
    	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
    	String dateTimeString = df.format(nowDate);
    	myTextField.setText(dateTimeString);
    }

}
