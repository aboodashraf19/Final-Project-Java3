/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Patient;

import Controller.Admin.*;
import Model.Appointment;
import Model.Appointment;
import Model.booked_appointments;
//import Model.Appointment;
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
public class PatientDashboardBookedAppointmentsController implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Label labelTitel;
    @FXML
    private TableView<Appointment> bookedTableView;
    @FXML
    private TableColumn<Appointment, Integer> idBookedCol;
    @FXML
    private TableColumn<Appointment, String> userIdCol;
    @FXML
    private TableColumn<Appointment, String> appIdCol;
    @FXML
    private TableColumn<Appointment, String> statusBookedCol;
    @FXML
    private TableColumn<Appointment, String> docCommentCol;
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
    private Button btnShowMyBookedWaitingAppointments;
    @FXML
    private Button btnShowMyBookedFinishedAppointments;
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

    }

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
    private void buttonShowMyBookedWaitingAppointmentsAction() throws IOException {

        ViewManger.getPatientDashboard().getPatientDashboardBookedAppointments();
        ViewManger.getPatientDashboard().show();

    }

    @FXML
    private void buttonShowMyBookedFinishedAppointmentsAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardBookedAppointments();
        ViewManger.getPatientDashboard().show();
    }

    @FXML
    private void btnShowMyBookedWaitingAppointmentsAction(ActionEvent event) throws SQLException {
        
      bookedTableView.getItems().clear();
try {
        String query = "SELECT * FROM booked_appointments WHERE status = 'waiting'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(resultSet.getInt("id"));
            appointment.setUser_id(resultSet.getInt("user_id"));
            appointment.setDoctor_comment(resultSet.getString("doctor_comment"));
            
            appointment.setStatus(resultSet.getString("status"));

            bookedTableView.getItems().add(appointment);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
       

    

    @FXML
    private void btnShowMyBookedFinishedAppointmentsAction(ActionEvent event) {
  bookedTableView.getItems().clear();
try {
        String query = "SELECT * FROM booked_appointments WHERE status = 'Finished'";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(resultSet.getInt("id"));
            appointment.setUser_id(resultSet.getInt("user_id"));
            appointment.setDoctor_comment(resultSet.getString("doctor_comment"));
            
            appointment.setStatus(resultSet.getString("status"));

            bookedTableView.getItems().add(appointment);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        ViewManger.getPatientDashboard().getPatientDashboardBookedAppointments();
        ViewManger.getPatientDashboard().close();
    }

    private String getCurrentLoggedInUserId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
