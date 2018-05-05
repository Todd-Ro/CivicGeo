package org.esq.toddrom.CivicGeo.Models.Forms;

import org.hibernate.validator.constraints.Email;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User {

    static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private Date date;
    private String dateString;

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @Email
    private String email;

    private UserAdminType adminType;

    @NotNull
    @Size(min=6, message = "Password should have at least 6 characters")
    private String password;

    public User() { }

    public User(String name, String email) {
        this.name = name;
        this.email=email;
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
    }



    //Getters and Setters

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(UserAdminType adminType) {
        this.adminType = adminType;
    }

    public void setAdminType(String adminLevelString) {
        this.adminType = UserAdminType.valueOf(adminLevelString);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
