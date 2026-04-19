package ru.katin.kurs.controller.recipient;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.model.TypePension;

import java.time.LocalDate;

public class RecipientTableItem {
    private SimpleLongProperty snils;
    private SimpleStringProperty fio;
    private SimpleObjectProperty<LocalDate> birth_date;
    private SimpleStringProperty address;
    private Recipient recipient;

    public RecipientTableItem(Recipient recipient) {
        this.snils = new SimpleLongProperty(recipient.getSnils());
        this.fio = new SimpleStringProperty(recipient.getFio());
        this.birth_date = new SimpleObjectProperty<>(recipient.getBirthDate());
        this.address = new SimpleStringProperty(recipient.getAddress());
        this.recipient = recipient;
    }

    public double getSnils() {
        return snils.get();
    }

    public SimpleLongProperty snilsProperty() {
        return snils;
    }

    public void setSnils(long snils) {
        this.snils.set(snils);
    }

    public String getFio() {
        return fio.get();
    }

    public SimpleStringProperty fioProperty() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public LocalDate getBirth_date() {
        return birth_date.get();
    }

    public SimpleObjectProperty<LocalDate> birth_dateProperty() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date.set(birth_date);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }




}
