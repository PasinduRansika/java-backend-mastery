package GymBuddy.Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class User {
    private String name;
    private final LocalDate dateOfBirth;
    private String location;
    private String schedulePreference;

    public User(String name, LocalDate dateOfBirth, String location, String schedulePreference) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.schedulePreference = schedulePreference;
    }

    public String getName() {
        return name;
    }
    public String getSchedulePreference() {
        return schedulePreference;
    }
    public String getLocation() {
        return location;
    }
    public int getAge() {
        return Period.between(dateOfBirth,LocalDate.now()).getYears();
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setSchedulePreference(String schedulePreference) {
        this.schedulePreference = schedulePreference;
    }

    public abstract void performRole();
}
