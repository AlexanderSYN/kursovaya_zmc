module ru.katin.kurs {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    requires jakarta.validation;
    requires javafx.graphics;

    opens ru.katin.kurs to javafx.fxml;
    opens ru.katin.kurs.model to org.hibernate.orm.core, javafx.base;
    exports ru.katin.kurs;
    exports ru.katin.kurs.controller;
    opens ru.katin.kurs.controller to javafx.fxml;
    opens ru.katin.kurs.util to org.hibernate.orm.core;

    exports ru.katin.kurs.controller.types_pensions;
    opens ru.katin.kurs.controller.types_pensions to javafx.fxml;

    exports ru.katin.kurs.controller.appointments;
    opens ru.katin.kurs.controller.appointments to javafx.base, javafx.fxml;
}