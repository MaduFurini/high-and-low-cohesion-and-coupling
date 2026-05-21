package HighCohesion;

public class EmailService {
    private String smtp;
    private String sender;

    public void sendAlert(String receiver) {
        System.out.println(
            "Sending alert..." +
            "\n" +
            "Receiver: " +
            receiver
        );
    }
}
