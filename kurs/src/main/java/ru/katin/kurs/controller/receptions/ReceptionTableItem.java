package ru.katin.kurs.controller.receptions;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.TypesPensions;

public class ReceptionTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty conditions;
    private SimpleDoubleProperty base_size;
    private TypesPensions typesPensions;

    public ReceptionTableItem(TypesPensions typesPensions) {
        this.name = new SimpleStringProperty(typesPensions.getName());
        this.conditions = new SimpleStringProperty(typesPensions.getConditions());
        this.base_size = new SimpleDoubleProperty(typesPensions.getBase_size());
        this.typesPensions = typesPensions;
    }


}
