package GymBuddy.Model;

public enum MembershipType {
    BASIC(2000),
    PREMIUM(3000),
    ANNUAL(30000);

    private final double price;

    MembershipType(double price) {
        this.price = price; }

    public double getPrice() {
        return price; }
}
