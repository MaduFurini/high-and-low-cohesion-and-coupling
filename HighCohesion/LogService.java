package HighCohesion;

import java.util.List;

public class LogService {
    private String file;
    private List<String> history;

    public void saveLog(String msg) {
        System.out.println(
            "Saving log..." +
            "\n" +
            "Message: " +
            msg
        );
    }

    public void getHistory() {
        System.out.println("Getting log history...");
    }
}
