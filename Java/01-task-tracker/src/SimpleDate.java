import java.time.LocalDateTime;

public class SimpleDate {
    final private int year;
    final private int month;
    final private int day;
    final private int hour;
    final private int minute;
    final private int second;

    public SimpleDate(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public SimpleDate() {
        this(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
    }
    public SimpleDate(String dateString) {
        // Zakładamy format: "YYYY-MM-DD HH:MM:SS"
        String[] dateTimeParts = dateString.split(" ");
        String[] dateParts = dateTimeParts[0].split("-");
        String[] timeParts = dateTimeParts[1].split(":");

        this.year = Integer.parseInt(dateParts[0]);
        this.month = Integer.parseInt(dateParts[1]);
        this.day = Integer.parseInt(dateParts[2]);

        this.hour = Integer.parseInt(timeParts[0]);
        this.minute = Integer.parseInt(timeParts[1]);
        this.second = Integer.parseInt(timeParts[2]);
    }

    @Override
    public String toString() {
        String z = "0";
        return year + "-" + (month < 10 ? z+month : month) + "-" + (day < 10 ? z+day : day) + " " + (hour < 10 ? z+hour : hour) + ":" + (minute < 10 ? z+minute : minute) + ":" + (second < 10 ? z+second : second);
    }



}
