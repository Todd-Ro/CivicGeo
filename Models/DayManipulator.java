package org.esq.toddrom.CivicGeo.Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayManipulator {

    public static boolean isLeap(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static int daysBeforeMonth(int month) {
        if (month==0) {
            return 0;
        }
        else if (month == 1) {
            return 31;
        }
        else if (month == 2) {
            return 59;
        }
        else if (month == 3) {
            return 90;
        }
        else if (month == 4) {
            return 120;
        }
        else if (month == 5) {
            return 151;
        }
        else if (month == 6) {
            return 181;
        }
        else if (month == 7) {
            return 212;
        }
        else if (month == 8) {
            return 243;
        }
        else if (month == 9) {
            return 273;
        }
        else if (month == 10) {
            return 304;
        }
        else if (month == 11) {
            return 334;
        }
        else if (month >= 12) {
            return 365 + daysBeforeMonth(month - 12);
        }
        else if (month < 0) {
            return daysBeforeMonth(month + 12) - 365;
        }
        else {
            return 0;
        }
    }

    public static Integer dayIndex(GregorianCalendar date) {
        /*try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date x = simpleDateFormat.parse("2018-05-27");
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
        int yearsSince1600 = year - 1600;
        boolean inLeap = isLeap(year);
        int leapYearsSince1600 = (yearsSince1600 / 4) - (yearsSince1600 / 100) + (yearsSince1600 / 400) + 1;
        boolean beforeLeap = (month < 2);
        int subtract;
        if(inLeap&&beforeLeap) {
            subtract = 1;
        }
        else {
            subtract = 0;
        }
        return yearsSince1600*365 + daysBeforeMonth(month) + dayOfMonth + leapYearsSince1600 - subtract;
    }

    public static Boolean isTuesday(GregorianCalendar date) {
        if (daysSinceTuesday(date) == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int daysSinceTuesday(GregorianCalendar date) {
        GregorianCalendar nixon = new GregorianCalendar(1972, 10, 7);
        int ret = ((dayIndex(date) % 7) - (dayIndex(nixon) % 7));
        if (ret<0) {
            ret += 7;
        }
        return ret;
    }

    //365*3 + 366 = 1461; 1461 % 7 = 5; 1461 = 7 * 208 + 5
    public static GregorianCalendar fourYearsLaterSameDayOfWeek(GregorianCalendar earlierDate,
                                                                int firstAllowedDayOfMonth) {
        int earlyYear = earlierDate.get(Calendar.YEAR);
        int laterYear = earlyYear + 4;
        int earlierDayOfMonth = earlierDate.get(Calendar.DAY_OF_MONTH);
        int modOffset = 5;
        if(laterYear / 100 > earlyYear / 100) {
            if(laterYear / 400 == earlyYear / 400) {
                modOffset -= 1;
            }
        }
        int daysUntilSameDayOfWeek = (7 - modOffset) % 7;
        int fourYearLaterDOM = earlierDayOfMonth + daysUntilSameDayOfWeek;
        if (fourYearLaterDOM > firstAllowedDayOfMonth + 6) {
            fourYearLaterDOM -= 7;
        }
        return new GregorianCalendar(laterYear, earlierDate.get(Calendar.MONTH), fourYearLaterDOM);
    }

    public static GregorianCalendar yearsLaterSameDayOfWeek(GregorianCalendar earlierDate,
                                                            int firstAllowedDayOfMonth, int years) {
        int earlyYear = earlierDate.get(Calendar.YEAR);
        int laterYear = earlyYear + years;
        int earlierDayOfMonth = earlierDate.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar sameDayLaterYear = new GregorianCalendar(laterYear, earlierDate.get(Calendar.MONTH), earlierDayOfMonth);
        int modOffset = daysSinceTuesday(sameDayLaterYear) - daysSinceTuesday(earlierDate);
        int daysUntilSameDayOfWeek = (7 - modOffset) % 7;
        int fourYearLaterDOM = earlierDayOfMonth + daysUntilSameDayOfWeek;
        if (fourYearLaterDOM > firstAllowedDayOfMonth + 6) {
            fourYearLaterDOM -= 7;
        }
        return new GregorianCalendar(laterYear, earlierDate.get(Calendar.MONTH), fourYearLaterDOM);
    }
}
