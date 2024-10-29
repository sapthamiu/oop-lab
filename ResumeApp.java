import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class ResumeApp extends Application {

    public void start(Stage primaryStage) {
        TextField name = new TextField();
        name.setPromptText("Enter your full name");
        
        TextField contact = new TextField();
        contact.setPromptText("Enter your contact number");

        TextArea edu = new TextArea();
        edu.setPromptText("Enter your education details");
        
        TextArea experience = new TextArea();
        experience.setPromptText("Enter your experience details");

        CheckBox english = new CheckBox("English");
        CheckBox spanish = new CheckBox("Spanish");
        CheckBox french = new CheckBox("French");
        CheckBox german = new CheckBox("German");
        CheckBox chinese = new CheckBox("Chinese");

        Button submit = new Button("Submit");

        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        submit.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                
                String nameT = name.getText();
                String contactT = contact.getText();
                String eduT = edu.getText();
                String experienceT = experience.getText();
                
                String languages = "";
                if (english.isSelected()) languages += "English, ";
                if (spanish.isSelected()) languages += "Spanish, ";
                if (french.isSelected()) languages += "French, ";
                if (german.isSelected()) languages += "German, ";
                if (chinese.isSelected()) languages += "Chinese, ";
                
                if (languages.length() > 0) 
                    languages = languages.substring(0,languages.length()-2);
                else
                    languages += "None";
                
                gc.fillText("Resume Details", 10, 20);
                gc.fillText("Name: " + nameT, 10, 50);
                gc.fillText("Contact: " + contactT, 10, 80);
                gc.fillText("Education: " + eduT, 10, 110);
                gc.fillText("Experience: " + experienceT, 10, 140);
                gc.fillText("Languages: " + languages, 10, 170);
            }});

        VBox vBox = new VBox(10, name, contact, edu, experience, english, spanish, french, german, chinese, submit, canvas);
        vBox.setPadding(new Insets(15));
        vBox.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(vBox, 450, 500);
        primaryStage.setTitle("Resume");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}