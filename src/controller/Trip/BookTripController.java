package controller.Trip;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Trip;
import model.Utils;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.InsufficientDestinationsException;
import model.Destination;

public class BookTripController extends Controller<Trip> {
    @FXML private Button AButton;

    @FXML private Button RFButton;
    
    @FXML private Button ACButton;
    
    @FXML private Button VButton;

    @FXML private Button CButton;

    @FXML private Label NLabel;

    public void initialize(){
        NLabel.setText("Hi "+model.getAgency().getLoggedInUser().getName()+",welcome to the Trip section");
        
    }

    @FXML private void handleAButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/trip_icon.png"));
                ViewLoader.showStage(model.getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Trip:add destination", stage);
                
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleRButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/trip_icon.png"));
                ViewLoader.showStage(model.getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Trip:remove destination", stage);
               
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleACButton(){
        try{
            model.addConnectingFlights();

        } catch(DuplicateItemException e){
            e.initCause(new Throwable("Duplicate Item Exception")) ;
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter a new destination"));
            model.getDestinations().getDestinations().clear();

        } catch(InsufficientDestinationsException e){
            e.initCause(new Throwable("Insufficient Destinations Exception")) ;
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter more than two destinations"));
        }
    }
    
    @FXML private void handleVButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/trip_icon.png"));
                ViewLoader.showStage(model, "/view/Trip/DisplayTripView.fxml", "Display Trip", stage);
              
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
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
