package ru.katin.kurs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PensionApp extends Application {
    public static Stage primaryStage;
    public static Scene reptions;
    public static Scene types_pensions;
    public static Scene appointments;

    @Override
    public void start(Stage stage) throws IOException {
        types_pensions = createScene("types_pensions/types_pensions.fxml");

        primaryStage = stage;
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("виды пенсии");

        types_pensions.getStylesheets().add("base-styles.css");


        primaryStage.setScene(types_pensions);
        primaryStage.show();
    }

    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PensionApp.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}
