package lecture6.FirstTask;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<DaysOfWeek, Integer> daysOfWeek = new HashMap<DaysOfWeek, Integer>(){{
            put(DaysOfWeek.MONDAY,1);
            put(DaysOfWeek.TUESDAY,2);
            put(DaysOfWeek.WEDNESDAY,3);
            put(DaysOfWeek.THURSDAY,4);
            put(DaysOfWeek.FRIDAY,5);
            put(DaysOfWeek.SATURDAY,6);
            put(DaysOfWeek.SUNDAY,7);
        }};

        System.out.println(DaysOfWeek.MONDAY);
        System.out.println(DaysOfWeek.TUESDAY);
        System.out.println(DaysOfWeek.WEDNESDAY);
        System.out.println(DaysOfWeek.THURSDAY);
        System.out.println(DaysOfWeek.FRIDAY);
        System.out.println(DaysOfWeek.SATURDAY);
        System.out.println(DaysOfWeek.SUNDAY);

        System.out.println("FRIDAY in this list is = " + DaysOfWeek.FRIDAY.ordinal() + "th.");

    }
}
