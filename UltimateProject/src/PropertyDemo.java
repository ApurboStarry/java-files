import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PropertyDemo extends Application {
    Stage window;
    Scene scene;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Starry Incorporated");

        //Input and labels
        TextField nameInput = new TextField();
        nameInput.setMaxWidth(200);

        Label firstLabel = new Label("Welcome to Starry Incorporated ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, nameInput, bottomText);
        layout.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(nameInput.textProperty());

        scene = new Scene(layout,400,400);
        window.setScene(scene);
        window.show();
    }
}