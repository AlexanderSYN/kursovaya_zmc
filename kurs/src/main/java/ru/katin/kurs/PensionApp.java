package ru.katin.kurs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.katin.kurs.util.Manager;

import java.io.IOException;

public class PensionApp extends Application {
    public static Manager manager;

    public static Scene reptions;
    public static Scene types_pensions;
    public static Scene appointments;

    @Override
    public void start(Stage stage) throws IOException {
        manager = new Manager(stage);
        manager.switchTo("types_pensions/types_pensions.fxml",
                "Виды пенсии");

    }

    public static void main(String[] args) {
        launch();
    }
}
