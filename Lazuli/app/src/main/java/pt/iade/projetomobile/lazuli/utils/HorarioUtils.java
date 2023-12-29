package pt.iade.projetomobile.lazuli.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class HorarioUtils {

    public static LocalDate selectDate;

    public static ArrayList<LocalDate> daysInMonthArray(LocalDate date) {
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = HorarioUtils.selectDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                daysInMonthArray.add(null);
            }
            else
            {
                daysInMonthArray.add(LocalDate.of(selectDate.getYear(), selectDate.getMonth(), i - dayOfWeek));
            }
        }
        return  daysInMonthArray;
    }

    public static String monthOfYear(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("pt", "PT"));
        return date.format(formatter);
    }

    public static ArrayList<LocalDate> daysInWeekArray(LocalDate selectDate) {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current = sundayForDate(selectDate);
        LocalDate endDate = current.plusWeeks(1);

        while(current.isBefore(endDate)){
            days.add(current);
            current.plusDays(1);
        }

        return days;
    }

    private static LocalDate sundayForDate(LocalDate current) {

        LocalDate oneWeekAgo = current.minusWeeks(1);

        while(current.isAfter(oneWeekAgo)){
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY)
                return current;
            current = current.minusDays(1);
        }
        return null;
    }

    public static String formattedDate(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("pt", "PT"));
        return date.format(formatter);
    }

    public static String formattedTime(LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return time.format(formatter);
    }



}
