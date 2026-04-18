package ru.katin.kurs.repository;

import ru.katin.kurs.model.Appointment;

public class AppointmentDao extends BaseDao<Appointment> {
    public AppointmentDao() {
        super(Appointment.class);
    }
}
