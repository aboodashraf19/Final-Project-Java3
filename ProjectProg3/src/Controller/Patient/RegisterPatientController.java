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
 * @author For LabTop
 */
public class RegisterPatientController implements Initializable {

    @FXML
    private Label labelTitelCreatPatient;
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
    private Button buttonRegister;
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
    private Connection connection;
    private Statement statement;

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

    @FXML
private void buttonRegisterAction(ActionEvent event) throws SQLException {
    String firstName = textFieldFirstName.getText();
    String lastName = textFieldLastName.getText();
    int age = Integer.parseInt(textFieldAge.getText());
    String email = textFieldEmail.getText();
    String phone = textFieldPhone.getText();
    String userName = textFieldUserName.getText();
    String password = PasswordField.getText();
    String gender = genderMale.isSelected() ? "Male" : "Female";
    String role = roleAdmin.isSelected() ? "Admin" : "Patient";
    
    // TODO: Establish database connection and create a statement
    
    // Create SQL query to insert the patient into the database
    String query = "INSERT INTO `users` (firstname, lastname, age, email, phone, username, password, gender, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, firstName);
    statement.setString(2, lastName);
    statement.setInt(3, age);
    statement.setString(4, email);
    statement.setString(5, phone);
    statement.setString(6, userName);
    statement.setString(7, password);
    statement.setString(8, gender);
    statement.setString(9, role);
    // Execute the query
    int rowsAffected = statement.executeUpdate();
    // Check if the insertion was successful
    if (rowsAffected > 0) {
        // Patient successfully inserted into the database
        System.out.println("New patient registered!");
    } else {
        // Failed to insert patient into the database
        System.out.println("Failed to register new patient!");
    }
    
    // TODO: Close database connection and statement
}


    @FXML
    private void buttonCancelAction(ActionEvent event) throws IOException {
        ViewManger.getPatientRegisterpage().close();
    }
    
}
