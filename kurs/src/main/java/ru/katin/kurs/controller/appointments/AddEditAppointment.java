package ru.katin.kurs.controller.appointments;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.model.TypePension;
import ru.katin.kurs.services.AppointmentService;
import ru.katin.kurs.services.RecipientService;
import ru.katin.kurs.services.TypePensionService;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddEditAppointment implements Initializable {

    @FXML
    private Label errorLabel;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<String> recipientComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private TextField sizeField;

    @FXML
    private ComboBox<String> typePensionComboBox;

    private Stage dialogStage;

    private Appointment appointment;
    private TypePension typePension;
    private Recipient recipient;

    List<TypePension> allPension = new TypePensionService().findAll();
    //List<Recipient> allRecipient = new RecipientService().findAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // инициализация combo box typePension
        for (TypePension pensions : allPension)
            typePensionComboBox.getItems().addAll(pensions.getName());

//        // инициализация combo box recipient
//        for (Recipient recip : allRecipient)
//            recipientComboBox.getItems().addAll(recip.getFio());

    }

    private void add() {
        try {
            appointment = new Appointment();

            //String selectedRecipient = recipientComboBox.getValue();
            String selectedTypePension = typePensionComboBox.getValue();

            appointment.setTypePension(selectedTypePension);
            //appointment.setRecipient(selectedRecipient);
            appointment.setRecipient("123");
            appointment.setSize(Double.parseDouble(sizeField.getText()));
            appointment.setStartDate(startDatePicker.getValue());

            new AppointmentService().save(appointment);
            AppointmentTableItem appointmentTableItem =
                    new AppointmentTableItem(appointment);

            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            String selectedTypePension = typePensionComboBox.getValue();

            appointment.setTypePension(typePensionComboBox.getValue());
            //appointment.setRecipient(recipientComboBox.getValue());
            appointment.setRecipient("test");
            appointment.setSize(Double.parseDouble(sizeField.getText()));
            appointment.setStartDate(startDatePicker.getValue());

            new AppointmentService().update(appointment);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStageAppointment(Stage dialogStage, Appointment appointment) {
        this.appointment = appointment;
        this.dialogStage = dialogStage;

        typePensionComboBox.getSelectionModel().select(appointment.getTypePension());
        recipientComboBox.getSelectionModel().select(appointment.getRecipient());
        sizeField.setText(String.valueOf(appointment.getSize()));
        startDatePicker.setValue(appointment.getStartDate());

        okButton.setOnAction((www) -> edit());
    }


}
