/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author For LabTop
 */
public class booked_appointments {
    private  int id;
    private  int user_id;
    private  int appointments_id;
    private String status;
    private String doctor_comment;

    public booked_appointments() {
    }

    public booked_appointments(int id, int user_id, int appointments_id, String status, String doctor_comment) {
        this.id = id;
        this.user_id = user_id;
        this.appointments_id = appointments_id;
        this.status = status;
        this.doctor_comment = doctor_comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAppointments_id() {
        return appointments_id;
    }

    public void setAppointments_id(int appointments_id) {
        this.appointments_id = appointments_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_comment() {
        return doctor_comment;
    }

    public void setDoctor_comment(String doctor_comment) {
        this.doctor_comment = doctor_comment;
    }
    
    
}
