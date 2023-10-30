package controller.Trip;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

import au.edu.uts.ap.javafx.*;
import model.Agency;
import model.Destination;
import model.Destinations;
import model.Flight;
import model.Flights;
import model.Itinery;
import model.Trip;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;

public class DisplayTripController extends Controller<Trip> {
    @FXML private Button VButton;

    @FXML private Button CButton;

    @FXML private ListView<Itinery> tripList;

    public void initialize() {
        tripList.setItems(model.getItinery());
        tripList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
private void handleVButton()  {
    ObservableList<Itinery> selectedItems = tripList.getSelectionModel().getSelectedItems();
    int i = 0,j=0;
    for (Itinery item : selectedItems) {
        if (item instanceof Destination) {
            i++;
        }
    }
    for (Itinery item : selectedItems) {
        if (item instanceof Flight) {
            j++;
        }
    }

    try{
        if(i!=0 && j!=0){
            throw new DuplicateItemException();
        }
    }catch(DuplicateItemException e){
        e.initCause(new Throwable("Duplicate Item Exception"));
        ViewLoader.showErrorWindow(new ErrorModel(e,"Please select the same items"));
    }
    
    if (j==0) {
        try {
            Destinations selectDestinations = new Destinations(selectedItems);            
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(selectDestinations, "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", stage);
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }
    }
    
    if (i==0) {
                try {
                    Flights selectFlights = new Flights(selectedItems);
                    Stage stage = new Stage();
                    stage.setX(ViewLoader.X + 601);
                    stage.setY(ViewLoader.Y);
                    stage.getIcons().add(new Image("/image/flights_icon.png"));
                    ViewLoader.showStage(selectFlights, "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);
                } catch (Exception e) {
                    showError("Error loading Explore Flights view.");
                }    }
    }

    @FXML
    private void handleCButton() {
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
