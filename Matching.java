package org.esq.toddrom.CivicGeo;

import java.util.HashMap;

public class Matching {

    public static int MatchCircuit(String County) {
        if(County.equals("Jackson")) {
            return 16;
        }
        else {
            return 22;
        }
    }

    public HashMap<String, Object[]> Counties = new HashMap<String, Object[]>();

}