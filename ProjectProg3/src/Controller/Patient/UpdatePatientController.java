/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Patient;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class UpdatePatientController implements Initializable {

    @FXML
    private Label labelLastName;

    @FXML
    private Label labelTitelUpdatePatient;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelFirstName;

    @FXML
    private Label labelRole;

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldUserName;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label labelName;

    @FXML
    private Label labelAge;

    @FXML
    private ToggleGroup ToggleGroupRole;

    @FXML
    private Button buttonUpdate;

    @FXML
    private RadioButton rolePatient;

    @FXML
    private RadioButton roleAdmin;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private RadioButton genderMale;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelGender;

    @FXML
    private Button buttonCancel;

    @FXML
    private Label labelEmail;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private ToggleGroup ToggleGroupGender;

    @FXML
    private Label labelUserName;

    @FXML
    private RadioButton genderFemal;

    @FXML
    void buttonUpdaterAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().show();
    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
@FXML
    void buttonCancelAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().show();
    }
}
