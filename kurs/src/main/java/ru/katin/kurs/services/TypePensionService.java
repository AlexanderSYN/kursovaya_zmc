package ru.katin.kurs.services;

import ru.katin.kurs.model.TypePension;
import ru.katin.kurs.repository.TypePensionDao;
import java.util.List;

public class TypePensionService {

    private TypePensionDao typePensionDao = new TypePensionDao();

    public TypePensionService() {
    }

    public List<TypePension> findAll() {
        return typePensionDao.findAll();
    }

    public TypePension findOne(final long id) {
        return typePensionDao.findOne(id);
    }

    public void save(final TypePension entity)
    {
        if (entity == null)
            return;
        typePensionDao.save(entity);
    }

    public void update(final TypePension entity)
    {
        if (entity == null)
            return;
        typePensionDao.update(entity);
    }
    public void delete(final TypePension entity)
    {
        if (entity == null)
            return;
        typePensionDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        typePensionDao.deleteById(id);
    }
}