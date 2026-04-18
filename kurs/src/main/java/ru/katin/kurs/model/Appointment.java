package ru.katin.kurs.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {


    @Column(name = "type_pension")
    private String type_pension;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "size")
    private double size;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePension() {
        return type_pension;
    }

    public void setTypePension(String type_pension) {
        this.type_pension = type_pension;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", type_pension='" + type_pension + '\'' +
                ", recipient=" + recipient + '\'' +
                ", size=" + size +
                ", start_date= " + start_date +
                '}';
    }

}
