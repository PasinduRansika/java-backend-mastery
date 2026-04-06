package GymBuddy.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member extends User {
    private final int memberId;
    private Membership membershipPlan;

    private List<WeightEntry> weightLog;
    private List<Booking> bookings;
    private List<Progress> progressLog;

    public Member(String name, LocalDate dateOfBirth, String location, String schedulePreference, int memberId, Membership membershipPlan) {
        super(name, dateOfBirth, location, schedulePreference);
        this.memberId = memberId;
        this.membershipPlan = membershipPlan;

        this.weightLog = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.progressLog = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public List<WeightEntry> getWeightLog() {
        return Collections.unmodifiableList(weightLog);
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public List<Progress> getProgressLog() {
        return Collections.unmodifiableList(progressLog);
    }

    public Membership getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(Membership membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void addWeightEntry(WeightEntry entry) {
        this.weightLog.add(entry);
    }
    public void addProgress(Progress progress) {
        this.progressLog.add(progress);
    }

    @Override
    public void performRole() {
        System.out.println("I am a Member");
    }

}
