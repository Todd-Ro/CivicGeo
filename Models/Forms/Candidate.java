package org.esq.toddrom.CivicGeo.Models.Forms;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Candidate {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String office;

    @Size(max=127, message = "Party name must not exceed 127 characters")
    private String party;

    private int election_year;

    private double ordering_priority;

    private ElectionType election_type;



    public Candidate() { }

    public Candidate (String name, String office, String party) {
        this.name = name;
        this.office = office;
        this.party = party;
    }

    public Candidate (String name, String office, String party, int election_year) {
        this.name = name;
        this.office = office;
        this.party = party;
        this.election_year = election_year;
    }


    //Getters and setters

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    } //We don't want the Id to be edited outside this class

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getElection_year() {
        return election_year;
    }

    public void setElection_year(int election_year) {
        this.election_year = election_year;
    }

    public double getOrdering_priority() {
        return ordering_priority;
    }

    public void setOrdering_priority(double ordering_priority) {
        this.ordering_priority = ordering_priority;
    }

    public ElectionType getElection_type() {
        return election_type;
    }

    public void setElection_type(ElectionType election_type) {
        this.election_type = election_type;
    }
}
