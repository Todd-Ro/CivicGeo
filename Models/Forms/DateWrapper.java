package org.esq.toddrom.CivicGeo.Models.Forms;

import org.esq.toddrom.CivicGeo.Models.DayManipulator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DateWrapper {

    @Id
    @GeneratedValue
    private int id;

    Date wrappedDate;

    public DateWrapper(Date d) {
        this.wrappedDate = d;
    }

    GregorianCalendar wrappedCalendar;

    public DateWrapper(GregorianCalendar c) {
        this.wrappedCalendar = c;
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.daysSinceTuesday = DayManipulator.daysSinceTuesday(c);
    }

    int year;
    int month;
    int day;
    int daysSinceTuesday;


    public DateWrapper() { }

    public DateWrapper(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.day = dayOfMonth;
        wrappedCalendar = new GregorianCalendar(year, month, dayOfMonth);
        this.wrappedCalendar = wrappedCalendar;
        this.daysSinceTuesday = DayManipulator.daysSinceTuesday(wrappedCalendar);
    }


    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWrappedDate() {
        return wrappedDate;
    }

    public void setWrappedDate(Date wrappedDate) {
        this.wrappedDate = wrappedDate;
    }

    public GregorianCalendar getWrappedCalendar() {
        return wrappedCalendar;
    }

    public void setWrappedCalendar(GregorianCalendar wrappedCalendar) {
        this.wrappedCalendar = wrappedCalendar;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDaysSinceTuesday() {
        return daysSinceTuesday;
    }

    public void setDaysSinceTuesday(int daysSinceTuesday) {
        this.daysSinceTuesday = daysSinceTuesday;
    }
}
