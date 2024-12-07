package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Editor extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;

        HBox hb = new HBox(30);
        Label file = new Label("File: ");
        TextField tf = new TextField("File Name");
        Button buttonLoad = new Button("Load");
        TextArea ta = new TextArea();
        HBox hb2 = new HBox();
        Button buttonSave = new Button("Save");

        BorderPane bp = new BorderPane();
        hb.getChildren().addAll(file, tf, buttonLoad);
        hb2.getChildren().add(buttonSave);
        bp.setCenter(ta);
        hb.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);
        bp.setBottom(hb2);
        bp.setTop(hb);

        Handler handler = new Handler(this, ta, tf);
        buttonLoad.setOnAction(handler);
        buttonSave.setOnAction(handler);

        Scene scene = new Scene(bp, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Editor");
        primaryStage.show();
    }

    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
