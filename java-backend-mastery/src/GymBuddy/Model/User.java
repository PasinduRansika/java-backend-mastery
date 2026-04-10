package GymBuddy.Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class User {
    private final String name;
    private final LocalDate dateOfBirth;
    private String location;
    private SchedulePreference schedulePreference;

    public User(String name, LocalDate dateOfBirth, String location, SchedulePreference schedulePreference) {
        validateString(name,"name");
        this.name = name;

        if(dateOfBirth == null){
            throw new NullPointerException("Please Enter Your Date of Birth !");
        }
        if(dateOfBirth.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Please Enter A Valid Date !");
        }
        this.dateOfBirth = dateOfBirth;

        validateString(location,"location");
        this.location = location;

        if(schedulePreference == null){
            throw new IllegalArgumentException("Schedule preference is required !");
        }
        this.schedulePreference =schedulePreference;
    }

// Method for Validate Location
   private void validateString(String variable, String fieldName){
       if (variable == null || variable.trim().isEmpty()) {
           throw new IllegalArgumentException(fieldName + " cannot be null or empty.");
       }
   }

// Getters
    public String getName() {
        return name;
    }
    public SchedulePreference getSchedulePreference() {
        return schedulePreference;
    }
    public String getLocation() {
        return location;
    }
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

// Setters
    public void setLocation(String location) {
        validateString(location,"location");
        this.location = location;
    }
    public void setSchedulePreference(SchedulePreference schedulePreference) {
        if(schedulePreference == null){
            throw new IllegalArgumentException("Schedule preference is required !");
        }
        this.schedulePreference =schedulePreference;
    }

    public abstract void performRole();
}
