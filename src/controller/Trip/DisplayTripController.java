package controller.Trip;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import model.Agency;
import model.Itinery;
import model.Trip;

public class DisplayTripController extends Controller<Trip> {
    @FXML private Button VButton;

    @FXML private Button CButton;

    @FXML private ListView<Itinery> tripList;

    public void initialize() {
        tripList.setItems(model.getItinery());
        tripList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
        // tripList.setOnMousePressed(event -> {
        //     // 计算点击位置对应的项的索引
        //     int clickedIndex = tripList.getSelectionModel().getSelectedIndex();
            
        //     if(clickedIndex != -1) {
        //         // 检查此项目是否在此之前已经被选中
        //         if(tripList.getSelectionModel().getSelectedIndices().contains(clickedIndex)) {
        //             // 如果已经选中，则取消选中
        //             tripList.getSelectionModel().clearSelection(clickedIndex);
        //         } else {
        //             // 如果未选中，则选中该项目
        //             tripList.getSelectionModel().select(clickedIndex);
        //         }
        //         event.consume(); // 阻止事件传播
        //     }
        // });
    }
    
    
    

    @FXML
    private void handleVButton() {
        ObservableList<Itinery> selectedItems = tripList.getSelectionModel().getSelectedItems();
        for (Itinery selectedItem : selectedItems) {
            String itemDescription = selectedItem.toString();

            if (itemDescription.contains("in")) {
                try {
                    Stage stage = new Stage();
                    stage.setX(ViewLoader.X + 601);
                    stage.setY(ViewLoader.Y);
                    stage.getIcons().add(new Image("/image/destinations_icon.png"));
                    ViewLoader.showStage(model.getDestinations(), "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", stage);
                } catch (Exception e) {
                    showError("Error loading Explore Destinations view.");
                }
                
            } else if (itemDescription.contains("Flight")) {
                try {
                    Stage stage = new Stage();
                    stage.setX(ViewLoader.X + 601);
                    stage.setY(ViewLoader.Y);
                    stage.getIcons().add(new Image("/image/flights_icon.png"));
                    ViewLoader.showStage(model.getFlights(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);
                } catch (Exception e) {
                    showError("Error loading Explore Flights view.");
                }
            } else {
                showError("Unknown item type.");
            }
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
