package GymBuddy.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Trainer extends User {
    private Specialization specialization;
    private List<GymClass> myClasses;
    private final int trainerID;

    public Trainer(String name, int trainerID, LocalDate dateOfBirth, String location,
                   SchedulePreference schedulePreference, Specialization specialization) {
        super(name, dateOfBirth, location, schedulePreference);

        validateId(trainerID);
        this.trainerID = trainerID;

        this.specialization = Objects.requireNonNull(specialization, "Specialization cannot be null!");
        this.myClasses = new ArrayList<>();
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID Cannot Be Negative!");
        }
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = Objects.requireNonNull(specialization, "Specialization cannot be null!");
    }

    public List<GymClass> getMyClasses() {
        return Collections.unmodifiableList(myClasses);
    }

    public void addClass(GymClass session) {
        this.myClasses.add(session);
    }

    public void removeClass(GymClass session) {
        this.myClasses.remove(session);
    }

    public int getTrainerID() {
        return trainerID;
    }

    @Override
    public void performRole() {
        System.out.println("Role: Trainer | Expertise: " + specialization);
    }
}