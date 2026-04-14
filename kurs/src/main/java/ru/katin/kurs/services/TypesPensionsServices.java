package ru.katin.kurs.services;

import ru.katin.kurs.model.TypesPensions;
import ru.katin.kurs.repository.TypesPensionDao;
import java.util.List;

public class TypesPensionsServices {

    private TypesPensionDao typesPensionDao = new TypesPensionDao();

    public TypesPensionsServices() {
    }

    public List<TypesPensions> findAll() {
        return typesPensionDao.findAll();
    }

    public TypesPensions findOne(final long id) {
        return typesPensionDao.findOne(id);
    }

    public void save(final TypesPensions entity)
    {
        if (entity == null)
            return;
        typesPensionDao.save(entity);
    }

    public void update(final TypesPensions entity)
    {
        if (entity == null)
            return;
        typesPensionDao.update(entity);
    }
    public void delete(final TypesPensions entity)
    {
        if (entity == null)
            return;
        typesPensionDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        typesPensionDao.deleteById(id);
    }
}