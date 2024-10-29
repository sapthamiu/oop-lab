import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.animation.*;
import javafx.event.*;

public class ScrollApp extends Application {
    private static final String MESSAGE = "This is a scrolling message!";
    private double xPos = 600; 
    private boolean scrollLtoR = true; 

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Canvas canvas = new Canvas(600, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        ToggleGroup group = new ToggleGroup();
        RadioButton LtoR = new RadioButton("Scroll Left to Right");
        LtoR.setToggleGroup(group);
        LtoR.setSelected(true);

        RadioButton RtoL = new RadioButton("Scroll Right to Left");
        RtoL.setToggleGroup(group);

        root.getChildren().addAll(LtoR, RtoL, canvas);
        
        LtoR.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){scrollLtoR = true;}});
        RtoL.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){scrollLtoR = false;}});

        Scene scene = new Scene(root, 600, 100);
        primaryStage.setTitle("Simple Scrolling Message");
        primaryStage.setScene(scene);
        primaryStage.show();

        gc.setFont(new Font(20));
        
        AnimationTimer anitimer = new AnimationTimer() {
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 
                gc.fillText(MESSAGE, xPos, 50); 
                double speed = 0.5;
                if (scrollLtoR) {
                    xPos += speed; 
                    if (xPos > canvas.getWidth()) 
                        xPos = -gc.getFont().getSize() * MESSAGE.length(); //reset to start
                } else {
                    xPos -= speed; // Scroll to the left
                    if (xPos < -gc.getFont().getSize() * MESSAGE.length()) 
                        xPos = canvas.getWidth(); // Reset to end
                }
            }
        };
        anitimer.start();
    }
}
