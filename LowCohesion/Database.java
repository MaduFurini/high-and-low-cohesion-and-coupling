package LowCohesion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Database {
    private String host = "localhost";
    private int port = 3306;
    private Connection connection;
    private List<String> logHistory = new ArrayList<>();
    private String logFile = "C:\\logs\\erros.txt";
    private String smtpHost = "smtp.example.com";
    private String emailData = "dba@example.com";

    public void connect() {
        System.out.println("Connecting to the database...");
    }

    public void consult(String sql) {
        System.out.println(
            "Consulting data..." +
            "\n" +
            "SQL Query: " +
            sql
        );
    }

    public void saveLog(String msg) {
        System.out.println(
            "Saving log..." +
            "\n" +
            "Message: " +
            msg
        );
    }

    public void formatDate(Date date) {
        System.out.println(
            "Formatting date..." +
            "\n" +
            "Date: " +
            date
        );
    }

    public void sendAlert(String receiver) {
        System.out.println(
            "Sending alert..." +
            "\n" +
            "Receiver: " +
            receiver
        );
    }
}
