package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private String birthday;

    public User() {
    }

    public User(String name, String surname, String password, String birthday) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
    }

    public User(long id, String name, String surname, String password, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + password + " " + birthday;
    }
}
