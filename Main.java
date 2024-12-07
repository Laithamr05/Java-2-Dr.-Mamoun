package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Main extends Application {
	Circle circle = new Circle(200, 200, 50);
	Button b = new Button("+");
	Button m = new Button("-");

	@Override
	public void start(Stage primaryStage) {
		try {
			ShapeHandler sh = new ShapeHandler(this);
			b.setOnAction(sh);
			m.setOnAction(sh);
			BorderPane bp = new BorderPane();
			Pane p = new Pane();

			HBox hb = new HBox(20);
			p.getChildren().add(circle);
			m.setPrefWidth(50);
			b.setPrefWidth(50);
			hb.getChildren().addAll(m, b);
			hb.setAlignment(Pos.CENTER);
			bp.setCenter(p);
			bp.setBottom(hb);
			Scene scene = new Scene(bp, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
