////
/*
Author: George Young
Date Modified: Jan. 4th 2017

*/
////



package george;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController
implements Initializable {
    private double stageX = 0.0;
    private double stageY = 0.0;
    private double mouseX = 0.0;
    private double mouseY = 0.0;
    private Timeline timeline = null;
    @FXML
    private Label labelTime;
    
    @SuppressWarnings("unchecked")
	public void initialize(URL url, ResourceBundle rb) {
        this.labelTime.setText(this.getCurrentTime());
        @SuppressWarnings("rawtypes")
		KeyFrame keyframe = new KeyFrame(Duration.millis((double)1000.0), (EventHandler)new EventHandler<ActionEvent>(){

            public void handle(ActionEvent e) {
                FXMLDocumentController.this.labelTime.setText(FXMLDocumentController.this.getCurrentTime());
            }
        }, new KeyValue[0]);
        this.timeline = new Timeline(new KeyFrame[]{keyframe});
        this.timeline.setCycleCount(-1);
        this.timeline.play();
    }

    @FXML
    private void handleMenuExit(ActionEvent event) {
        this.timeline.stop();
        Platform.exit();
    }

    public String getCurrentTime() {
        LocalTime time = LocalTime.now();
        String timeString = time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        return timeString;
    }

    @FXML
    private void handleMouseEntered(MouseEvent event) {
        Scene scene = ((Parent)event.getSource()).getScene();
        scene.setCursor(Cursor.MOVE);
    }

    @FXML
    private void handleMouseDragged(MouseEvent event) {
        Stage stage = (Stage)this.labelTime.getParent().getScene().getWindow();
        double deltaX = event.getScreenX() - this.mouseX;
        double deltaY = event.getScreenY() - this.mouseY;
        stage.setX(this.stageX + deltaX);
        stage.setY(this.stageY + deltaY);
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        Stage stage = (Stage)this.labelTime.getParent().getScene().getWindow();
        this.stageX = stage.getX();
        this.stageY = stage.getY();
        this.mouseX = event.getScreenX();
        this.mouseY = event.getScreenY();
    }

}

