package ru.katin.kurs.controller.appointments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.model.TypePension;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AppointmentTableItem {
    private SimpleStringProperty typePension;
    private SimpleStringProperty recipient;
    private SimpleDoubleProperty size;
    private SimpleObjectProperty<LocalDate> startDate;
    private Appointment appointment;

    public AppointmentTableItem(Appointment appointment) {
        this.typePension = new SimpleStringProperty(appointment.getTypePension());
        this.recipient = new SimpleStringProperty(appointment.getRecipient());
        this.size = new SimpleDoubleProperty(appointment.getSize());
        this.startDate = new SimpleObjectProperty<>(appointment.getStartDate());
        this.appointment = appointment;
    }


    public String getTypePension() {
        return typePension.get();
    }

    public SimpleStringProperty typePensionProperty() {
        return typePension;
    }

    public void setTypePension(String typePension) {
        this.typePension.set(typePension);
    }

    public String getRecipient() {
        return recipient.get();
    }

    public SimpleStringProperty recipientProperty() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient.set(recipient);
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public double getSize() {
        return size.get();
    }

    public SimpleDoubleProperty sizeProperty() {
        return size;
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
