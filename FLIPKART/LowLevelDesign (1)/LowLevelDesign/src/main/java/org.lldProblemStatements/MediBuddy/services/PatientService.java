package main.java.org.lldProblemStatements.MediBuddy.services;

import main.java.org.lldProblemStatements.MediBuddy.models.Doctor;
import main.java.org.lldProblemStatements.MediBuddy.models.Patient;

import java.util.ArrayList;
import java.util.HashMap;

public class PatientService {

    private HashMap<String, Patient> patients;
    private static PatientService instance;

    private PatientService(){
        this.patients = new HashMap<>();
    }

    public static PatientService getInstance(){
        if(instance==null){
            instance = new PatientService();
        }
        return instance;
    }

    public Patient getPatient(String patientName){
        return this.patients.get(patientName);
    }

    public HashMap<String, Patient> getPatientsMap() {
        return patients;
    }

    public void addPatients(Patient patient){
        patients.put(patient.getName(),patient);
    }

    public boolean isValidPatient(String patientName){
        return this.patients.containsKey(patientName);
    }
}
