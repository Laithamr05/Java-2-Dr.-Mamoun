package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class Handler implements EventHandler<ActionEvent> {
    private Editor editor;
    private TextArea textArea;
    private TextField fileNameField;

    public Handler(Editor editor, TextArea textArea, TextField fileNameField) {
        this.editor = editor;
        this.textArea = textArea;
        this.fileNameField = fileNameField;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();

            if (sourceButton.getText().equals("Load")) {
                loadFile();
            } else if (sourceButton.getText().equals("Save")) {
                saveFile();
            }
        }
    }

    private void loadFile() {
        String fileName = fileNameField.getText();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            textArea.setText(content.toString());
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private void saveFile() {
        String fileName = fileNameField.getText();
        File file = new File(fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.write(textArea.getText());
            System.out.println("File saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
