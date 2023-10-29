package controller.Destinations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;
import model.Destination;

public class DisplayDestinationsController extends Controller<Agency> {
    @FXML private Button CButton;

    @FXML private TextField countryTF;

    @FXML private TableView<Destination> destinationsTable;
    
    @FXML private TableColumn<Destination, String> nameColumn;
    
    @FXML private TableColumn<Destination, String> countryColumn;

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
    
     public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        loadDestinationData();
    }

    private void loadDestinationData() {
        ObservableList<Destination> destinationData = FXCollections.observableArrayList();

        destinationData.add(new Destination("a","b"));
        destinationData.add(new Destination("c","d"));
        
        destinationsTable.setItems(destinationData);
    }
}
