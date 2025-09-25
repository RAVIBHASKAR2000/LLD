package main.java.org.lldProblemStatements.MediBuddy.models;

import java.util.UUID;

public class Appointment {
    private Patient patient;
    private final UUID bookingID;
    private Doctor doctor;
    private int timeSlot;
    // add status feature for appointment

    public Appointment(Patient patient, Doctor doctor, int timeSlot) {
        this.bookingID = UUID.randomUUID();
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

    public int getTimeSlot(){return this.timeSlot;}
    public UUID getBookingID() {
        return bookingID;
    }
}
