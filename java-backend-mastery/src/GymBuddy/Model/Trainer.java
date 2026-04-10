package GymBuddy.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer extends User{
    private String specialization;
    private List<GymClass> myClasses;

    public Trainer(String name, LocalDate dateOfBirth, String location, SchedulePreference schedulePreference, String specialization) {
        super(name, dateOfBirth, location, schedulePreference);

        validateSpecialization(specialization);
        this.specialization = specialization;

        this.myClasses = new ArrayList<>();
    }

    private void validateSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<GymClass> getMyClasses() {
        return Collections.unmodifiableList(myClasses);
    }

    public void setSpecialization(String specialization) {
        validateSpecialization(specialization);
        this.specialization = specialization;
    }

    public void addClass(GymClass session){
        this.myClasses.add(session);
    }

    public void removeClass(GymClass session){
        this.myClasses.remove(session);
    }

    @Override
    public void performRole() {
        System.out.println("I am a Trainer");
    }
}
