package controller.Destinations;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Destination;
import model.Destinations;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;

public class ModifyDestinationsController extends Controller<Destinations>{
    @FXML private Button AButton;

    @FXML private Button RButton;

    @FXML private Button CButton;

    @FXML private TextField NTF;

    @FXML private TextField CTF;

    public void initialize() {
        if(AButton != null){AButton.setDisable(true);}
        if(RButton != null){RButton.setDisable(true);}
        NTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());
        CTF.textProperty().addListener((observable, oldValue, newValue) -> toggleLoginButton());

}

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError();
            }
    }

    @FXML private void handleAButton(){
        String nmaeValue = NTF.getText();
        String countryValue = CTF.getText();
        try{
            model.addDestination(new Destination(nmaeValue, countryValue));
                try {
                    ((Stage) AButton.getScene().getWindow()).close();
                } catch (Exception e) {
                    showError();
                }
            } catch(DuplicateItemException e){
            e.initCause(new Throwable("DuplicateItemException"));
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter a new destination"));
        }



    
        NTF.clear();
        CTF.clear();
    }

    @FXML private void handleRButton(){
        String nmaeValue = NTF.getText();
        String countryValue = CTF.getText();
        try{
            model.removeDestination(new Destination(nmaeValue, countryValue));
                try {
                    ((Stage) AButton.getScene().getWindow()).close();
                } catch (Exception e) {
                    showError();
                }        
            } catch(ItemNotFoundException e){
            e.initCause(new Throwable("ItemNotFoundException"));
            ViewLoader.showErrorWindow(new ErrorModel(e,"Please enter a valid destination"));
        }



        NTF.clear();
        CTF.clear();
    } 

    private void showError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);

        alert.showAndWait();
    }

    private void toggleLoginButton() {
        if (!NTF.getText().trim().isEmpty() && !CTF.getText().trim().isEmpty() ) {
            if(AButton != null){AButton.setDisable(false);}
            if(RButton != null){RButton.setDisable(false);}
        } else {
            if(AButton != null){AButton.setDisable(true);}
            if(RButton != null){RButton.setDisable(true);}
        }
    }
}
