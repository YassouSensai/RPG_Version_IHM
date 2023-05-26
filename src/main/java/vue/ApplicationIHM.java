package vue;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationIHM extends Application {
    public void start(Stage stage) {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 1400, 400);
        File feuilleCSS = new File("css"+File.separator+"feuilleStyle.css");

        scene.getStylesheets().add(feuilleCSS.toURI().toString());


        stage.setScene(scene);
        stage.setTitle("Role Playing Game");
        stage.show();
    }
    public static void main (String [] args ){
        Application.launch(args);
    }
}
