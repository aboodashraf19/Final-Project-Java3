/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class AdminDashboard extends Stage{
     
    public void getAdminDashboardBookedAppointments() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Admin/AdminDashboardBooked-Appointments.fxml"));
       this.setScene(new Scene((root)));
    }
    
    public void getAdminDashboardFreeAppointments() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Admin/AdminDashboardFree-Appointments.fxml"));
       this.setScene(new Scene((root)));
    }
    
    public void getAdminDashboardPatients() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Admin/AdminDashboardPatients.fxml"));
       this.setScene(new Scene((root)));
    }
    
    public void getAdminDashboardCreatPatient() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Admin/RegisterPatientFromAdmin.fxml"));
        this.setScene(new Scene((root)));
    }

    
    public void getAdminDashboardUpdatePatient() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Patient/UpdaterPatient.fxml"));
        this.setScene(new Scene((root)));
    }
    
    
    
}
