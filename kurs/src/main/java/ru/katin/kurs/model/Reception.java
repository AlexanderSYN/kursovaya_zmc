package ru.katin.kurs.model;

import jakarta.persistence.*;
import javax.naming.spi.InitialContextFactory;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Reception")
public class Reception {
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
