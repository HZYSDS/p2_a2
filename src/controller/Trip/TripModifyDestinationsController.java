package controller.Trip;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;
import model.Destination;
import model.Trip;
import model.Utils;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ItemNotFoundException;

public class TripModifyDestinationsController extends Controller<Trip>{
    @FXML private Button AButton;

    @FXML private Button RButton;

    @FXML private Button CButton;

    @FXML private TextField NTF;

    @FXML private TextField CTF;

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleAButton(){
        String nmaeValue = NTF.getText();
        String countryValue = CTF.getText();
        try{
            model.getDestinations().addDestination(model.getAgency().getDestinations().destination(nmaeValue, countryValue));
        } catch(DuplicateItemException e){
            showError("dadda");
        } catch(ItemNotFoundException e){
            showError("dadadda");
        }
        // model.getFlights().getFlights().clear();
        // for(Destination d: model.getDestinations().getDestinations()){
        //     Utils.addFlightsForDestination(d, model);
        // }
        NTF.clear();
        CTF.clear();
    }

    @FXML private void handleRButton(){
        String nmaeValue = NTF.getText();
        String countryValue = CTF.getText();
        try{
            model.getDestinations().removeDestination(model.getAgency().getDestinations().destination(nmaeValue, countryValue));
        } catch(ItemNotFoundException e){
            showError("sdadda");
        } 
        // model.getFlights().getFlights().clear();
        // for(Destination d: model.getDestinations().getDestinations()){
        //     Utils.addFlightsForDestination(d, model);
        // }
        NTF.clear();
        CTF.clear();
    } 

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
