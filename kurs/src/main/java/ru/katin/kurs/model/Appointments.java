package ru.katin.kurs.model;

import jakarta.persistence.*;
import javax.naming.spi.InitialContextFactory;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Appointments")
public class Appointments {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_pension")
    private String type_pension;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "size")
    private double size;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "user_id")
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_pension() {
        return type_pension;
    }

    public void setType_pension(String type_pension) {
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
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
                ", type_pension='" + type_pension + '\'' +
                ", recipient=" + recipient + '\'' +
                ", size=" + size +
                ", start_date= " + start_date +
                ", user_id=" + user_id +
                '}';
    }

}
