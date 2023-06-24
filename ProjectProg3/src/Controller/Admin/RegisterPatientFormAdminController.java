/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Patient.PatientDashboardFreeAppointmentsController;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class RegisterPatientFormAdminController implements Initializable {

    @FXML
    private Label labelName;
    @FXML
    private Label labelAge;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPhone;
    @FXML
    private Label labelGender;
    @FXML
    private Label labelRole;
    @FXML
    private Label labelPassword;
    @FXML
    private Label labelUserName;
    @FXML
    private TextField textFieldLastName;
    @FXML
    private TextField textFieldFirstName;
    @FXML
    private Label labelFirstName;
    @FXML
    private Label labelLastName;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private RadioButton genderFemal;
    @FXML
    private ToggleGroup ToggleGroupGender;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton roleAdmin;
    @FXML
    private ToggleGroup ToggleGroupRole;
    @FXML
    private RadioButton rolePatient;
    @FXML
    private Button buttonCancel;
    @FXML
    private Label labelTitelCreatPatient;
    private Connection connection;
    private Statement statement;
    @FXML
    private Button buttonUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_appointments", "root", "");
            this.statement = connection.createStatement();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDashboardFreeAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

private void buttonRegisterAction(ActionEvent event) {
    String firstName = textFieldFirstName.getText();
    String lastName = textFieldLastName.getText();
    int age = Integer.parseInt(textFieldAge.getText());
    String email = textFieldEmail.getText();
    int phone = Integer.parseInt(textFieldPhone.getText());
    String username = textFieldUserName.getText();
    String password = PasswordField.getText();
    String gender = genderFemal.isSelected() ? "female" : "male";
    String role = roleAdmin.isSelected() ? "admin" : "patient";

    try {
        String query = "INSERT INTO users (username, password, firstname, lastname, age, email, phone, gender, role) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, firstName);
        statement.setString(4, lastName);
        statement.setInt(5, age);
        statement.setString(6, email);
        statement.setInt(7, phone);
        statement.setString(8, gender);
        statement.setString(9, role);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("New patient registered successfully!");
         
        } else {
            System.out.println("Failed to register new patient!");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    @FXML
    private void buttonCancelAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    private void buttonUpdateAction(ActionEvent event) {
    }

}
