package ru.katin.kurs;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.katin.kurs.util.DialogManager;
import ru.katin.kurs.util.SceneManager;

import java.io.IOException;

public class PensionApp extends Application {
    public static SceneManager sceneManager;
    public static DialogManager dialogManager;

    @Override
    public void start(Stage stage) throws IOException {
        dialogManager = new DialogManager(stage);
        sceneManager = new SceneManager(stage);
        sceneManager.switchTo("types_pensions/type_pension.fxml",
                "Виды Пенсий");
    }

    public static void main(String[] args) {
        launch();
    }
}
