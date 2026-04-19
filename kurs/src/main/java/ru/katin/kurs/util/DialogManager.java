package ru.katin.kurs.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.katin.kurs.controller.appointments.AddEditAppointment;
import ru.katin.kurs.controller.appointments.AppointmentTableItem;
import ru.katin.kurs.controller.recipient.AddEditRecipient;
import ru.katin.kurs.controller.recipient.RecipientTableItem;
import ru.katin.kurs.controller.types_pensions.AddEditPension;
import ru.katin.kurs.controller.types_pensions.TypePensionTableItem;

import java.io.IOException;
import java.util.Arrays;

import static ru.katin.kurs.util.AlertManager.*;

public class DialogManager {
    private Stage stage;

    public DialogManager(Stage stage) {
        this.stage = stage;
    }

    public void showDialogAddPension(String fxmlFileName, String title) {
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
            preparedErrorAlertException("Ошибка диалогового окна ADD", ioe);
        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна ADD", e);
        }
    }

    public void showDialogAddAppointment(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_add_stage = new Stage();

            dialog_add_stage.setTitle(title);
            dialog_add_stage.initModality(Modality.WINDOW_MODAL);
            dialog_add_stage.initOwner(this.stage);
            dialog_add_stage.setScene(new Scene(loader.load()));
            AddEditAppointment controller = loader.getController();
            controller.setAddDialogStage(dialog_add_stage);
            dialog_add_stage.showAndWait();
        }
        catch (IOException ioe) {
            preparedErrorAlertException("Ошибка диалогового окна ADD", ioe);
            System.err.println("[ERROR] " + Arrays.toString(ioe.getStackTrace()));
        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна ADD", e);
            System.err.println("[CRTICAL_ERROR] " + e.getMessage());
        }
    }

    public void showDialogAddRecipient(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_add_stage = new Stage();

            dialog_add_stage.setTitle(title);
            dialog_add_stage.initModality(Modality.WINDOW_MODAL);
            dialog_add_stage.initOwner(this.stage);
            dialog_add_stage.setScene(new Scene(loader.load()));
            AddEditRecipient controller = loader.getController();
            controller.setAddDialogStage(dialog_add_stage);
            dialog_add_stage.showAndWait();
        }
        catch (IOException ioe) {
            preparedErrorAlertException("Ошибка диалогового окна ADD", ioe);
            System.err.println("[ERROR] " + Arrays.toString(ioe.getStackTrace()));
        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна ADD", e);
            System.err.println("[CRTICAL_ERROR] " + e.getMessage());
        }
    }


    public void showDialogEditPension(String fxmlFileName, String title,
                                      TypePensionTableItem currentItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_edit_stage = new Stage();

            dialog_edit_stage.initModality(Modality.WINDOW_MODAL);
            dialog_edit_stage.setTitle(title);
            dialog_edit_stage.initOwner(this.stage);
            dialog_edit_stage.setScene(new Scene(loader.load()));

            AddEditPension controller = loader.getController();

            controller.setEditDialogStagePension(dialog_edit_stage, currentItem.getTypesPensions());
            dialog_edit_stage.showAndWait();
        }
        catch (IOException ioe) {
            preparedErrorAlertException("Ошибка диалогового окна EDIT", ioe);

        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна EDIT",
                    e);
        }
    }

    public void showDialogEditAppointment(String fxmlFileName, String title,
                                          AppointmentTableItem currentItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_edit_stage = new Stage();

            dialog_edit_stage.initModality(Modality.WINDOW_MODAL);
            dialog_edit_stage.setTitle(title);
            dialog_edit_stage.initOwner(this.stage);
            dialog_edit_stage.setScene(new Scene(loader.load()));

            AddEditAppointment controller = loader.getController();

            controller.setEditDialogStageAppointment(dialog_edit_stage, currentItem.getAppointment());
            dialog_edit_stage.showAndWait();
        }
        catch (IOException ioe) {
            preparedErrorAlertException("Ошибка диалогового окна EDIT", ioe);

        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна EDIT",
                    e);
        }
    }


    public void showDialogEditRecipient(String fxmlFileName, String title,
                                          RecipientTableItem currentItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/katin/kurs/" + fxmlFileName));
            Stage dialog_edit_stage = new Stage();

            dialog_edit_stage.initModality(Modality.WINDOW_MODAL);
            dialog_edit_stage.setTitle(title);
            dialog_edit_stage.initOwner(this.stage);
            dialog_edit_stage.setScene(new Scene(loader.load()));

            AddEditRecipient controller = loader.getController();

            controller.setEditDialogStageAppointment(dialog_edit_stage, currentItem.getRecipient());
            dialog_edit_stage.showAndWait();
        }
        catch (IOException ioe) {
            preparedErrorAlertException("Ошибка диалогового окна EDIT", ioe);

        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка показа диалогового окна EDIT",
                    e);
        }
    }

}
