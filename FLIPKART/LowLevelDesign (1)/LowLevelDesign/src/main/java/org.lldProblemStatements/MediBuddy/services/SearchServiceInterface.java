package main.java.org.lldProblemStatements.MediBuddy.services;

import main.java.org.lldProblemStatements.MediBuddy.models.Doctor;
import main.java.org.lldProblemStatements.MediBuddy.models.Speciality;

import java.util.HashMap;
import java.util.List;

public interface SearchServiceInterface {
    void search(HashMap<Speciality, Doctor> doctorSpecialityMap,Speciality speciality);
}

class DefaultSearchService implements SearchServiceInterface{
    @Override
    public void search(HashMap<Speciality, Doctor> doctorSpecialityMap,Speciality speciality){
        List<Doctor> doctors = doctorSpecialityMap.values().stream().filter((e)->e.getSpeciality()==speciality).toList();
        for(Doctor doctor:doctors){
            doctor.displayAvailability();
            System.out.println();
        }
    }
}
