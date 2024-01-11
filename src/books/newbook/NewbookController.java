package books.newbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pupil
 */
public class NewbookController implements Initializable {
    private File selectedFile;
    @FXML private TextField textField;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    public void selectedCover() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбор изображения");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Изображения","jpg", "png"));
        selectedFile = fileChooser.showOpenDialog(new Stage());
    }
    
}
