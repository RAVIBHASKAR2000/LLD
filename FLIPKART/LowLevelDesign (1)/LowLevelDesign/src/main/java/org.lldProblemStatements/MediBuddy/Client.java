package main.java.org.lldProblemStatements.MediBuddy;

import main.java.org.lldProblemStatements.MediBuddy.models.Appointment;
import main.java.org.lldProblemStatements.MediBuddy.models.Doctor;
import main.java.org.lldProblemStatements.MediBuddy.models.Patient;
import main.java.org.lldProblemStatements.MediBuddy.models.Speciality;
import main.java.org.lldProblemStatements.MediBuddy.services.AppointmentService;
import main.java.org.lldProblemStatements.MediBuddy.services.DoctorService;
import main.java.org.lldProblemStatements.MediBuddy.services.PatientService;

import java.util.List;

public class Client {
    public static void main(String[] args){
        DoctorService doctorService = DoctorService.getInstance();
        PatientService patientService = PatientService.getInstance();
        AppointmentService appointmentService = AppointmentService.getInstance();

        patientService.addPatients(new Patient("patientA"));
        patientService.addPatients(new Patient("patientB"));

        doctorService.addDoctors(new Doctor("curious", Speciality.Cardiologist));
        doctorService.setAvailablility(List.of(0,7,14),"curious");

        doctorService.addDoctors(new Doctor("dreadful", Speciality.Dematologist));
        doctorService.setAvailablility(List.of(0,7,14),"dreadful");

        doctorService.getDoctorBySpeciality(Speciality.Cardiologist);

        Appointment bookingID1 = appointmentService.bookAppointment("curious",7,"patientA");
        Appointment bookingID2 = appointmentService.bookAppointment("curious",7,"patientB");

        doctorService.getDoctorBySpeciality(Speciality.Cardiologist);

        appointmentService.cancelAppointment(bookingID1.getBookingID().toString(),"patientA");
        doctorService.getDoctorBySpeciality(Speciality.Cardiologist);
        appointmentService.cancelAppointment(bookingID2.getBookingID().toString(),"patientB");
        doctorService.getDoctorBySpeciality(Speciality.Cardiologist);
    }
}
