package ru.katin.kurs.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import ru.katin.kurs.model.TypePension;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_pension")
    private TypePension typePension;

    @ManyToOne
    @JoinColumn(name = "recipients")
    private Recipient recipient;

    @Column(name = "size")
    private double size;

    @Column(name = "start_date")
    private LocalDate start_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePension getTypePension() {
        return typePension;
    }

    public void setTypePension(TypePension type_pension) {
        this.typePension = type_pension;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
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
                ", type_pension='" + typePension + '\'' +
                ", recipient=" + recipient + '\'' +
                ", size=" + size +
                ", start_date= " + start_date +
                '}';
    }
}
