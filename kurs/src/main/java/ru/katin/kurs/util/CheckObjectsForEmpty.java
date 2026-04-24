package ru.katin.kurs.util;

import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Date;

import static ru.katin.kurs.util.AlertManager.errorAlert;

public class CheckObjectsForEmpty {

    public static boolean isEmptyComboBox(ComboBox comboBox) {
        return comboBox.getValue() == null;
    }

    public static boolean isEmptyTextField(TextField textField) {
        return textField.getText().isEmpty();
    }

    public static boolean isEmptyDate(DatePicker datePicker) {
        return datePicker.getValue() == null;
    }

    private static boolean showError(Label errorLabel, String message) {
        errorAlert("Ошибка", message, null);
        errorLabel.setText(message);
        return true;
    }

    public static boolean validateAppointmentFields(
            Label errorLabel,
            ComboBox<?> typePensionComboBox,
            ComboBox<?> recipientComboBox,
            TextField sizeField,
            DatePicker startDatePicker
    ) {
        if (isEmptyComboBox(typePensionComboBox))
            return showError(errorLabel, "вы забыли выбрать Тип пенсии");

        if (isEmptyComboBox(recipientComboBox))
            return showError(errorLabel, "вы забыли выбрать получателя");

        if (isEmptyTextField(sizeField))
            return showError(errorLabel, "вы забыли ввести размер");

        if (isEmptyDate(startDatePicker))
            return showError(errorLabel, "вы забыли выбрать дату");

        return false;
    }

    public static boolean validateRecipientFields(
            Label errorLabel,
            TextField snilsField,
            TextField fioField,
            TextField addressField,
            DatePicker birthDate
    ) {
        if (isEmptyTextField(snilsField))
            return showError(errorLabel, "вы забыли ввести снилс");

        if (isEmptyTextField(fioField))
            return showError(errorLabel, "вы забыли ввести ФИО");

        if (isEmptyTextField(addressField))
            return showError(errorLabel, "вы забыли ввести адрес");

        if (isEmptyDate(birthDate))
            showError(errorLabel, "вы забыли выбрать дату");

        return false;
    }


    public static boolean validateTypePensionFields(
            Label errorLabel,
            TextField name,
            TextField condition,
            TextField baseSize
    ) {
        if (isEmptyTextField(name))
            return showError(errorLabel, "вы забыли ввести название");

        if (isEmptyTextField(condition))
            return showError(errorLabel, "вы забыли ввести случай");

        if (isEmptyTextField(baseSize))
            return showError(errorLabel, "вы ввести базовый размер");

        return false;
    }
}
