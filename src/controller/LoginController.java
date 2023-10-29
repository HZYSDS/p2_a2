package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Exceptions.InvalidCredentialsException;


public class LoginController extends Controller<Agency> {
    
    @FXML private TextField usernameTF;
    
    @FXML private TextField passwordTF;

    @FXML private Button loginButton;

    @FXML private Button exitButton;
       
    @FXML
    private void handleLoginButtonAction() {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        
        if (model != null && model.getAdministrators() != null ) {
        
        try {
            if (model.getAdministrators().hasAdministrator(username, password))  {
                model.setLoggedInUser(model.getAdministrators().getAdministrator(username, password));
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/agency_icon.png"));
                ViewLoader.showStage(model, "/view/AgencyView.fxml", "Agency", stage);
                ((Stage) loginButton.getScene().getWindow()).close();
            } 
        } catch (InvalidCredentialsException e) {
                ViewLoader.showErrorWindow(new ErrorModel(e, e.getMessage()));
                usernameTF.clear();
                passwordTF.clear();
        } catch (IOException ex) {
            Logger.getLogger(AgencyController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
}
    @FXML
    private void handleExitButtonAction() {
        try {
            ((Stage) exitButton.getScene().getWindow()).close();
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
