package controller.Flights;

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
        airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        takeoffCountryColumn.setCellValueFactory(new PropertyValueFactory<>("takeoffCountry"));
        landingCountryColumn.setCellValueFactory(new PropertyValueFactory<>("landingCountry"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        loadFlightData();
    }

    private void loadFlightData() {
        ObservableList<Flight> flightData = FXCollections.observableArrayList();

        flightData.add(new Flight("AirlineA", 1001, "CountryA", "CountryB", 150.0));
        flightData.add(new Flight("AirlineB", 1002, "CountryB", "CountryC", 200.0));

        flightsTable.setItems(flightData);
    }
    
}
