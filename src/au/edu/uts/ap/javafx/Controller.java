package au.edu.uts.ap.javafx;

import javafx.stage.*;
import model.*;

public abstract class Controller<M> {
    protected M model;

    public Controller (){
    }

    public Controller (M modal){
        this.model = modal;
        stage = new Stage();
    }
    
    public void setModel(M model) {
        this.model = model;
    }
    
    public M getModel() {
        return model;
    }
    
    protected Stage stage; 
    
}
