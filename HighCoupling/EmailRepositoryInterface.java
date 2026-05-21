package HighCoupling;

public class EmailRepositoryInterface {
    public void send(Order order) {
        System.out.println(
            "Sending email..." +
            "\n" +
            "Order: " +
            order
        );
    }
}
