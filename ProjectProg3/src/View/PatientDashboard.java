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
import jdk.nashorn.internal.objects.NativeDebug;

/**
 *
 * @author Administrator
 */
public class PatientDashboard extends Stage{
 
    public void getPatientDashboardBookedAppointments() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Patient/PatientDashboardBooked-Appointments.fxml"));
       this.setScene(new Scene((root)));
    }
    
    public void getPatientDashboardFreeAppointments() throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/View/Patient/PatientDashboardFree-Appointments.fxml"));
       this.setScene(new Scene((root)));
    }
    
}
