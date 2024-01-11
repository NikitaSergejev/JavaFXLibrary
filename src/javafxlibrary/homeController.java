/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlibrary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author pupil
 */
public class homeController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Parent root;
    
    @FXML
    private Button button;
    
    @FXML
    private Stage stageNewWindow;
    
    @FXML
    private Scene sceneNewWindow;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.setId("myButton");
        button.getStyleClass().add("myButton");
    }    
    @FXML 
    public void openWindowAddBook() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/books/newbook/book.fxml"));
       Parent root = loader.load();
       
       stageNewWindow = new Stage();
       stageNewWindow.setTitle("New window");
       stageNewWindow.setScene(sceneNewWindow);
       stageNewWindow.showAndWait(); // отображение окна и ждём его закрытия
}
}
