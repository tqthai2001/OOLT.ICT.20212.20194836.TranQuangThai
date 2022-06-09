package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	private int isPen = -1;
	@FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup identical;
    @FXML
    private RadioButton rbEraser;
    @FXML
    private RadioButton rbPen;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (isPen == 1) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    	else if (isPen == 0) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 20, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
		}
    }
    
    @FXML
    void eraserButtonPressed(ActionEvent event) {
    	isPen = 0;
    }

    @FXML
    void penButtonPressed(ActionEvent event) {
    	isPen = 1;
    }

}