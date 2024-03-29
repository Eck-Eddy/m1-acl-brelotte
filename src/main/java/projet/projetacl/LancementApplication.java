package projet.projetacl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LancementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("menuPrincipal.fxml"));
        stage.setTitle("Brelotte!");
        stage.setScene(new Scene(root,600,400));
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}