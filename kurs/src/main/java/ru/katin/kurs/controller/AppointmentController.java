package ru.katin.kurs.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;
import ru.katin.kurs.PensionApp;
import ru.katin.kurs.controller.appointments.AppointmentTableItem;
import ru.katin.kurs.model.Appointment;
import ru.katin.kurs.repository.AppointmentDao;
import ru.katin.kurs.services.AppointmentService;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static ru.katin.kurs.PensionApp.sceneManager;

public class AppointmentController implements Initializable {

    @FXML
    private TableView<AppointmentTableItem> appointmentTable;

    @FXML
    private TableColumn<Appointment, String> colRecipient;

    @FXML
    private TableColumn<Appointment, Number> colSize;

    @FXML
    private TableColumn<Appointment, LocalDate> colStartDate;

    @FXML
    private TableColumn<Appointment, String> colTypePension;

    private List<Appointment> appointmentList;
    private ObservableList<AppointmentTableItem> appointmentTableItemObservableList;
    private final AppointmentDao appointmentDao = new AppointmentDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRecipient.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colTypePension.setCellValueFactory(new PropertyValueFactory<>("typePension"));
    }

    @FXML
    void addAppointmentAction(ActionEvent event) {
        sceneManager.showDialogAddAppointment("appointment/add-edit-appointment-dialog.fxml",
                "Добавление Назначения");
        updateList();
    }

    @FXML
    void editAppointmentAction(ActionEvent event) {
        AppointmentTableItem currentItem = appointmentTable.getSelectionModel().getSelectedItem();

        if (currentItem != null) {
            sceneManager.showDialogEditAppointment("appointment/add-edit-appointment-dialog.fxml",
                    "Изменить", currentItem);
            updateList();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }


    @FXML
    void deleteAppointmentAction(ActionEvent event) {
        AppointmentTableItem currentItem = appointmentTable.getSelectionModel().getSelectedItem();
        int currentItemId = appointmentTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getAppointment() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new AppointmentService().delete(currentItem.getAppointment());
                appointmentTable.getItems().remove(currentItemId);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void powerOffAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void updateAppointmentAction(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        appointmentList = new AppointmentService().findAll();
        appointmentTableItemObservableList = FXCollections.observableArrayList();

        for (Appointment apnt : appointmentList) {
            appointmentTableItemObservableList.add(new AppointmentTableItem(apnt));
        }

        appointmentTable.setItems(appointmentTableItemObservableList);
    }



    //==============
    // Button Scene
    //==============
    @FXML
    private void btnScenePensionAction(ActionEvent event) {
        sceneManager.switchTo("types_pensions/type_pension.fxml",
                "Пенсия");
    }

    @FXML
    private void btnSceneRecipientsAction(ActionEvent event) {
        //
    }

    @FXML
    private void btnSceneAppointmentsAction(ActionEvent event) {
        sceneManager.switchTo("appointment/appointment.fxml",
                "Назначения");
    }

}
