package au.edu.uts.ap.javafx;

import javafx.stage.*;
import model.*;

public abstract class Controller<M> {

    protected M model;
    
    protected Stage stage;

    protected Administrators administrators;
    
    protected Agency agency;
}
