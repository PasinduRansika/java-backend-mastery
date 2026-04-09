package GymBuddy.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Membership {
    private final int membershipId;
    private MembershipType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;

    public Membership(int membershipId, MembershipType type, LocalDate startDate) {
        this.membershipId = membershipId;
        this.type = type;
        this.startDate = startDate;
        this.price = type.getPrice();
        calculateEndDate();
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setType(MembershipType type) {
        this.type = type;
        this.price = type.getPrice();
        calculateEndDate();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        calculateEndDate();
    }

    public void  calculateEndDate(){
        if(startDate == null) return;

        if(type == MembershipType.BASIC || type == MembershipType.PREMIUM){
            this.endDate = startDate.plusMonths(1);
        }
        else this.endDate = startDate.plusYears(1);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive(){
        LocalDate today = LocalDate.now();
        return !today.isAfter(endDate);
    }

    public long getRemainingDays() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), endDate);
        return Math.max(0, days);
    }

    @Override
    public String toString() {
        return String.format("Membership[ID: %d, Type: %s, Ends: %s, Active: %b]",
                membershipId, type, endDate, isActive());
    }
}
