package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class AgencyController extends Controller<Agency>{
    
    @FXML private Button FButton;

    @FXML private Button DButton;
    
    @FXML private Button TButton;
    
    @FXML private Button EButton;

    @FXML private Label NLabel;

    public void initialize(){
        NLabel.setText("Hi "+model.getLoggedInUser().getName()+",welcome to the Prog2 Travel Agency");
        // for(Destination d: model.getDestinations().getDestinations()){
        //     Utils.addFlightsForDestination(d, model);
        // }
    }

    @FXML private void handleFButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model, "/view/Flights/ExploreFlightsView.fxml", "Explore Flights", stage);
                
                model.getFlights().getFlights().clear();
                for(Destination d: model.getDestinations().getDestinations()){
                    Utils.addFlightsForDestination(d, model);
                }

            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleDButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model, "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", stage);

            } catch (Exception e) {
                showError();
            }

    }

    @FXML private void handleTButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/Trip_icon.png"));
                ViewLoader.showStage(new Trip(model), "/view/Trip/BookTripView.fxml", "Display Trip", stage);
                model.getFlights().getFlights().clear();
                for(Destination d: model.getDestinations().getDestinations()){
                    Utils.addFlightsForDestination(d, model);
                }
            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleEButton(){
        try {
                ((Stage) FButton.getScene().getWindow()).close();
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
