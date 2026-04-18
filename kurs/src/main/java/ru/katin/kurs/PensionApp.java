package ru.katin.kurs;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.katin.kurs.util.SceneManager;

import java.io.IOException;

public class PensionApp extends Application {
    public static SceneManager sceneManager;

    @Override
    public void start(Stage stage) throws IOException {
        sceneManager = new SceneManager(stage);
        sceneManager.switchTo("types_pensions/type_pension.fxml",
                "Виды пенсии");
    }

    public static void main(String[] args) {
        launch();
    }
}
