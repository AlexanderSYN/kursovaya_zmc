package ru.katin.kurs.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static ru.katin.kurs.util.AlertManager.*;

public class SceneManager {
    private Stage stage;

    public SceneManager(Stage stage) {
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
            preparedErrorAlertException("Ошибка переключение сцен", ioe);
        }
        catch (Exception e) {
            preparedErrorAlertException("Критическая Ошибка переключение сцен", e);
        }
    }


}
