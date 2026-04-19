package ru.katin.kurs.controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.katin.kurs.PensionApp;
import ru.katin.kurs.controller.types_pensions.TypePensionTableItem;
import ru.katin.kurs.model.TypePension;
import ru.katin.kurs.repository.TypePensionDao;
import ru.katin.kurs.services.TypePensionService;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static ru.katin.kurs.PensionApp.sceneManager;

public class TypePensionController implements Initializable {

    @FXML
    private TableView<TypePensionTableItem> pensionTable;
    @FXML
    private TableColumn<TypePension, String> colName;
    @FXML
    private TableColumn<TypePension, String> colConditions;
    @FXML
    private TableColumn<TypePension, Number> colBaseSize;

    private List<TypePension> typesPensions;
    private ObservableList<TypePensionTableItem> typePensionTableItemObservable;

    private final TypePensionDao pensionDao = new TypePensionDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colConditions.setCellValueFactory(new PropertyValueFactory<>("conditions"));
        colBaseSize.setCellValueFactory(new PropertyValueFactory<>("base_size"));
        updateList();
    }

    @FXML
    void powerOff(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void updateEmployee(ActionEvent event) {
        updateList();
    }

    @FXML
    void addPensionAction(ActionEvent event) {
        PensionApp.dialogManager.showDialogAddPension("types_pensions/add-edit-pension-dialog.fxml",
                "Добавить инфу для пенсии");

        updateList();

    }

    @FXML
    void deletePensionAction(ActionEvent event) {
        TypePensionTableItem currentItem = pensionTable.getSelectionModel().getSelectedItem();
        int currentItemId = pensionTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new TypePensionService().delete(currentItem.getTypesPensions());
                pensionTable.getItems().remove(currentItemId);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void editPensionAction(ActionEvent event) {
        TypePensionTableItem currentItem = pensionTable.getSelectionModel().getSelectedItem();

        if (currentItem != null) {
            PensionApp.dialogManager.showDialogEditPension("types_pensions/add-edit-pension-dialog.fxml",
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
    void updateTypesPension(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        typesPensions = new TypePensionService().findAll();
        typePensionTableItemObservable = FXCollections.observableArrayList();

        for (TypePension tpsPens : typesPensions) {
            typePensionTableItemObservable.add(new TypePensionTableItem(tpsPens));
        }
        pensionTable.setItems(typePensionTableItemObservable);
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
        sceneManager.switchTo("recipient/recipient.fxml",
                "Получатель");
    }

    @FXML
    private void btnSceneAppointmentsAction(ActionEvent event) {
        sceneManager.switchTo("appointment/appointment.fxml",
                "Назначения");
    }
} 