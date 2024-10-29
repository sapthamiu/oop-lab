import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels and TextFields for user input
        Label label1 = new Label("Number 1:");
        TextField textField1 = new TextField();
        Label label2 = new Label("Number 2:");
        TextField textField2 = new TextField();

        // Canvas for displaying results
        Canvas canvas = new Canvas(300, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Button with calculator image
        Image calculatorImage = new Image("calculator.jpeg"); // Ensure this image is in the same directory or provide path
        ImageView calcImgView = new ImageView(calculatorImage);
        calcImgView.setFitWidth(20);
        calcImgView.setFitHeight(20);
        Button computeButton = new Button("Compute", calcImgView);

        // Set button action
        computeButton.setOnAction(event -> {
            try {
                // Parse the input numbers
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());

                // Perform calculations
                double sum = num1 + num2;
                double product = num1 * num2;
                double difference = num1 - num2;
                double quotient = num2 != 0 ? num1 / num2 : Double.NaN;

                // Clear the canvas and display results
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.fillText("Sum: " + sum, 10, 30);
                gc.fillText("Product: " + product, 10, 60);
                gc.fillText("Difference: " + difference, 10, 90);
                gc.fillText("Quotient: " + quotient, 10, 120);
            } catch (NumberFormatException e) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.fillText("Please enter valid numbers.", 10, 30);
            }
        });

        // Layout setup
        HBox inputBox1 = new HBox(10, label1, textField1);
        HBox inputBox2 = new HBox(10, label2, textField2);
        VBox vBox = new VBox(15, inputBox1, inputBox2, computeButton, canvas);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(20));

        // Scene setup
        Scene scene = new Scene(vBox, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
