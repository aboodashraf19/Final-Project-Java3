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
public class Appointment {
    private int id;
    private String date;
    private String day;
    private String time;
    private String status;
    private String doctor_comment;
    private int user_id;
 
    public String getDoctor_comment() {
        return doctor_comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDoctor_comment(String doctor_comment) {
        this.doctor_comment = doctor_comment;
    }

    public Appointment(int id, String date, String day, String time, String status, String doctor_comment,int user_id) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.day = day;
        this.time = time;
        this.status = status;
        this.doctor_comment = doctor_comment;
    }

    

    public Appointment(int appointmentId, String appointmentDate, String appointmentDay, String appointmentTime, int userId, String status, String doctorComment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Appointment() {
    }

    public Appointment(int id, String date, String day, String time) {
        this.id = id;
        this.date = date;
        this.day = day;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}

