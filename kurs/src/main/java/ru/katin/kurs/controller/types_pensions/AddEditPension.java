package ru.katin.kurs.controller.types_pensions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.katin.kurs.model.TypePension;
import ru.katin.kurs.services.TypePensionService;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEditPension implements Initializable {
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

    private TypePension typePension;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void add() {
        try {
            typePension = new TypePension();

            typePension.setName(nameField.getText());
            typePension.setConditions(conditionsField.getText());
            typePension.setBaseSize(Double.parseDouble(baseSzField.getText()));

            new TypePensionService().save(typePension);
            TypePensionTableItem typePensionTableItem = new TypePensionTableItem(typePension);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            typePension.setName(nameField.getText());
            typePension.setConditions(conditionsField.getText());
            typePension.setBaseSize(Double.parseDouble(baseSzField.getText()));

            new TypePensionService().update(typePension);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStagePension(Stage dialogStage, TypePension typePension) {
        this.typePension = typePension;
        this.dialogStage = dialogStage;

        nameField.setText(typePension.getName());
        conditionsField.setText(typePension.getConditions());
        baseSzField.setText(Double.toString(typePension.getBaseSize()));
        okButton.setOnAction((www) -> edit());
    }
}

