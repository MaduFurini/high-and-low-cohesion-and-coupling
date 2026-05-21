package HighCoupling;

public class SmtpEmail {
    public void send(Order order) {
        System.out.println(
            "Sending email..." +
            "\n" +
            "Order: " +
            order
        );
    }
}
