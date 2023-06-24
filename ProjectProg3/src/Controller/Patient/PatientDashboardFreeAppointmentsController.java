/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Patient;

import Controller.Admin.*;
import Model.Appointment;
import Model.booked_appointments;
//import Model.Users;
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
public class PatientDashboardFreeAppointmentsController implements Initializable {

    @FXML
    private Button logout;
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
    private Label labelPatientDashboard;
    @FXML
    private Label labelPatientFunction;
    @FXML
    private Button buttonShowAllFreeAppointments;
    @FXML
    private Button buttonBookAnAppointment;
    @FXML
    private Button buttonShowMyBookedWaitingAppointments;
    @FXML
    private Button buttonShowMyBookedFinishedAppointments;
    @FXML
    private Label labelAllFunctionOfBookedAppointments;
    @FXML
    private Label labelAllFunctionOfFreeAppointments;
    @FXML
    private Button btnShowAllAppointments;
    @FXML
    private Button btnBookedApp;

    private Statement statement;
    Connection connection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

//        freeTableView.getColumns().addAll(idCol,appDateCol, appDayCol, appTimeCol, statusCol);
    @FXML
    private void buttonShowAllFreeAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardFreeAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void buttonBookAnAppointmentAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardFreeAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void buttonShowMyBookedWaitingAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardBookedAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void buttonShowMyBookedFinishedAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardBookedAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void btnbookAppointmentAction(ActionEvent event) throws SQLException {
        freeTableView.getItems().clear();
        String query = "SELECT * FROM `appointments` WHERE status = 'booked'";

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
    private void btnShowAllFreeAppointmentsAction(ActionEvent event) throws SQLException {

        freeTableView.getItems().clear();
        String query = "SELECT * FROM `appointments` WHERE status = 'free'";

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
    private void logoutAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardFreeAppointments();
        ViewManger.getPatientDashboard().close();
    }

}
