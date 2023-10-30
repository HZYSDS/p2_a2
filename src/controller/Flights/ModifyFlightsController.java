package controller.Flights;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;
import model.Flight;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;

public class ModifyFlightsController extends Controller<Agency> {
    @FXML private Button AButton;

    @FXML private Button RButton;

    @FXML private Button CButton;

    @FXML private TextField ATF;

    @FXML private TextField FTF;

    @FXML private TextField TTF;

    @FXML private TextField LTF;

    @FXML private TextField CTF;

        public void initialize() {
            if(AButton != null){AButton.setDisable(true);}
            if(RButton != null){RButton.setDisable(true);}
            if(AButton != null) ATF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
            if(AButton != null) FTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
            TTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
            LTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
            if(AButton != null) CTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
    }

    @FXML private void handleCButton(){
        try {
                ((Stage) AButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleAButton(){
        
        String airlineValue = ATF.getText();
        String flightValueStr = FTF.getText();
        String takeoffValue = TTF.getText();
        String landingValue = LTF.getText();
        String costValueStr = CTF.getText();

        int flightValue = 0;
        double costValue = 0.0;

        try {
            flightValue = Integer.parseInt(flightValueStr);
        } catch(NumberFormatException e) {
            showError("Invalid flight number entered.");
            return; 
        }

        try {
            costValue = Double.parseDouble(costValueStr);
        } catch(NumberFormatException e) {
            showError("Invalid cost entered.");
            return;  
        }
        try{
            model.getFlights().addFlight(new Flight(airlineValue, flightValue, takeoffValue, landingValue, costValue));

        } catch(DuplicateItemException e){
            e.initCause(new Throwable("Duplicate Item Exception"));
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter a new flight"));
        }

        ATF.clear();
        FTF.clear();
        TTF.clear();
        LTF.clear();
        CTF.clear();
    }
    
    @FXML private void handleRButton(){
        String takeoffValue = TTF.getText();
        String landingValue = LTF.getText();
        try{
            model.getFlights().removeFlight(model.getFlights().getFlight(takeoffValue, landingValue));
        } catch(ItemNotFoundException e){
            e.initCause(new Throwable("Item Not Found Exception"));
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter a valid Flight"));
        } 
        TTF.clear();
        LTF.clear();
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    

    }

    private void toggleLoginButton() {
        if (!TTF.getText().trim().isEmpty() && !LTF.getText().trim().isEmpty()) {
            if(AButton != null){
                if(!ATF.getText().trim().isEmpty() && !FTF.getText().trim().isEmpty() && !CTF.getText().trim().isEmpty())
                AButton.setDisable(false);
                else
                AButton.setDisable(true);
            }
            if(RButton != null){RButton.setDisable(false);}
        } else {
            if(AButton != null){AButton.setDisable(true);}  
            if(RButton != null){RButton.setDisable(true);}
        }
    }

}
