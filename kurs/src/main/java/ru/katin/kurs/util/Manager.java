package ru.katin.kurs.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.katin.kurs.PensionApp;
import ru.katin.kurs.controller.types_pensions.AddEditPension;
import ru.katin.kurs.controller.types_pensions.TypesPensionTableItem;

import java.io.IOException;

public class Manager {
    private Stage stage;

    public Manager(Stage stage) {
        this.stage = stage;
        stage.setMinWidth(1200);
        stage.setMinHeight(675);
    }

    public void switchTo(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Scene scene = new Scene(loader.load(), 1200, 675);

            scene.getStylesheets().add("base-styles.css");

            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        }
        catch (IOException ioe) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Ошибка переключение сцен");
            alert.setContentText(String.format("ERROR: %s", ioe.getMessage()));
            alert.show();

            System.err.println("[ERROR] " + ioe.getMessage());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Критическая Ошибка переключение сцен");
            alert.setContentText(String.format("ERROR: %s", e.getMessage()));
            alert.show();
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public void showDialogAdd(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_add_stage = new Stage();

            dialog_add_stage.setTitle(title);
            dialog_add_stage.initModality(Modality.WINDOW_MODAL);
            dialog_add_stage.initOwner(this.stage);

            dialog_add_stage.setScene(new Scene(loader.load()));
            AddEditPension controller = loader.getController();
            controller.setAddDialogStage(dialog_add_stage);
            dialog_add_stage.showAndWait();
        }
        catch (IOException ioe) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Ошибка диалогового окна ADD");
            alert.setContentText(String.format("ERROR: %s", ioe.getMessage()));
            alert.show();

            System.err.println("[ERROR] " + ioe.getMessage());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Критическая Ошибка показа диалогового окна ADD");
            alert.setContentText(String.format("ERROR: %s", e.getMessage()));
            alert.show();
            System.err.println("[ERROR] " + e.getMessage());
        }
    }


    public void showDialogEdit(String fxmlFileName, String title,
                               TypesPensionTableItem currentItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_edit_stage = new Stage();

            dialog_edit_stage.initModality(Modality.WINDOW_MODAL);
            dialog_edit_stage.setTitle(title);
            dialog_edit_stage.initOwner(this.stage);
            dialog_edit_stage.setScene(new Scene(loader.load()));

            AddEditPension controller = loader.getController();

            controller.setEditDialogStage(dialog_edit_stage, currentItem.getTypesPensions());
            dialog_edit_stage.showAndWait();
        }
        catch (IOException ioe) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Ошибка диалогового окна EDIT");
            alert.setContentText(String.format("ERROR: %s", ioe.getMessage()));
            alert.show();

            System.err.println("[ERROR] " + ioe.getMessage());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Критическая Ошибка показа диалогового окна EDIT");
            alert.setContentText(String.format("ERROR: %s", e.getMessage()));
            alert.show();
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

}
