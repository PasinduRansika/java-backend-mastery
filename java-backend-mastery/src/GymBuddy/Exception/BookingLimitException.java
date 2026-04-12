package GymBuddy.Exception;

public class BookingLimitException extends RuntimeException{
    public BookingLimitException(String message){
        super(message);
    }
}
