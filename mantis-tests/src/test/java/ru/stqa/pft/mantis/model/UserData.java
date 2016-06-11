package ru.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ilugovova on 02.06.2016.
 */

@Entity
@Table(name="mantis_user_table")
public class UserData {

    @Id
    private int id;

    @Column(name="username")
    private String userName;

    @Column(name="email")
    private String email;

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
