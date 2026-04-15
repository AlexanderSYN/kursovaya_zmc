package ru.katin.kurs.controller.receptions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.katin.kurs.model.TypesPensions;
import ru.katin.kurs.services.TypesPensionsServices;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEditReception implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField conditionsField;
    @FXML
    private TextField baseSzField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button okButton;
    private Stage dialogStage;

    private TypesPensions typesPensions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void add() {
        try {
            typesPensions = new TypesPensions();

            typesPensions.setName(nameField.getText());
            typesPensions.setConditions(conditionsField.getText());
            typesPensions.setBase_size(Double.parseDouble(baseSzField.getText()));

            new TypesPensionsServices().save(typesPensions);
            ReceptionTableItem typesPensionTableItem = new ReceptionTableItem(typesPensions);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            typesPensions.setName(nameField.getText());
            typesPensions.setConditions(conditionsField.getText());
            typesPensions.setBase_size(Double.parseDouble(baseSzField.getText()));

            new TypesPensionsServices().update(typesPensions);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStage(Stage dialogStage, TypesPensions typesPensions) {
        this.typesPensions = typesPensions;
        this.dialogStage = dialogStage;

        nameField.setText(typesPensions.getName());
        conditionsField.setText(typesPensions.getConditions());
        baseSzField.setText(Double.toString(typesPensions.getBase_size()));
        okButton.setOnAction((www) -> edit());
    }
}

