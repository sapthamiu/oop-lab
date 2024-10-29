import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

// Assuming a Student class is available
class Student {
    private final String registerNumber;
    private final String name;
    private final String course;
    private final String year;

    public Student(String registerNumber, String name, String course, String year) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public String getRegisterNumber() { return registerNumber; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getYear() { return year; }
    
    public String getDetails() {
        return "Name: " + name + "\nCourse: " + course + "\nYear: " + year;
    }
}

public class StudentDetailsApp extends Application {
    
    // Sample data
    private final Map<String, Student> studentMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        // Populate some sample students
        studentMap.put("1001", new Student("1001", "Alice Johnson", "Computer Science", "2nd Year"));
        studentMap.put("1002", new Student("1002", "Bob Smith", "Mechanical Engineering", "3rd Year"));
        studentMap.put("1003", new Student("1003", "Carol White", "Electrical Engineering", "1st Year"));
        
        // ListView for displaying student register numbers
        ObservableList<String> registerNumbers = FXCollections.observableArrayList(studentMap.keySet());
        ListView<String> listView = new ListView<>(registerNumbers);

        // Canvas for displaying student details
        Canvas canvas = new Canvas(300, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Event handler for ListView selection
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                displayStudentDetails(gc, newValue);
            }
        });

        // Layout setup
        VBox vBox = new VBox(10, listView);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);

        BorderPane root = new BorderPane();
        root.setLeft(vBox);
        root.setCenter(canvas);
        
        // Scene setup
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Student Details Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayStudentDetails(GraphicsContext gc, String registerNumber) {
        Student student = studentMap.get(registerNumber);
        
        // Clear canvas
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        if (student != null) {
            // Display student details
            gc.fillText("Register Number: " + student.getRegisterNumber(), 10, 30);
            gc.fillText("Name: " + student.getName(), 10, 60);
            gc.fillText("Course: " + student.getCourse(), 10, 90);
            gc.fillText("Year: " + student.getYear(), 10, 120);
        } else {
            gc.fillText("Student not found.", 10, 30);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
