package GymBuddy.Model;

import java.util.Objects;

public class Booking {
    private final int bookingID;
    private GymClass currentClass;
    private BookingStatus status;
    private Member member;

    public Booking(int bookingID,GymClass currentClass,Member member){
        validateID(bookingID);
        this.bookingID = bookingID;

        validateClass(currentClass);
        this.currentClass = currentClass;

        this.status = BookingStatus.PENDING;

        Objects.requireNonNull(member, "Member cannot be null!");
        this.member = member;

        this.currentClass.incrementBookings();
    }

    private void validateID(int bookingID){
        if(bookingID <= 0){
            throw new IllegalArgumentException("Please Enter Valid ID !");
        }
    }

    private void validateClass(GymClass currentClass){
        Objects.requireNonNull(currentClass,"Class Cannot Be Null !");
    }

    private void validateStatus(BookingStatus status){
        Objects.requireNonNull(status,"Status Cannot Be Null !");
    }

    public int getBookingID() {
        return bookingID;
    }

    public GymClass getCurrentClass() {
        return currentClass;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Member getMember() {
        return member;
    }

    public void setStatus(BookingStatus status) {
        validateStatus(status);
        this.status = status;
    }
}
