/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Patient.PatientDashboardBookedAppointmentsController;
import Model.Users;
import Model.booked_appointments;
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
public class AdminDashboardBookedAppointmentsController implements Initializable {

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
    private Button btnSearchInBookedAppointments;
    @FXML
    private TableView<booked_appointments> bookedTableView;
    @FXML
    private TableColumn<booked_appointments, Integer> idBookedCol;
    @FXML
    private TableColumn<booked_appointments, Integer> userIdCol;
    @FXML
    private TableColumn<booked_appointments, Integer> appIdCol;
    @FXML
    private TableColumn<booked_appointments, String> statusBookedCol;
    @FXML
    private TableColumn<booked_appointments, String> docCommentCol;
    @FXML
    private Button btnShowAllBookedAppointments;
    @FXML
    private Button btnLeaveComment;
    @FXML
    private TextField txtSearchInPatients;
  Statement statement;
    Connection connection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_appointments", "root", "");
            this.statement = connection.createStatement();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDashboardBookedAppointmentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        atributt in class
        idBookedCol.setCellValueFactory(new PropertyValueFactory("id"));
        userIdCol.setCellValueFactory(new PropertyValueFactory("user_id"));
        appIdCol.setCellValueFactory(new PropertyValueFactory("appointments_id"));
        statusBookedCol.setCellValueFactory(new PropertyValueFactory("status"));
        docCommentCol.setCellValueFactory(new PropertyValueFactory("doctor_comment"));
//         bookedTableView.getSelectionModel().selectedItemProperty().addListener(
//                event->ShowSellected());

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
        ViewManger.getAdminDashboard().getAdminDashboardBookedAppointments();
        ViewManger.getAdminDashboard().close();
    }
    

    @FXML
    private void btnShowAllBookedAppointmentsAction(ActionEvent event) throws SQLException {
         bookedTableView.getItems().clear();
        String query = "SELECT * FROM `booked_appointments` ";

        ResultSet re = this.statement.executeQuery(query);

        while (re.next()) {
            booked_appointments booked = new booked_appointments();
            booked.setId(re.getInt("id"));
            booked.setUser_id(re.getInt("user_id"));
            booked.setAppointments_id(re.getInt("appointment_id"));
            booked.setStatus(re.getString("status"));
            booked.setDoctor_comment(re.getString("doctor_comment"));
           

            bookedTableView.getItems().add(booked);
        }

        
    }

    @FXML
    private void btnLeaveCommentAndFinishAction(ActionEvent event) {
        
    }

    @FXML
    private void btnSearchInBookedAppointmentsAction(ActionEvent event) throws SQLException {
        
            String query = "SELECT user_id FROM booked_appointments ORDER BY id ASC LIMIT 1";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                System.out.println("First booked appointment user ID: " + userId);
            } else {
                System.out.println("No booked appointments found.");
            }
       
    }

    
}
