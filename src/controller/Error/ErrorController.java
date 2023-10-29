package controller.Error;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Exceptions.ErrorModel;
import au.edu.uts.ap.javafx.Controller;

public class ErrorController extends Controller<ErrorModel> {

    public ErrorController(ErrorModel errormodel) {
        super(errormodel);
    }
    
    private final StringProperty atext = new SimpleStringProperty(model.getException().getMessage());
    
    private final StringProperty btext = new SimpleStringProperty(model.getMessage());

    @FXML private Label aLabel;
    
    @FXML private Label bLabel;

    @FXML private Button CButton;

    public void initialize() {
        aLabel.textProperty().bind(atext);
        bLabel.textProperty().bind(btext);
    }

}
