package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneDetailSolution extends Application {
    HBox root = new HBox();
    public SceneDetailSolution(String solutionString) {
        Text solutionText = new Text(solutionString);
        root.getChildren().add(solutionText);
    }
    public void start(Stage stage) {
        Scene scene = new Scene(root, 400, 250);

        stage.setScene(scene);
        stage.setTitle("Details de la solution");
        stage.show();
    }
}
