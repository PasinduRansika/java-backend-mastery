package GymBuddy.Service;

import GymBuddy.Exception.BookingLimitException;
import GymBuddy.Exception.ClassFullException;
import GymBuddy.Exception.InvalidCancellationException;
import GymBuddy.Exception.MembershipExpiredException;

import GymBuddy.Model.Booking;
import GymBuddy.Model.BookingStatus;
import GymBuddy.Model.GymClass;
import GymBuddy.Model.Member;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingService {
    private int nextId = 1;

    public void bookClass(Member member, GymClass gymClass) {
        if (!member.getMembershipPlan().isActive()) {
            throw new MembershipExpiredException("You Cannot Book The Class!");
        }

        LocalDate weekStart = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate weekEnd = weekStart.plusDays(6);

        long weeklyCount = member.getBookings().stream()
                .filter(b -> {
                    LocalDate classDate = b.getCurrentClass().getDate();
                    return !classDate.isBefore(weekStart) && !classDate.isAfter(weekEnd);
                })
                .filter(b -> b.getStatus() == BookingStatus.CONFIRMED)
                .count();

        if (weeklyCount >= 2) {
            throw new BookingLimitException("You Have Already Exceeded Your Weekly Limit!");
        }

        if (gymClass.getCurrentBookings() >= gymClass.getMaximumCapacity()) {
            throw new ClassFullException("Class Is Full!");
        }

        Booking booking = new Booking(nextId++, gymClass, member);
        booking.setStatus(BookingStatus.CONFIRMED);
        member.addBooking(booking);
    }

    public void cancelClass(Booking booking) {
        LocalDateTime classDateTime = LocalDateTime.of(booking.getCurrentClass().getDate(), booking.getCurrentClass().getTime());

        if (LocalDateTime.now().isAfter(classDateTime.minusHours(24))) {
            throw new InvalidCancellationException("Cancellation Deadline Has Passed (24h rule) !");
        }

        booking.setStatus(BookingStatus.CANCELLED);
        booking.getCurrentClass().decrementBookings();
    }
}