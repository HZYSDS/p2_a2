package controller.Flights;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;

public class ExploreFlightsController extends Controller<Agency>{
    
    @FXML private Button VButton;

    @FXML private Button VFButton;
    
    @FXML private Button AButton;
    
    @FXML private Button RButton;

    @FXML private Button CButton;

    @FXML private Label NLabel;

    public void initialize(){
        NLabel.setText("Hi "+model.getLoggedInUser().getName()+",welcome to the Flights section");
        
    }

    @FXML private void handleVButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model.getFlights(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);
                
            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleVFButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model.getFlights(), "/view/Flights/DisplayFilteredFlightsView.fxml", "Display Flights Filtered", stage);
               
            } catch (Exception e) {
                showError();
            }

    }

    @FXML private void handleAButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model, "/view/Flights/AddFlightView.fxml", "Add Flight", stage);
                
            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleRButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model, "/view/Flights/RemoveFlightView.fxml", "Remove Flight", stage);
              
            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError();
            }
    }

    private void showError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);

        alert.showAndWait();
    

    }
}
