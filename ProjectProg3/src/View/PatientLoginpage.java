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
public class PatientLoginpage extends Stage{

    public PatientLoginpage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Patient/LoginPatient.fxml"));
        this.setScene(new Scene(root));
    }
    
}
