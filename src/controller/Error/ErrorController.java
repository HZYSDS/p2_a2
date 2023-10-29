package controller.Error;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Exceptions.ErrorModel;
import au.edu.uts.ap.javafx.Controller;

public class ErrorController extends Controller<ErrorModel> {

    private final StringProperty atext = new SimpleStringProperty();
    private final StringProperty btext = new SimpleStringProperty();
 
    public void initialize() {
        if (model != null) {
            atext.set(model.getMessage());
            btext.set(model.getException().getCause().getMessage());
            aLabel.textProperty().bind(atext);
            bLabel.textProperty().bind(btext);
        }
    }

    @FXML private Label aLabel;
    
    @FXML private Label bLabel;

    @FXML private Button CButton;

    @FXML private void handleCButton(){
        try {
                ((Stage) CButton.getScene().getWindow()).close();
            } catch (Exception e) {
                showError("Error loading Explore Destinations view.");
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
