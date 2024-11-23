package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane bp = new BorderPane();
            
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd");
            String formattedDate = sdf.format(calendar.getTime());
            
            Label dateLabel = new Label(formattedDate);
            dateLabel.setStyle("-fx-font-size: 16px;");
            VBox dateBox = new VBox(dateLabel);
            dateBox.setAlignment(Pos.CENTER);
            bp.setTop(dateBox);
            
            GridPane calendarGrid = new GridPane();
            calendarGrid.setAlignment(Pos.CENTER);
            calendarGrid.setVgap(10);
            calendarGrid.setHgap(10);

            String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
            for (int i = 0; i < daysOfWeek.length; i++) {
                Label dayLabel = new Label(daysOfWeek[i]);
                dayLabel.setAlignment(Pos.CENTER);
                dayLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
                calendarGrid.add(dayLabel, i, 0);
            }
            
            int firstDayOfWeek = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            int row = 1;
            for (int i = 1; i < firstDayOfWeek; i++) {
                Label emptyLabel = new Label();
                emptyLabel.setMinWidth(40);
                emptyLabel.setMinHeight(40);
                calendarGrid.add(emptyLabel, i - 1, row);
            }
            
            row = 1;
            for (int dayOfMonth = 1; dayOfMonth <= daysInMonth; dayOfMonth++) {
                Label dayLabel = new Label(String.valueOf(dayOfMonth));
                dayLabel.setAlignment(Pos.CENTER);
                dayLabel.setMinWidth(40);
                dayLabel.setMinHeight(40);
                dayLabel.setStyle("-fx-font-size: 14px;");
                calendarGrid.add(dayLabel, (firstDayOfWeek + dayOfMonth - 1) % 7, row);
                if ((firstDayOfWeek + dayOfMonth - 1) % 7 == 6) {
                    row++;
                }
            }

            bp.setCenter(calendarGrid);
            
            Button prevButton = new Button("Previous");
            Button nextButton = new Button("Next");
            HBox buttonBox = new HBox(20, prevButton, nextButton);
            buttonBox.setAlignment(Pos.CENTER);
            bp.setBottom(buttonBox);
            
            Scene scene = new Scene(bp, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Current Date and Calendar");
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
