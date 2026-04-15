package GymBuddy;

import GymBuddy.Model.*;
import GymBuddy.Service.BookingService;
import GymBuddy.Service.MemberService;
import GymBuddy.Service.PaymentService;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        BookingService bookingService = new BookingService(memberService);
        PaymentService paymentService = new PaymentService();

        System.out.println("----------GymBuddy------------\n");

        //Register a Member
        try{
            Member member = new Member("Nimal Kalu", LocalDate.of(2000, 1, 1), "Gampaha", SchedulePreference.WEEKDAYS, 1);

            memberService.registerMember(member);
            System.out.println("Member Registered: " + member.getName());

            System.out.println("\n--- Test: Booking without Membership ---");

            Trainer trainer = new Trainer("Rex", 501,LocalDate.of(1988,2,21), "Colombo",SchedulePreference.BOTH,Specialization.CARDIO);

            GymClass yoga = new GymClass(9001,ClassTypes.CARDIO, LocalDate.now().plusDays(2), LocalTime.now(),20,trainer);

            // Trying to book before pay
            try {
                bookingService.bookClass(member.getMemberId(), yoga);
            } catch (Exception e) {
                System.out.println("Expected Error: " + e.getMessage());
            }

            System.out.println("\n--- Test: Booking with Membership ---");

            //Process Payment & Booking
            paymentService.paymentProcess(member,MembershipType.BASIC);
            System.out.println("Membership Status: " + (member.getMembershipPlan().isActive() ? "ACTIVE" : "INACTIVE"));

            try {
                bookingService.bookClass(member.getMemberId(), yoga);
                System.out.println("Booking Confirmed For: " + yoga.getClassType());

            } catch (Exception e) {
                System.out.println("Expected Error: " + e.getMessage());
            }

            System.out.println("\n--- Test: GymClass Date Validation ---");
            try {
                //Trying to schedule for today
                GymClass invalidClass = new GymClass(50, ClassTypes.HIIT, LocalDate.now(), LocalTime.now(), 10, trainer);
            } catch (IllegalArgumentException e) {
                System.out.println("Expected Error : " + e.getMessage());
            }


            System.out.println("\n**** Final Summary ****");
            System.out.println("Member: " + member.getName());
            System.out.println("Total Bookings: " + member.getBookings().size());
            System.out.println("Payment Records in System: " + paymentService.getPaymentHistory().size());

        } catch (Exception e) {
            System.err.println("Unexpected System Error: " + e.getMessage());
        }
    }
}