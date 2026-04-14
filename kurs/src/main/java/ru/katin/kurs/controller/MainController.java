package ru.katin.kurs.controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.katin.kurs.PensionApp;
import ru.katin.kurs.controller.types_pensions.AddEditPension;
import ru.katin.kurs.controller.types_pensions.TypesPensionTableItem;
import ru.katin.kurs.model.TypesPensions;
import ru.katin.kurs.repository.TypesPensionDao;
import ru.katin.kurs.services.TypesPensionsServices;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<TypesPensionTableItem> pensionTable;
    @FXML
    private TableColumn<TypesPensions, String> colName;
    @FXML
    private TableColumn<TypesPensions, String> colConditions;
    @FXML
    private TableColumn<TypesPensions, Number> colBaseSize;

    private List<TypesPensions> typesPensions;
    private ObservableList<TypesPensionTableItem> typesPensionTableItemObservable;

    private final TypesPensionDao pensionDao = new TypesPensionDao();

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
    void addEmployee(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(PensionApp.class.getResource("types_pensions/add-edit-pension-dialog.fxml"));

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(PensionApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить инфу для пенсии");
            AddEditPension controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();

            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }

    }

    @FXML
    void deleteEmployee(ActionEvent event) {
        TypesPensionTableItem currentItem = pensionTable.getSelectionModel().getSelectedItem();
        int currentItemId = pensionTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new TypesPensionsServices().delete(currentItem.getTypesPensions());
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
    void editEmployee(ActionEvent event) {
        TypesPensionTableItem currentItem = pensionTable.getSelectionModel().getSelectedItem();
        int currentItemId = pensionTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(PensionApp.class.getResource("types_pensions/add-edit-pension-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(PensionApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать инфы о пенсии");
                AddEditPension controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getTypesPensions());
                dialogStage.showAndWait();
                updateList();
            } catch (IOException e) {
                System.out.println("Ошибка открытия окна: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }

    private void setCellValueFactories() {
        colName.setCellValueFactory(cellData -> new
                SimpleStringProperty(cellData.getValue().getName()));
        colConditions.setCellValueFactory(cellData -> new
                SimpleStringProperty(cellData.getValue().getConditions()));
        colBaseSize.setCellValueFactory(cellData -> new
                SimpleDoubleProperty(cellData.getValue().getBase_size()));
    }

    @FXML
    void updateTypesPension(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        typesPensions = new TypesPensionsServices().findAll();
        typesPensionTableItemObservable = FXCollections.observableArrayList();

        for (TypesPensions tpsPens : typesPensions) {
            typesPensionTableItemObservable.add(new TypesPensionTableItem(tpsPens));
        }
        pensionTable.setItems(typesPensionTableItemObservable);
    }
} 