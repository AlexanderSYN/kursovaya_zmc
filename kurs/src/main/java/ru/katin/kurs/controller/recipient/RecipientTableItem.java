package ru.katin.kurs.controller.recipient;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.TypePension;

public class RecipientTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty conditions;
    private SimpleDoubleProperty base_size;
    private TypePension typePension;

    public RecipientTableItem(TypePension typePension) {
        this.name = new SimpleStringProperty(typePension.getName());
        this.conditions = new SimpleStringProperty(typePension.getConditions());
        this.base_size = new SimpleDoubleProperty(typePension.getBase_size());
        this.typePension = typePension;
    }


}
