package GymBuddy.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Progress {
    private double duration;
    private String type;
    private LocalDate date;

    public Progress(double duration,String type,LocalDate date){
        validateDuration(duration);
        this.duration = duration;
        validateType(type);
        this.type = type;
        validateDate(date);
        this.date = date;
    }

    private void validateDuration(double duration){
        if(duration < 0){
            throw new IllegalArgumentException("Please Enter Valid Duration !");
        }
    }

    private void validateType(String type){
        if(type == null || type.isBlank()){
            throw new IllegalArgumentException("Please Enter Valid Type !");
        }
    }

    private void validateDate(LocalDate date){
        Objects.requireNonNull(date,"Date Cannot be Null !");
        if(date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Please Enter Valid Date !");
        }
    }

    public double getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDuration(double duration) {
        validateDuration(duration);
        this.duration = duration;
    }

    public void setDate(LocalDate date) {
        validateDate(date);
        this.date = date;
    }
    public void setType(String type) {
        validateType(type);
        this.type = type;
    }
}

