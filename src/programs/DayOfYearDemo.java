package programs;

import java.util.Arrays;
import java.util.Calendar;

public class DayOfYearDemo {
    public static void main(String[] args) {
        String s = "2019-01-09";

        Calendar calendar = Calendar.getInstance();
        int[] time = Arrays.stream(s.split("-")).mapToInt(t -> Integer.parseInt(t)).toArray();

        calendar.set(time[0], time[1] - 1, time[2]);

        System.out.println(calendar);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        System.out.println(dayOfYear);
    }
}
