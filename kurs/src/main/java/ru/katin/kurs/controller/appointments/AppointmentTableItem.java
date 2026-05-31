package ru.katin.kurs.controller.appointments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import ru.katin.kurs.model.Appointment;

import java.time.LocalDate;

public class AppointmentTableItem {
    private SimpleObjectProperty typePension;
    private SimpleObjectProperty recipient;
    private SimpleDoubleProperty size;
    private SimpleObjectProperty<LocalDate> startDate;
    private Appointment appointment;

    public AppointmentTableItem(Appointment appointment) {
        this.typePension = new SimpleObjectProperty<>(appointment.getTypePension());
        this.recipient = new SimpleObjectProperty<>(appointment.getRecipient());
        this.size = new SimpleDoubleProperty(appointment.getSize());
        this.startDate = new SimpleObjectProperty<>(appointment.getStartDate());
        this.appointment = appointment;
    }

    public String getTypePension() {
        return typePension.get().toString();
    }

    public SimpleObjectProperty typePensionProperty() {
        return typePension;
    }

    public void setTypePension(Object typePension) {
        this.typePension.set(typePension);
    }

    public String getRecipient() {
        return recipient.get().toString();
    }

    public SimpleObjectProperty recipientProperty() {
        return recipient;
    }

    public void setRecipient(Object recipient) {
        this.recipient.set(recipient);
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

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}
