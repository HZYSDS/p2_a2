package controller.Destinations;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;

public class ExploreDestinationsController extends Controller<Agency>{
    @FXML private Button VButton;

    @FXML private Button VFButton;
    
    @FXML private Button AButton;
    
    @FXML private Button RButton;

    @FXML private Button CButton;

    @FXML private Label NLabel;

    public void initialize(){
        NLabel.setText("Hi "+model.getLoggedInUser().getName()+",welcome to the Destinations section");
        
    }

    @FXML private void handleVButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model, "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", stage);
                
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }
    }

    @FXML private void handleVFButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model, "/view/Destinations/DisplayFilteredDestinationsView.fxml", "Display Destinations Filtered", stage);
               
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }

    }

    @FXML private void handleAButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model.getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Add Destination", stage);
                
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }
    }

    @FXML private void handleRButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model.getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Remove Destination", stage);
              
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");  
            }
    }

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    

    }
}
