package ru.katin.kurs.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.katin.kurs.PensionApp;
import ru.katin.kurs.controller.recipient.RecipientTableItem;
import ru.katin.kurs.model.Recipient;
import ru.katin.kurs.repository.RecipientDao;
import ru.katin.kurs.services.RecipientService;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.List;

import static ru.katin.kurs.PensionApp.sceneManager;

public class RecipientController implements Initializable {

    @FXML
    private TableView<RecipientTableItem> recipientTable;

    @FXML
    private TableColumn<Recipient, Number> colSnils;

    @FXML
    private TableColumn<Recipient, String> colFio;

    @FXML
    private TableColumn<Recipient, LocalDate> colBirthDate;

    @FXML
    private TableColumn<Recipient, String> colAddress;

    @FXML
    private Button offButton;

    private List<Recipient> recipientList;
    private ObservableList<RecipientTableItem> recipientTableItemObservable;
    private final RecipientDao recipientDao = new RecipientDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSnils.setCellValueFactory(new PropertyValueFactory<>("snils"));
        colFio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birth_date"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        updateList();
    }

    @FXML
    void powerOffAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void addReceptionAction(ActionEvent event) {
        PensionApp.dialogManager.showDialogAddRecipient("recipient/add-edit-recipient-dialog.fxml",
                "Добавить получателя");

        updateList();
    }

    @FXML
    void deleteRecipientAction(ActionEvent event) {
        RecipientTableItem currentItem = recipientTable.getSelectionModel().getSelectedItem();
        int currentItemId = recipientTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление получателя");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getFio() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new RecipientService().delete(currentItem.getRecipient());
                recipientTable.getItems().remove(currentItemId);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void editRecipientAction(ActionEvent event) {
        RecipientTableItem currentItem = recipientTable.getSelectionModel().getSelectedItem();

        if (currentItem != null) {
            PensionApp.dialogManager.showDialogEditRecipient("recipient/add-edit-recipient-dialog.fxml",
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
    void updateRecipientAction(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        recipientList = new RecipientService().findAll();
        recipientTableItemObservable = FXCollections.observableArrayList();

        for (Recipient recipient : recipientList) {
            recipientTableItemObservable.add(new RecipientTableItem(recipient));
        }
        recipientTable.setItems(recipientTableItemObservable);
    }

    //==============
    // Button Scene
    //==============
    @FXML
    private void btnScenePensionAction(ActionEvent event) {
        sceneManager.switchTo("types_pensions/type_pension.fxml",
                "Виды Пенсий");
    }

    @FXML
    private void btnSceneRecipientsAction(ActionEvent event) {
        sceneManager.switchTo("recipient/recipient.fxml",
                "Получатели");
    }

    @FXML
    private void btnSceneAppointmentsAction(ActionEvent event) {
        sceneManager.switchTo("appointment/appointment.fxml",
                "Назначения");
    }

}
