package GymBuddy.Model;

import java.time.LocalDate;
import java.util.*;

public class PaymentRecord {
    private int transactionId;
    private double amount;
    private LocalDate date;
    private int memberId;

    public PaymentRecord(int transactionId, double amount, LocalDate date, int memberId) {
        validateId(transactionId);
        this.transactionId = transactionId;

        validateAmount(amount);
        this.amount = amount;

        validateDate(date);
        this.date = date;

        validateId(memberId);
        this.memberId = memberId;
    }

    private void validateId(int id){
        if(id <= 0) throw new IllegalArgumentException("ID Cannot Be Negative !");
    }

    private void validateAmount(double amount){
        if(amount <= 0) throw new IllegalArgumentException("Amount Cannot Be Negative !");
    }

    private void validateDate(LocalDate date){
        Objects.requireNonNull(date, "Date Cannot Be Null !");
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "PaymentRecord{" + "Id=" + transactionId + "|  memberId=" + memberId +
                " | amount=" + amount + " | date=" + date + '}' ;
    }
}
