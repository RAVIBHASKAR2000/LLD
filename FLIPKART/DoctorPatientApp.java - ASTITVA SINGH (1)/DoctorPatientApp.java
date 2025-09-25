import java.util.*;

class Flipmedi {
    private Map<String, Doctor> doctors = new HashMap<>();
    private Map<String, Patient> patients = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    private Queue<Patient> waitlist = new LinkedList<>();
    private int bookingIdCounter = 1;

    public void registerDoctor(String name, String speciality) {
        if (doctors.containsKey(name)) {
            throw new IllegalArgumentException("Doctor already registered.");
        }
        Doctor doctor = new Doctor(name, speciality);
        doctors.put(name, doctor);
        System.out.println("Welcome Dr. " + name + "!!");
    }

    public void markAvailability(String name, List<String> slots) {
        Doctor doctor = getDoctor(name);
        for (String slot : slots) {
            if (!isValidSlot(slot)) {
                System.out.println("Sorry Dr. " + name + ", slots are 30 mins only.");
                return;
            }
        }
        doctor.markAvailability(slots);
        System.out.println("Done Doc!");
    }

    public void showAvailableSlotsBySpeciality(String speciality) {
        for (Doctor doctor : doctors.values()) {
            if (doctor.getSpeciality().equalsIgnoreCase(speciality)) {
                doctor.showAvailability();
            }
        }
    }

    public void bookAppointment(String patientName, String doctorName, String time) {
        Patient patient = patients.computeIfAbsent(patientName, Patient::new);
        Doctor doctor = getDoctor(doctorName);

        if (doctor.isAvailable(time) && patient.canBook(time)) {
            int bookingId = bookingIdCounter++;
            doctor.bookSlot(time);
            patient.bookSlot(doctorName, time, bookingId);
            bookings.put(bookingId, new Booking(patientName, doctorName, time));
            doctor.incrementAppointmentCount();  // Increment the doctor’s appointment count
            System.out.println("Booked. Booking id: " + bookingId);
        } else {
            // If slot is full, add patient to the waitlist
            waitlist.add(patient);
            System.out.println("Slot is full. Adding to waitlist.");
        }
    }

    public void cancelAppointment(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking == null) {
            System.out.println("Invalid booking ID.");
            return;
        }

        Doctor doctor = getDoctor(booking.getDoctorName());
        Patient patient = patients.get(booking.getPatientName());
        doctor.cancelSlot(booking.getTime());
        patient.cancelSlot(bookingId);
        doctor.decrementAppointmentCount();  // Decrement the doctor’s appointment count
        System.out.println("Booking Cancelled.");

        // Attempt to assign a slot from the waitlist
        System.out.println("Checking for waitlist");
        assignSlotFromWaitlist(booking.getTime());
    }

    public void assignSlotFromWaitlist(String time) {
        if (!waitlist.isEmpty()) {
            Patient waitlistedPatient = waitlist.poll();  // Get the next patient from the waitlist
            Doctor doctor = getDoctor(waitlistedPatient.getName());  // Get the doctor for this patient
            if (doctor.isAvailable(time)) {
                waitlistedPatient.bookSlot(waitlistedPatient.getName(), time, bookingIdCounter++);
                doctor.bookSlot(time);
                System.out.println("Assigned the slot to Patient: " + waitlistedPatient.getName());
            } else {
                System.out.println("No available slots for waitlisted patients.");
            }
        } else {
            System.out.println("No patients in waitlist for this slot.");
        }
    }

    public void showAppointments(String entity) {
        if (doctors.containsKey(entity)) {
            doctors.get(entity).showBookings();
        } else if (patients.containsKey(entity)) {
            patients.get(entity).showBookings();
        } else {
            System.out.println("No appointments found.");
        }
    }

    private Doctor getDoctor(String name) {
        Doctor doctor = doctors.get(name);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found.");
        }
        return doctor;
    }

    private boolean isValidSlot(String slot) {
        return true;
    }

    public void showTrendingDoctor() {
        Doctor trendingDoctor = null;
        int maxAppointments = 0;
        for (Doctor doctor : doctors.values()) {
            int appointmentCount = doctor.getAppointmentCount();
            if (appointmentCount > maxAppointments) {
                maxAppointments = appointmentCount;
                trendingDoctor = doctor;
            }
        }
        if (trendingDoctor != null) {
            System.out.println("Trending Doctor: Dr. " + trendingDoctor.getName() + " " + maxAppointments + " appointments.");
        } else {
            System.out.println("No trending doctor yet.");
        }
    }
}

class Doctor {
    private String name;
    private String speciality;
    private Set<String> availableSlots = new TreeSet<>();
    private List<String> bookings = new ArrayList<>();
    private int appointmentCount = 0;

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getName() {
        return name;
    }

    public int getAppointmentCount() {
        return appointmentCount;
    }

    public void markAvailability(List<String> slots) {
        availableSlots.addAll(slots);
    }

    public boolean isAvailable(String time) {
        return availableSlots.contains(time);
    }

    public void bookSlot(String time) {
        availableSlots.remove(time);
        bookings.add(time);
    }

    public void cancelSlot(String time) {
        availableSlots.add(time);
        bookings.remove(time);
    }

    public void incrementAppointmentCount() {
        appointmentCount++;
    }

    public void decrementAppointmentCount() {
        appointmentCount--;
    }

    public void showAvailability() {
        System.out.println("Dr. " + name + ": " + availableSlots);
    }

    public void showBookings() {
        System.out.println("Dr. " + name + ": " + bookings);
    }
}

class Patient {
    private String name;
    private Map<Integer, String> bookings = new HashMap<>();

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean canBook(String time) {
        return !bookings.containsValue(time);
    }

    public void bookSlot(String doctorName, String time, int bookingId) {
        bookings.put(bookingId, time);
    }

    public void cancelSlot(int bookingId) {
        bookings.remove(bookingId);
    }

    public void showBookings() {
        System.out.println(name + ": " + bookings);
    }
}

class Booking {
    private String patientName;
    private String doctorName;
    private String time;

    public Booking(String patientName, String doctorName, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTime() {
        return time;
    }
}

public class DoctorPatientApp {
    public static void main(String[] args) {
        Flipmedi fm = new Flipmedi();

        fm.registerDoctor("Curious", "Cardiologist");
        fm.registerDoctor("Dreadful", "Dermatologist");

        fm.markAvailability("Curious", Arrays.asList("9:30-10:00", "12:30-13:00", "16:00-16:30"));
        fm.markAvailability("Dreadful", Arrays.asList("9:30-10:00", "12:30-13:00", "16:00-16:30"));

        fm.showAvailableSlotsBySpeciality("Cardiologist");
        fm.showAvailableSlotsBySpeciality("Dermatologist");

        fm.bookAppointment("PatientA", "Curious", "12:30-13:00");
        fm.bookAppointment("PatientB", "Curious", "9:30-10:00");

        fm.showAppointments("Curious");
        fm.showAppointments("PatientA");

        fm.cancelAppointment(1);  // Cancel booking with ID 1

        fm.showTrendingDoctor();
    }
}
