package org.esq.toddrom.CivicGeo.Models.Forms;

import javax.persistence.Entity;


public enum UserAdminType {

    USER ("User"),
    BALLOT_ADMIN("Ballot_Admin"),
    SUPER_ADMIN("Super_Admin");

    private final String level;

    UserAdminType(String level) {this.level = level;}

    public String getLevel() { return level; }

}
