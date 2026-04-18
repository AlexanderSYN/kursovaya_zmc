package ru.katin.kurs.services;

import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.repository.AppointmentDao;

import java.util.List;

public class AppointmentService {

    private final AppointmentDao appointmentDao = new AppointmentDao();

    public AppointmentService() {
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    public Appointment findOne(final long id) {
        return appointmentDao.findOne(id);
    }

    public void save(final Appointment entity)
    {
        if (entity == null)
            return;
        appointmentDao.save(entity);
    }

    public void update(final Appointment entity)
    {
        if (entity == null)
            return;
        appointmentDao.update(entity);
    }
    public void delete(final Appointment entity)
    {
        if (entity == null)
            return;
        appointmentDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        appointmentDao.deleteById(id);
    }
}