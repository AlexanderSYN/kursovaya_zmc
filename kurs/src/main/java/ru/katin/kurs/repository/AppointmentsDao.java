package ru.katin.kurs.repository;

import ru.katin.kurs.model.Appointments;

public class AppointmentsDao extends BaseDao<Appointments> {
    public AppointmentsDao() {
        super(Appointments.class);
    }
}
