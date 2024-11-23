package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gp = new GridPane();
			for (int c = 0; c < 3; c++) {
				for (int r = 0; r < 3; r++) {
					int value = (int) (Math.random() * 2);
					Label label = new Label("" + value);
					label.prefHeightProperty().bind(gp.heightProperty().divide(3));
					label.prefWidthProperty().bind(gp.widthProperty().divide(3));
					label.setAlignment(Pos.CENTER);
					label.setStyle("-fx-border-color:Red;-fx-border-width:5");
					
					gp.add(label, c, r);
				}
			}
			Scene scene = new Scene(gp, 200, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
