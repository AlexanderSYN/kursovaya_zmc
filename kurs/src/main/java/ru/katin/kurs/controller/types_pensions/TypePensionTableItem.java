package ru.katin.kurs.controller.types_pensions;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.katin.kurs.model.TypePension;

public class TypePensionTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty conditions;
    private SimpleDoubleProperty base_size;
    private TypePension typePension;

    public TypePensionTableItem(TypePension typePension) {
        this.name = new SimpleStringProperty(typePension.getName());
        this.conditions = new SimpleStringProperty(typePension.getConditions());
        this.base_size = new SimpleDoubleProperty(typePension.getBase_size());
        this.typePension = typePension;
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

    public void setTypesPension(TypePension typePension) {
        this.typePension = typePension;
    }

    public TypePension getTypesPensions() {
        return typePension;
    }
}
