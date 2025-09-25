package main.java.org.lldProblemStatements.MediBuddy.models;

import java.util.UUID;

public class WaitlistedAppointment {
    private Patient patient;
    private Doctor doctor;
    private Integer timeSlot;

    public WaitlistedAppointment(Patient patient, Doctor doctor, Integer timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }
}
