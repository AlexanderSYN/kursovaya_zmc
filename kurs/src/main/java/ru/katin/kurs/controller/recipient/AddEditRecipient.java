package ru.katin.kurs.controller.recipient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.katin.kurs.controller.RecipientController;
import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.services.RecipientService;
import ru.katin.kurs.util.AlertManager;

import java.net.URL;
import java.util.ResourceBundle;

import static ru.katin.kurs.PensionApp.dialogManager;

public class AddEditRecipient implements Initializable {

    @FXML
    private TextField addressField;

    @FXML
    private DatePicker birthDateComboBox;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField fioField;

    @FXML
    private Button okButton;

    @FXML
    private TextField snilsField;

    private Stage dialogStage;

    private Recipient recipient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void add() {
        try {
            long snils = Long.parseLong(snilsField.getText());

            recipient = new Recipient();

            if (String.valueOf(snils).length() == 11)
                recipient.setSnils(snils);
            else {
                AlertManager.errorAlert("Ошибка",
                        "Неверно записан снилс", "введите 11 цифр в снилсе");
                return;
            }
            recipient.setFio(fioField.getText());
            recipient.setAddress(addressField.getText());
            recipient.setBirthDate(birthDateComboBox.getValue());

            new RecipientService().save(recipient);
            RecipientTableItem recipientTableItem =
                    new RecipientTableItem(recipient);

            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
            AlertManager.preparedErrorAlertException("Ошибка добавления", e);
        }
    }

    void edit() {
        try {
            recipient.setSnils(Long.parseLong(snilsField.getText()));
            recipient.setFio(fioField.getText());
            recipient.setAddress(addressField.getText());
            recipient.setBirthDate(birthDateComboBox.getValue());

            new RecipientService().update(recipient);

            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStageAppointment(Stage dialogStage, Recipient recipient) {
        this.recipient = recipient;
        this.dialogStage = dialogStage;

        snilsField.setText(String.valueOf(recipient.getSnils()));
        fioField.setText(recipient.getFio());
        birthDateComboBox.setValue(recipient.getBirthDate());
        addressField.setText(recipient.getAddress());

        okButton.setOnAction((www) -> edit());
    }
}
