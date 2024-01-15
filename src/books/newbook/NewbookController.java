package books.newbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Book;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author pupil
 */
public class NewbookController implements Initializable {
    private EntityManager em;
    private File selectedFile;
    @FXML private TextField textFieldTitle;
    @FXML private Button btnSelectCover;

    public NewbookController() {
    }
    
    
    
    @FXML
    public void selectedCover() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбор изображения");
        
        selectedFile = fileChooser.showOpenDialog(new Stage());
        /*FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбор обложки для книги");
        selectedFile = fileChooser.showOpenDialog(new Stage());
        btnSelectCover.setText("Выбран файл "+selectedFile.getName());
        btnSelectCover.disableProperty().set(true);*/
    }
    @FXML
    public void addNewBook(){
        Book book = new Book();
        book.setTitle(textFieldTitle.getText());
        try(FileInputStream fis = new FileInputStream(selectedFile)){
            byte[] fileContent = new byte[(int)selectedFile.length()];
            fis.read(fileContent);
            book.setCover(fileContent);
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }   
}
