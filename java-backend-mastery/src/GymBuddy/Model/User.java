package GymBuddy.Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class User {
    private String name;
    private final LocalDate dateOfBirth;
    private String location;
    private String involvement;

    public User(String name, LocalDate dateOfBirth, String location, String involvement) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.involvement = involvement;
    }

    public String getName() {
        return name;
    }
    public String getInvolvement() {
        return involvement;
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
    public void setInvolvement(String involvement) {
        this.involvement = involvement;
    }

    public abstract void performRole();
}
