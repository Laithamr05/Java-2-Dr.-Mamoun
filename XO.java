package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class XO extends Application {
    private Label[][] cells = new Label[3][3];
    private Game game;

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane gp = new GridPane();

            for (int c = 0; c < 3; c++) {
                for (int r = 0; r < 3; r++) {
                    Label label = new Label("");
                    label.prefHeightProperty().bind(gp.heightProperty().divide(3));
                    label.prefWidthProperty().bind(gp.widthProperty().divide(3));
                    label.setAlignment(Pos.CENTER);
                    label.setStyle("-fx-border-color:Red;-fx-border-width:5");

                    int finalC = c;
                    int finalR = r;
                    label.setOnMouseClicked(event -> game.handleCellClick(label, finalC, finalR));

                    cells[c][r] = label;
                    gp.add(label, c, r);
                }
            }

            Label turnLabel = new Label("X Turn");

            game = new Game(cells, turnLabel);

            BorderPane bp = new BorderPane();
            VBox vb = new VBox(20);
            vb.getChildren().addAll(turnLabel);
            vb.setAlignment(Pos.CENTER);
            bp.setCenter(gp);
            bp.setBottom(vb);

            Scene scene = new Scene(bp, 300, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tic-Tac-Toe");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
