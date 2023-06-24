/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class ViewManger {

    private static AdminLoginpage adminLogin;
    private static PatientLoginpage patientLogin;
    private static PatientRegisterpage patientRegisterpage;
    private static AdminDashboard adminDashboard;
    private static PatientDashboard patientDashboard;

    public static AdminLoginpage getAmindLogInPage() throws IOException {
        if (adminLogin == null) {
            adminLogin = new AdminLoginpage();
        }
        return adminLogin;
    }

    

    public static PatientLoginpage getPatientLoginpage() throws IOException {
        if (patientLogin == null) {
            patientLogin = new PatientLoginpage();
        }
        return patientLogin;
    }

    public static PatientRegisterpage getPatientRegisterpage() throws IOException {
        if (patientRegisterpage == null) {
            patientRegisterpage = new PatientRegisterpage();
        }
        return patientRegisterpage;
    }

    public static AdminDashboard getAdminDashboard() throws IOException {
        if (adminDashboard == null) {
            adminDashboard = new AdminDashboard();
        }
        return adminDashboard;
    }

    public static PatientDashboard getPatientDashboard() throws IOException {
        if (patientDashboard == null) {
            patientDashboard = new PatientDashboard();
        }
        return patientDashboard;
    }

}
