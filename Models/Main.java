package org.esq.toddrom.CivicGeo.Models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.esq.toddrom.CivicGeo.Models.DayManipulator.isTuesday;
//import org.esq.toddrom.CivicGeo.Models.Data.countylist.txt;

public class Main {

    public static void main(String[] args) {
        /*BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(org.esq.toddrom.CivicGeo.Models.Data.CountyList.txt)));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                // process line
            }
        } finally {
            br.close();
        }*/

        /*GregorianCalendar start = new GregorianCalendar(1600, 0, 1); // Should be 1
        GregorianCalendar newMil = new GregorianCalendar(2000, 0, 1); // Should be 146098
        System.out.println(dayIndex(start));
        System.out.println(dayIndex(newMil));*/
        GregorianCalendar may = new GregorianCalendar(2018, 4, 29);
        System.out.println(isTuesday(may)); // Should be true
    }



}
