package org.esq.toddrom.CivicGeo.Models.Data;

import java.util.ArrayList;
import java.util.Date;

public class DateList {

    static ArrayList<Date> masterDateList;

    public static void masterAdd(Date d) {
        masterDateList.add(d);
    }

    ArrayList<Date> theseDates;

    public void add(Date d) {
        theseDates.add(d);
    }

}
