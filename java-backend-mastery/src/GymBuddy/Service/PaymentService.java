package GymBuddy.Service;

import GymBuddy.Model.Member;
import GymBuddy.Model.Membership;
import GymBuddy.Model.MembershipType;
import GymBuddy.Model.PaymentRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentService {
    private int transactionCounter = 1000;
    private int membershipCounter = 5000;

    private final List<PaymentRecord> paymentRecords = new ArrayList<>();

    public void paymentProcess(Member member, MembershipType membershipType) {
        if (member.getMembershipPlan() != null && member.getMembershipPlan().isActive()) {
            throw new IllegalArgumentException("You already have an active membership!");
        }

        PaymentRecord paymentRecord = new PaymentRecord(transactionCounter++, membershipType.getPrice(), LocalDate.now(), member.getMemberId());
        paymentRecords.add(paymentRecord);

        if (member.getMembershipPlan() == null) {
            Membership newMembership = new Membership(membershipCounter++, membershipType, LocalDate.now());
            member.setMembershipPlan(newMembership);
        } else {
            member.getMembershipPlan().setMembershipDetails(membershipType, LocalDate.now());
        }

        System.out.println("Payment Successful: " + paymentRecord);
    }

    public List<PaymentRecord> getPaymentHistory() {
        return Collections.unmodifiableList(paymentRecords);
    }
}

