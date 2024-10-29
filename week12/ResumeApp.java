import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResumeApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Resume details input fields
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");
        
        TextField contactField = new TextField();
        contactField.setPromptText("Enter your contact number");

        TextArea educationField = new TextArea();
        educationField.setPromptText("Enter your education details");
        
        TextArea experienceField = new TextArea();
        experienceField.setPromptText("Enter your experience details");

        // Checkboxes for languages
        CheckBox langEnglish = new CheckBox("English");
        CheckBox langSpanish = new CheckBox("Spanish");
        CheckBox langFrench = new CheckBox("French");
        CheckBox langGerman = new CheckBox("German");
        CheckBox langChinese = new CheckBox("Chinese");

        // Submit button
        Button submitButton = new Button("Submit");

        // Canvas for displaying resume details
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Event handler for submit button
        submitButton.setOnAction(event -> {
            // Clear previous canvas content
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            
            // Retrieve and display details
            String name = nameField.getText();
            String contact = contactField.getText();
            String education = educationField.getText();
            String experience = experienceField.getText();
            
            // Collect selected languages
            StringBuilder languages = new StringBuilder();
            if (langEnglish.isSelected()) languages.append("English, ");
            if (langSpanish.isSelected()) languages.append("Spanish, ");
            if (langFrench.isSelected()) languages.append("French, ");
            if (langGerman.isSelected()) languages.append("German, ");
            if (langChinese.isSelected()) languages.append("Chinese, ");
            
            // Remove trailing comma and space
            if (languages.length() > 0) {
                languages.setLength(languages.length() - 2);
            } else {
                languages.append("None");
            }
            
            // Displaying resume details on the Canvas
            gc.fillText("Resume Details", 10, 20);
            gc.fillText("Name: " + name, 10, 50);
            gc.fillText("Contact: " + contact, 10, 80);
            gc.fillText("Education: " + education, 10, 110);
            gc.fillText("Experience: " + experience, 10, 140);
            gc.fillText("Languages: " + languages.toString(), 10, 170);
        });

        // Layout setup
        VBox vBox = new VBox(10, nameField, contactField, educationField, experienceField,
                             langEnglish, langSpanish, langFrench, langGerman, langChinese, submitButton, canvas);
        vBox.setPadding(new Insets(15));
        vBox.setAlignment(Pos.TOP_CENTER);

        // Scene setup
        Scene scene = new Scene(vBox, 450, 500);
        primaryStage.setTitle("Resume Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
