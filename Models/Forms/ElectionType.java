package org.esq.toddrom.CivicGeo.Models.Forms;

public enum ElectionType {

    NATIONAL ("National"),
    NATPRIMARY ("Natprimary"),
    PRESPRIMARY ("Presprimary"),
    MUNICIPAL ("Municipal"),
    OTHER ("Other");

    private final String name;

    ElectionType(String name) {this.name = name; }

    public String getName() { return name; }

}
