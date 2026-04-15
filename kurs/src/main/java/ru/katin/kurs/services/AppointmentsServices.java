package ru.katin.kurs.services;

import ru.katin.kurs.model.Appointments;
import ru.katin.kurs.repository.AppointmentsDao;

import java.util.List;

public class AppointmentsServices {

    private AppointmentsDao appointmentsDao = new AppointmentsDao();

    public AppointmentsServices() {
    }

    public List<Appointments> findAll() {
        return appointmentsDao.findAll();
    }

    public Appointments findOne(final long id) {
        return appointmentsDao.findOne(id);
    }

    public void save(final Appointments entity)
    {
        if (entity == null)
            return;
        appointmentsDao.save(entity);
    }

    public void update(final Appointments entity)
    {
        if (entity == null)
            return;
        appointmentsDao.update(entity);
    }
    public void delete(final Appointments entity)
    {
        if (entity == null)
            return;
        appointmentsDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        appointmentsDao.deleteById(id);
    }
}