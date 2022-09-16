/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.friendsbirthday.elements;

import java.time.LocalDate;

/**
 *
 * @author educacion
 */
public class Friend {
    private long id;
    private String email;
    private String name;
    private LocalDate birthday;

    public Friend(long id, String email, String name, LocalDate birthday) {
        this(email, name, birthday);
        this.id = id;
    }

    public Friend(String email, String name, LocalDate birthday) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
