package ru.katin.kurs.controller.types_pensions;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.TypesPensions;

public class TypesPensionTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty conditions;
    private SimpleDoubleProperty base_size;
    private TypesPensions typesPensions;

    public TypesPensionTableItem(TypesPensions typesPensions) {
        this.name = new SimpleStringProperty(typesPensions.getName());
        this.conditions = new SimpleStringProperty(typesPensions.getConditions());
        this.base_size = new SimpleDoubleProperty(typesPensions.getBase_size());
        this.typesPensions = typesPensions;
    }


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getConditions() {
        return conditions.get();
    }

    public SimpleStringProperty conditionsProperty() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions.set(conditions);
    }

    public double getBase_size() {
        return base_size.get();
    }

    public SimpleDoubleProperty base_sizeProperty() {
        return base_size;
    }

    public void setBase_size(double base_size) {
        this.base_size.set(base_size);
    }

    public void setTypesPension(TypesPensions typesPensions) {
        this.typesPensions = typesPensions;
    }

    public TypesPensions getTypesPensions() {
        return typesPensions;
    }
}
