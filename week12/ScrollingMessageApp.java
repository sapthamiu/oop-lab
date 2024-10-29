import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollingMessageApp extends Application {
    private double textPositionX;
    private boolean scrollRight;
    private volatile boolean running;
    private final String message = "Scrolling Message Demo";

    @Override
    public void start(Stage primaryStage) {
        // Canvas for displaying the scrolling message
        Canvas canvas = new Canvas(400, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Radio buttons for direction control
        RadioButton leftToRight = new RadioButton("Left to Right");
        RadioButton rightToLeft = new RadioButton("Right to Left");
        
        ToggleGroup directionGroup = new ToggleGroup();
        leftToRight.setToggleGroup(directionGroup);
        rightToLeft.setToggleGroup(directionGroup);
        rightToLeft.setSelected(true);  // Default selection

        // Start scrolling button
        Button startButton = new Button("Start Scrolling");

        // Event handler for the start button
        startButton.setOnAction(event -> {
            scrollRight = leftToRight.isSelected();
            if (!running) {
                startScrolling(gc, canvas.getWidth());
            }
        });

        // Layout setup
        HBox radioBox = new HBox(10, leftTo
