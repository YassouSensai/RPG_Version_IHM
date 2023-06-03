package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;


/**
 * Classe SceneDetailSolution.
 *
 * Cette classe herite de la classe Application et permettra d'instancier des objets (application)
 * contenant les détails des solutions. Cette classe possede un seul champ ;
 *  - VBox root         qui sera l'element graphique de la scene qui contiendra les autres elements necessaire
 *                      pour les details des solutions.
 */
public class SceneDetailSolution extends Application {
    VBox root = new VBox();

    /**
     * Constructeur de la classe SceneDetailSolution.
     *
     * Ce constructeur permet d'instancier un element solutionText de la classe Text grace
     * au parametre solutionString (qui sera le champ solutionString de la classe Scenario).
     *
     * @param solutionString
     */
    public SceneDetailSolution(String solutionString) {
        root.setFillWidth(true);
        Text solutionText = new Text(solutionString);

        root.getChildren().add(solutionText);
    }

    /**
     * Methode start de la classe. Cette methode permet de demarer l'application (c'est à dire de la faire apparaitre a l'ecran)
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    public void start(Stage stage) {
        Scene scene = new Scene(root, 300, 600);
        File feuilleCSS = new File("css"+File.separator+"detail.css");

        scene.getStylesheets().add(feuilleCSS.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Details de la solution");
        stage.show();
    }
}
