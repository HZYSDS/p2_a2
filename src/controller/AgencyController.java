package controller;

import au.edu.uts.ap.javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class AgencyController extends Controller<Agency>{
    
    @FXML private Button FButton;

    @FXML private Button DButton;
    
    @FXML private Button TButton;
    
    @FXML private Button EButton;

    @FXML private void handleFButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(new Agency(), "/view/Flights/ExploreFlightsView.fxml", "Explore Flights", stage);
                // 关闭当前的LoginView窗口
                ((Stage) FButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleDButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(new Agency(), "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", stage);
                // 关闭当前的LoginView窗口
                ((Stage) FButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }

    }

    @FXML private void handleTButton(){
        try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/Trip_icon.png"));
                ViewLoader.showStage(new Agency(), "/view/Trip/BookTripView.fxml", "Display Trip", stage);
                // 关闭当前的LoginView窗口
                ((Stage) FButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
    }

    @FXML private void handleEButton(){
        try {

                ((Stage) FButton.getScene().getWindow()).close();
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
