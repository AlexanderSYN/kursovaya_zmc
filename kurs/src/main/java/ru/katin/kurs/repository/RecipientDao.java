package ru.katin.kurs.repository;

import ru.katin.kurs.model.Recipient;

public class RecipientDao extends BaseDao<Recipient> {
    public RecipientDao() {
        super(Recipient.class);
    }
}
