/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class LoginAdminController implements Initializable {

    @FXML
    private Label labelLoginAdmin;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonCancel;
    @FXML
    private Label labelTitel;
    @FXML
    private Label labelUserName;
    @FXML
    private Label labelPassword;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ImageView adminImage;
    @FXML
    private ImageView imageLogo;

    private final String adminUsername = "Admin";
    private final String adminPassword = "12345";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonLoginAction(ActionEvent event) throws IOException {
        String username = this.textFieldUserName.getText();
        String password = this.passwordField.getText();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            ViewManger.getAdminDashboard().getAdminDashboardPatients();
            ViewManger.getAdminDashboard().show();
//            this.passwordField.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("login alert");
            alert.setContentText("Incorrect Username Or Password!\nPlease try again..");
            alert.showAndWait();
        }

    }

    @FXML
    private void buttonCancelAction(ActionEvent event) throws IOException {
        ViewManger.getAmindLogInPage().close();
    }

}
