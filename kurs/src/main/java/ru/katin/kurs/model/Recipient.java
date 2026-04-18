package ru.katin.kurs.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Reception")
public class Recipient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "snils")
    private int snils;

    @Column(name = "fio")
    private String fio;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "address")
    private String address;

    @Column(name = "user_id")
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSnils() {
        return snils;
    }

    public void setSnils(int snils) {
        this.snils = snils;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", snils='" + snils + '\'' +
                ", fio=" + fio + '\'' +
                ", birth_date=" + birth_date +
                ", address= " + address +
                ", user_id=" + user_id +
                '}';
    }


}
