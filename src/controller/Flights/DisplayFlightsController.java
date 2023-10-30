package controller.Flights;

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
import model.Flight;
import model.Flights;

public class DisplayFlightsController extends Controller<Flights> {
    @FXML private Button CButton;

    @FXML private TextField countryTF;
    
    @FXML private TableView<Flight> flightsTable;
    
    @FXML private TableColumn<Flight, String> airlineColumn;
    
    @FXML private TableColumn<Flight, Integer> flightNumberColumn;
    
    @FXML private TableColumn<Flight, String> takeoffCountryColumn;
    
    @FXML private TableColumn<Flight, String> landingCountryColumn;
    
    @FXML private TableColumn<Flight, Double> costColumn;

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
        airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
        takeoffCountryColumn.setCellValueFactory(new PropertyValueFactory<>("takeoff"));
        landingCountryColumn.setCellValueFactory(new PropertyValueFactory<>("landing"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        loadFlightData();
        if (countryTF != null) {
            countryTF.textProperty().addListener((observable, oldValue, newValue) -> {
                filterFlightsBasedOnCountry(newValue);
            });
        }
        
    }

    private void loadFlightData() {

        flightsTable.setItems(model.getFlights());
    }
    
    private void filterFlightsBasedOnCountry(String country) {
        if ( !country.isEmpty()  ) {
            ObservableList<Flight> filteredFlights = model.getFilteredFlights(country);
            flightsTable.setItems(filteredFlights);
        } else {
            loadFlightData();  
        }
    }
    
}
