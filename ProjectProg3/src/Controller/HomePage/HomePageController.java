/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.HomePage;


import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class HomePageController implements Initializable {
    
    @FXML
    private Button buttonCancel;
    @FXML
    private Label labelLogin;
    @FXML
    private Button buttonLoginAdmin;
    @FXML
    private Button buttonLoginUser;
    @FXML
    private ImageView imageLogo;
    @FXML
    private Label labelChooseLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void buttonCancelAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void buttonAdminAction(ActionEvent event) throws IOException {
        ViewManger.getAmindLogInPage().show();
    }

    @FXML
    private void buttonUserAction(ActionEvent event) throws IOException {
        ViewManger.getPatientLoginpage().show();
        
    }


    
}
