/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Patient.PatientDashboardFreeAppointmentsController;
import Model.Appointment;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class AdminDashboardFreeAppointmentsController implements Initializable {

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
    private TableView<Appointment> freeTableView;
    @FXML
    private TableColumn<Appointment, Integer> idCol;
    @FXML
    private TableColumn<Appointment, String> appDateCol;
    @FXML
    private TableColumn<Appointment, String> appDayCol;
    @FXML
    private TableColumn<Appointment, String> appTimeCol;
    @FXML
    private TableColumn<Appointment, String> statusCol;
    @FXML
    private Button btnShowAllFreeAppointment;
    @FXML
    private Button btnCreateNewPatient;
    @FXML
    private Button btnUpdataPatient;
    @FXML
    private Button btnDelelte;

    private Statement statement;
    Connection connection;
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
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        appDateCol.setCellValueFactory(new PropertyValueFactory("date"));
        appDayCol.setCellValueFactory(new PropertyValueFactory("day"));
        appTimeCol.setCellValueFactory(new PropertyValueFactory("time"));
        statusCol.setCellValueFactory(new PropertyValueFactory("status"));
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
        ViewManger.getAdminDashboard().getAdminDashboardFreeAppointments();
        ViewManger.getAdminDashboard().close();
    }

    @FXML
    private void btnShowAllFreeAppointmentAction(ActionEvent event) throws SQLException {
         freeTableView.getItems().clear();
        String query = "SELECT * FROM `appointments` WHERE status='free' ";

        ResultSet re = this.statement.executeQuery(query);

        while (re.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(re.getInt("id"));
            appointment.setDate(re.getString("appointment_date"));
            appointment.setDay(re.getString("appointment_day"));
            appointment.setTime(re.getString("appointment_time"));
            appointment.setStatus(re.getString("status"));

            freeTableView.getItems().add(appointment);
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
    }

}
