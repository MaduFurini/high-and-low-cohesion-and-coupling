package HighCohesion;

import java.util.Date;

public class DateFormatter {
    private String pattern;

    public void format(Date date) {
        System.out.println(
            "Formatting date..." +
            "\n" +
            "Date: " +
            date
        );
    }

    public void now() {
        System.out.println("Getting the current date...");
    }
}
