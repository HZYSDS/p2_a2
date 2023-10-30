package controller.Destinations;

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
import model.Destination;
import model.Destinations;

public class DisplayDestinationsController extends Controller<Destinations> {
    @FXML private Button CButton;

    @FXML private TextField countryTF;

    @FXML private TableView<Destination> destinationsTable;
    
    @FXML private TableColumn<Destination, String> nameColumn;
    
    @FXML private TableColumn<Destination, String> countryColumn;

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError();
            }
    }

    private void showError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);

        alert.showAndWait();
    }
    
     public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        loadDestinationData();
        if (countryTF != null) {
            countryTF.textProperty().addListener((observable, oldValue, newValue) -> {
                filterDestinationsBasedOnCountry(newValue);
            });
        }
    }

    private void loadDestinationData() {
        
        destinationsTable.setItems(model.getDestinations());
    }

    private void filterDestinationsBasedOnCountry(String country) {
        if ( !country.isEmpty()  ) {
            ObservableList<Destination> filteredDestinations = model.getFilteredDestinations(country);
            destinationsTable.setItems(filteredDestinations);
        } else {
            loadDestinationData();  
        }
    }
}
