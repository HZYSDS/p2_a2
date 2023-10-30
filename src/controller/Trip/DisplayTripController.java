package controller.Trip;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Itinery;
import model.Trip;

public class DisplayTripController extends Controller<Trip> {
    @FXML private Button VButton;

    @FXML private Button CButton;

    @FXML private ListView<Itinery> tripList;

    public void initialize() {
        tripList.setItems(model.getItinery());
    }

    @FXML private void handleVButton() {
        Itinery selectedItinery = tripList.getSelectionModel().getSelectedItem();
        if (selectedItinery == null) {
            showError("Please select an item from the list.");
            return;
        }

        String itemDescription = selectedItinery.toString();

        if (itemDescription.contains("in")) {
            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(model.getAgency(), "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations",
                        stage);

            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
            }
        } else if (itemDescription.contains("Flight")) {
            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(model.getAgency(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);

            } catch (Exception e) {
                showError("Error loading Explore Flights view.");
            }
        } else {
            showError("Unknown item type.");
        }

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
