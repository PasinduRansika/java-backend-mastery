package GymBuddy.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GymClass {
    private final int classID;
    private ClassTypes classType;
    private LocalDate date;
    private LocalTime time;
    private int maximumCapacity;
    private Trainer trainer;
    private int currentBookings;

    public GymClass(int classID, ClassTypes classType, LocalDate date, LocalTime time, int maximumCapacity, Trainer trainer) {
        validateID(classID);
        this.classID = classID;

        validateClassType(classType);
        this.classType = classType;

        validateDateAndTime(date,time);
        this.date = date;
        this.time = time;

        validateCapacity(maximumCapacity);
        this.maximumCapacity = maximumCapacity;

        validateTrainer(trainer);
        this.trainer = trainer;

    }

    public int getClassID() {
        return classID;
    }

    public ClassTypes getClassType() {
        return classType;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    public void setClassType(ClassTypes classType) {
        validateClassType(classType);
        this.classType = classType;
    }

    public void setDateAndTime(LocalDate date,LocalTime time) {
        validateDateAndTime(date,time);
        this.time = time;
        this.date = date;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        validateCapacity(maximumCapacity);
        this.maximumCapacity = maximumCapacity;
    }

    public void incrementBookings() {
        if(currentBookings >= maximumCapacity)
            throw new IllegalStateException("Class Is full !");
        currentBookings++;
    }

    public void decrementBookings() {
        if(currentBookings <= 0)
            throw new IllegalStateException("No Bookings To Cancel !");
        currentBookings--;
    }

    public void setTrainer(Trainer trainer) {
        validateTrainer(trainer);
        this.trainer = trainer;
    }

// validation methods
private void validateID(int classID) {
    if (classID <= 0) throw new IllegalArgumentException("Enter a valid positive ID!");
    }

    private void validateCapacity(int maximumCapacity) {
        if (maximumCapacity <= 0) throw new IllegalArgumentException("Maximum capacity must be at least 1!");
    }

    private void validateTrainer(Trainer trainer) {
        if (trainer == null) throw new IllegalArgumentException("Trainer cannot be null!");
    }

    private void validateClassType(ClassTypes type) {
        if (type == null) throw new IllegalArgumentException("Class type cannot be null!");
    }

    private void validateDateAndTime(LocalDate date, LocalTime time) {
        if (date == null) throw new IllegalArgumentException("Date cannot be null!");
        if (time == null) throw new IllegalArgumentException("Time cannot be null!");
        if (!date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Classes must be scheduled for a future date (starting from tomorrow)!");
        }
    }
}
