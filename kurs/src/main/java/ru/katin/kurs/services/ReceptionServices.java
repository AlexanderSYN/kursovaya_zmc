package ru.katin.kurs.services;

import ru.katin.kurs.model.Reception;
import ru.katin.kurs.repository.ReceptionsDao;

import java.util.List;

public class ReceptionServices {

    private ReceptionsDao receptionDao = new ReceptionsDao();

    public ReceptionServices() {
    }

    public List<Reception> findAll() {
        return receptionDao.findAll();
    }

    public Reception findOne(final long id) {
        return receptionDao.findOne(id);
    }

    public void save(final Reception entity)
    {
        if (entity == null)
            return;
        receptionDao.save(entity);
    }

    public void update(final Reception entity)
    {
        if (entity == null)
            return;
        receptionDao.update(entity);
    }
    public void delete(final Reception entity)
    {
        if (entity == null)
            return;
        receptionDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        receptionDao.deleteById(id);
    }
}