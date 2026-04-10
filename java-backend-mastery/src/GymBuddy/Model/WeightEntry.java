package GymBuddy.Model;

import java.time.LocalDate;

public class WeightEntry {
    private double weight;
    private LocalDate date;

    public WeightEntry(double weight,LocalDate date) {
        validateWeight(weight);
        validateDate(date);
    }

    private void validateWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Enter Valid Weight !");
        }
        this.weight = weight;
    }

    private void validateDate(LocalDate date) {
        if (date == null) {
            throw new NullPointerException("Date cannot be null !");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Enter Valid Date !");
        }
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

}
