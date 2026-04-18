package ru.katin.kurs.controller.recipient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.model.TypePension;

import java.net.URL;
import java.util.ResourceBundle;

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

    private TypePension typePension;
    private Appointment appointment;
    private Recipient recipient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void add() {

    }
}
