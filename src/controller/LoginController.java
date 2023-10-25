package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Administrators;
import model.Agency;


public class LoginController extends Controller<Administrators> {
    
    @FXML private TextField usernameTF;
    
    @FXML private TextField passwordTF;

    @FXML private Button loginButton;

    @FXML private Button exitButton;
       
    @FXML
    private void handleLoginButtonAction() {
        
            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/agency_icon.png"));
                ViewLoader.showStage(new Agency(), "/view/AgencyView.fxml", "Agency", stage);
                // 关闭当前的LoginView窗口
                ((Stage) loginButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Agency view.");
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
