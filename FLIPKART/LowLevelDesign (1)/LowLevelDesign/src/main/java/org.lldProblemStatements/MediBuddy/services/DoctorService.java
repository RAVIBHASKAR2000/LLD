package main.java.org.lldProblemStatements.MediBuddy.services;

import main.java.org.lldProblemStatements.MediBuddy.models.Appointment;
import main.java.org.lldProblemStatements.MediBuddy.models.Doctor;
import main.java.org.lldProblemStatements.MediBuddy.models.Speciality;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DoctorService {
    private HashMap<String, Doctor> doctors;
    private HashMap<Speciality, Doctor> doctorSpecialityMap;
    private SearchServiceInterface searchService;
    private static DoctorService instance;

    private DoctorService(){
        this.doctors = new HashMap<>();
        this.doctorSpecialityMap = new HashMap<>();
        this.searchService = new DefaultSearchService();
    }

    public Doctor getDoctor(String doctorName){
        return this.doctors.get(doctorName);
    }

    public static DoctorService getInstance(){
        if(instance==null){
            instance = new DoctorService();
        }
        return instance;
    }

    public void setSearchService(SearchServiceInterface searchService){
        this.searchService = searchService;
    }

    public HashMap<String, Doctor> getDoctorsMap() {
        return doctors;
    }

    public void addDoctors(Doctor doctor){
        this.doctors.put(doctor.getName(),doctor);
        this.doctorSpecialityMap.put(doctor.getSpeciality(),doctor);
        System.out.println("Welcome Dr. "+doctor.getName());
    }

    public boolean isDoctorAvailableAt(Integer timeSlot, String doctorName){
        // validate if the time slot is between 0-23;
        Doctor doctor = doctors.get(doctorName);
        return doctor.checkIfAvailableAt(timeSlot);
    }

    public void setAvailablility(List<Integer> availableSlots, String doctorName){
        // check for validity of the doctor
        Doctor doctor = doctors.get(doctorName);

        for(int slot: availableSlots){
            // validate if the time slot is valid or not
                doctor.setAvailability(slot);
        }

        System.out.println("Done Doc!");
    }

    public void getDoctorBySpeciality(Speciality speciality){
        searchService.search(this.doctorSpecialityMap,speciality);
    }

    public boolean isValidDoctor(String doctorName){
        return this.doctors.containsKey(doctorName);
    }
}
