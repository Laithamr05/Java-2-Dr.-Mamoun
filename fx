package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BarGraph extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane sp = new GridPane();

		Rectangle rec1 = new Rectangle(100, 200);
		Rectangle rec2 = new Rectangle(150, 200);
		Rectangle rec3 = new Rectangle(50, 200);
		Rectangle rec4 = new Rectangle(25, 200);
		sp.getChildren().add(rec1);
		sp.getChildren().add(rec2);
		sp.getChildren().add(rec3);
		sp.getChildren().add(rec4);
		
		Text text = new Text();
		Scene scene = new Scene(sp, 70 * 8, 70 * 8);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

