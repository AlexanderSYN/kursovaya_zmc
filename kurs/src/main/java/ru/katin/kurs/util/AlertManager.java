package ru.katin.kurs.util;

import javafx.scene.control.Alert;

public class AlertManager {

    public static void preparedErrorAlertException(String headerText, Exception err) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(headerText);
        alert.setContentText(String.format("ERROR: %s", err.getMessage()));
        alert.show();
        System.err.println("[ERROR] " + err.getMessage());
    }

    public static void errorAlert(String title, String headerText,
                                  String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.show();
    }
}
