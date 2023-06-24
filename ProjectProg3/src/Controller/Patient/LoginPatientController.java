/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Patient;

import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LoginPatientController implements Initializable {

    @FXML
    private Label labelLoginPatient;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonCancel;
    @FXML
    private ImageView imageLogo;
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
    private Button buttonRegister;
    @FXML
    private ImageView PatientImage;
    private Connection connection;
    private Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_appointments", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(LoginPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.statement = connection.createStatement();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDashboardBookedAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void buttonLoginAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardFreeAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void buttonCancelAction(ActionEvent event) throws IOException {
        ViewManger.getPatientLoginpage().close();
    }

    @FXML
    private void buttonRegisterAction(ActionEvent event) throws IOException {
        ViewManger.getPatientRegisterpage().show();
    }
    
}
