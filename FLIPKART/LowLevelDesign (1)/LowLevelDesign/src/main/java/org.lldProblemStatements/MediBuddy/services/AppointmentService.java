package main.java.org.lldProblemStatements.MediBuddy.services;

import main.java.org.lldProblemStatements.MediBuddy.models.Appointment;
import main.java.org.lldProblemStatements.MediBuddy.models.Doctor;
import main.java.org.lldProblemStatements.MediBuddy.models.Patient;
import main.java.org.lldProblemStatements.MediBuddy.models.WaitlistedAppointment;

import javax.print.Doc;
import java.util.*;

public class AppointmentService {
    private static AppointmentService instance;
    private DoctorService doctorService;
    private PatientService patientService;
    private HashMap<String, Appointment> appointments;
    private HashMap<String,List<Queue<WaitlistedAppointment>>> waitList;

    private AppointmentService() {
        this.doctorService = DoctorService.getInstance();
        this.patientService = PatientService.getInstance();
        this.appointments = new HashMap<>();
        this.waitList = new HashMap<>();
    }

    public static AppointmentService getInstance(){
        if(instance==null){
            instance = new AppointmentService();
        }
        return instance;
    }

    public Appointment bookAppointment(String doctorName, int timeSlot, String patientName){
        // validate if the patient is valid
        if(!doctorService.isValidDoctor(doctorName)){
            System.out.println("Invalid doctor");
            return null;
        }
        // validate if the doctor is valid
        if(!patientService.isValidPatient(patientName)){
            System.out.println("Invalid patient!");
            return null;
        }

        Doctor doctor = doctorService.getDoctor(doctorName);
        Patient patient = patientService.getPatient(patientName);

        // check if the doctor is available at that slot
        if(!doctorService.isDoctorAvailableAt(timeSlot, doctorName)){
            System.out.println("Doctor is not available, we are putting you in the waitlist");
            WaitlistedAppointment waitlisted = new WaitlistedAppointment(patient, doctor, timeSlot);

            if(!waitList.containsKey(doctorName)) {
                waitList.put(doctorName, new ArrayList<>(Collections.nCopies(24, new LinkedList<>())));
            }
            waitList.get(doctorName).get(timeSlot).add(waitlisted);
            return null;
        }

        Appointment appointment = new Appointment(patient, doctor, timeSlot);
        doctor.setDoctorUnavailable(timeSlot);
        appointments.put(appointment.getBookingID().toString(),appointment);

        System.out.println("Your booking id is: "+appointment.getBookingID());
        return appointment;

    }

    private boolean isValidAppointment(String bookingID){
        return this.appointments.containsKey(bookingID);
    }

    public void cancelAppointment(String bookingID, String patient){
        if(!isValidAppointment(bookingID)){
            System.out.println("Invalid bookingID!");
            return;
        }
        // validate if valid patient is cancelling booking

        Appointment appointment = appointments.get(bookingID);

        appointments.remove(bookingID);

        Doctor doctor = appointment.getDoctor();
        int timeSlot = appointment.getTimeSlot();

        if(!waitList.get(doctor.getName()).get(timeSlot).isEmpty()){
            WaitlistedAppointment wl = waitList.get(doctor.getName()).get(timeSlot).poll();
            Appointment waitListedAppointment = new Appointment(wl.getPatient(),wl.getDoctor(),wl.getTimeSlot());
            appointments.put(waitListedAppointment.getBookingID().toString(),waitListedAppointment);
        }
        else{
            doctor.setAvailability(timeSlot);
        }

    }
}
