
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chess extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		int box = 8;
		GridPane sp = new GridPane();
		for (int r = 0; r < box; r++) {
			for (int c = 0; c < box; c++) {
				Rectangle rec = new Rectangle(70, 70);
				rec.xProperty().bind(sp.widthProperty().divide(8).multiply(c));
				rec.yProperty().bind(sp.heightProperty().divide(8).multiply(r));
				rec.widthProperty().bind(sp.widthProperty().divide(8));
				rec.heightProperty().bind(sp.heightProperty().divide(8));

				if ((r + c) % 2 == 0) {
					rec.setFill(Color.WHITE);
				} else {
					rec.setFill(Color.BLACK);
				}
				sp.add(rec, c, r);

			}
		}

		Scene scene = new Scene(sp, 70 * 8, 70 * 8);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
