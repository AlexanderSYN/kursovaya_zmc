package ru.katin.kurs.services;

import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.repository.RecipientDao;

import java.util.List;

public class RecipientService {

    private RecipientDao recipientDao = new RecipientDao();

    public RecipientService() {
    }

    public List<Recipient> findAll() {
        return recipientDao.findAll();
    }

    public Recipient findOne(final long id) {
        return recipientDao.findOne(id);
    }

    public void save(final Recipient entity)
    {
        if (entity == null)
            return;
        recipientDao.save(entity);
    }

    public void update(final Recipient entity)
    {
        if (entity == null)
            return;
        recipientDao.update(entity);
    }
    public void delete(final Recipient entity)
    {
        if (entity == null)
            return;
        recipientDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        recipientDao.deleteById(id);
    }
}