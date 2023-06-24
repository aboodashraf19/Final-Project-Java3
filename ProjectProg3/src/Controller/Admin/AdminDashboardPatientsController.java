/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Patient.PatientDashboardFreeAppointmentsController;
import Model.Appointment;
import Model.Users;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class AdminDashboardPatientsController implements Initializable {

    @FXML
    private Label labelAdminDashboard;
    @FXML
    private Label labelDoctorFunction;
    @FXML
    private Button buttonShowAllRegisterdPatients;
    @FXML
    private Button buttonSearchInPatientsByFirstName;
    @FXML
    private Button buttonShowMyAllBookedAppointments;
    @FXML
    private Button buttonCRUDPatient;
    @FXML
    private Button buttonShowMyAllFreeAppointments;
    @FXML
    private Button buttonCRUDAppointment;
    @FXML
    private Button buttonSearchInBookedByFirstName;
    @FXML
    private Button buttonLeaveAComment;
    @FXML
    private Button logout;
    @FXML
    private Label labelFunctionOfThePatient;
    @FXML
    private Label labelFunctionOfThelabelFunctionOfBookedAppointments;
    @FXML
    private Label labelFunctionOfThelabelFunctionOfFreeAppointments;
    @FXML
    private Label labelTitel;
    @FXML
    private TableView<Users> patientsTableView;
    @FXML
    private TableColumn<Users, Integer> tvID;
    @FXML
    private TableColumn<Users, String> tvUserName;
    @FXML
    private TableColumn<Users, String> tvFirstName;
    @FXML
    private TableColumn<Users, String> tvLastName;
    @FXML
    private TableColumn<Users, Integer> tvAge;
    @FXML
    private TableColumn<Users, String> tvEmail;
    @FXML
    private TableColumn<Users, String> tvPassword;
    @FXML
    private TableColumn<Users, Integer> tvPhone;
    @FXML
    private TableColumn<Users, String> tvGender;
    @FXML
    private TableColumn<Users, String> tvRole;
    @FXML
    private TextField txtSearchInPatients;
    @FXML
    private Button btnSearchInPatients;
    @FXML
    private Button btnShowallRegisterdPatientsInTheSystem;
    @FXML
    private Button btnCreateNewPatient;
    @FXML
    private Button btnDelelte;
    @FXML
    private Button btnUpdataPatient;
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
        tvID.setCellValueFactory(new PropertyValueFactory("id"));
        tvUserName.setCellValueFactory(new PropertyValueFactory("userName"));
        tvFirstName.setCellValueFactory(new PropertyValueFactory("firstname"));
        tvLastName.setCellValueFactory(new PropertyValueFactory("lastname"));
        tvAge.setCellValueFactory(new PropertyValueFactory("age"));
        tvEmail.setCellValueFactory(new PropertyValueFactory("email"));
//        tvPassword.setCellValueFactory(new PropertyValueFactory("password"));
        tvPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        tvGender.setCellValueFactory(new PropertyValueFactory("gender"));
        tvRole.setCellValueFactory(new PropertyValueFactory("role"));
//                patientsTableView.getSelectionModel().selectedItemProperty().addListener(
//                event->ShowSellected()
//                );

    }

    @FXML
    private void buttonShowAllRegisterdPatientsAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonSearchInPatientsByFirstNameAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonCRUDPatientAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonShowMyAllFreeAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardFreeAppointments();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonCRUDAppointmentAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardFreeAppointments();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonShowMyAllBookedAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardBookedAppointments();
        ViewManger.getAdminDashboard().show();

    }

    @FXML
    private void buttonSearchInBookedByFirstNameAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardBookedAppointments();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void buttonLeaveACommentAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardBookedAppointments();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardPatients();
        ViewManger.getAdminDashboard().close();
    }

    @FXML
    private void btnsearchInPatientsAction(ActionEvent event) throws SQLException {

        patientsTableView.getItems().clear();
        String firstName = txtSearchInPatients.getText().trim();

        String query = "SELECT * FROM users WHERE firstName LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, firstName + "%");

        ResultSet re = statement.executeQuery();
        while (re.next()) {
            Users user = new Users();

            user.setId(re.getInt("id"));
            user.setUserName(re.getString("username"));
            user.setPassword(re.getString("password"));
            user.setFirstname(re.getString("firstname"));
            user.setLastname(re.getString("lastname"));
            user.setAge(re.getInt("age"));
            user.setEmail(re.getString("email"));
            user.setPhone(re.getInt("phone"));
            user.setGender(re.getString("gender"));
            user.setRole(re.getString("role"));

            patientsTableView.getItems().add(user);
        }

    }

    @FXML
    private void btnShowallRegisterdPatientsInTheSystemAction(ActionEvent event) throws SQLException {
        patientsTableView.getItems().clear();
        String query = "SELECT * FROM `users`";

        ResultSet re = this.statement.executeQuery(query);

        while (re.next()) {
            Users user = new Users();

            user.setId(re.getInt("id"));
            user.setUserName(re.getString("username"));
            user.setPassword(re.getString("password"));
            user.setFirstname(re.getString("firstname"));
            user.setLastname(re.getString("lastname"));
            user.setAge(re.getInt("age"));
            user.setEmail(re.getString("email"));
            user.setPhone(re.getInt("phone"));
            user.setGender(re.getString("gender"));
            user.setRole(re.getString("role"));

             patientsTableView.getItems().add(user);
        }

    }

    @FXML
    private void btncreateNewPatientAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardCreatPatient();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void btnupdatePatientAction(ActionEvent event) throws IOException {
        ViewManger.getAdminDashboard().getAdminDashboardUpdatePatient();
        ViewManger.getAdminDashboard().show();
    }

    @FXML
    private void btndeleltePatientAction(ActionEvent event) {

        Users selectedPatient = patientsTableView.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            int selectedPatientId = selectedPatient.getId();

            try {
                String query = "DELETE FROM users WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, selectedPatientId);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    patientsTableView.getItems().remove(selectedPatient);
                    System.out.println("Patient deleted successfully!");
                } else {
                    System.out.println("Failed to delete patient!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No patient selected!");
        }
    }
    
}
