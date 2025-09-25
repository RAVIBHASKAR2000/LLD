package main.java.org.lldProblemStatements.MediBuddy.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor {
    private final String name;
    private final Speciality speciality;

//    private List<Appointment> doctorsAvailability;

    private List<Boolean> isAvailableAtSlot;

    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
//        this.doctorsAvailability = new ArrayList<>(Collections.nCopies(24,null));
        this.isAvailableAtSlot = new ArrayList<>(Collections.nCopies(24,false));
    }

    public String getName() {
        return name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public boolean checkIfAvailableAt(Integer timeSlot){
        return this.isAvailableAtSlot.get(timeSlot);
    }

    public void setAvailability(Integer timeSlot){
        this.isAvailableAtSlot.set(timeSlot, true);
    }

    public void setDoctorUnavailable(int timeSlot){
        this.isAvailableAtSlot.set(timeSlot,false);
    }

    public void displayAvailability(){
        System.out.println("Doctor "+name+" is available at:");
        for(int i=0;i<24;i++){
            if(this.isAvailableAtSlot.get(i)){
                System.out.println(i);
            }
        }
    }
}
