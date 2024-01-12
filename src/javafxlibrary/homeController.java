/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlibrary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import books.newbook.NewbookController;
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
        /*button.setId("myButton");
        button.getStyleClass().add("myButton");*/
        
    }    
    @FXML 
    public void openWindowAddBook(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/books/newbook/book.fxml"));
            Parent root = loader.load();

            NewbookController newbookController  = loader.getController();
            // Здесь вы можете передать данные в контроллер окна добавления книги, если это необходимо
            
            // Создание нового Stage
            Stage stage = new Stage();
            stage.setTitle("Add New Book");

            // Инициализация сцены
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Установка родительского окна
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());

            // Установка модальности (блокирование других окон)
            stage.initModality(Modality.WINDOW_MODAL);

            // Отображение нового окна
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, "Нет /books/newbook/book.fxml", ex);
        }
    }
}
