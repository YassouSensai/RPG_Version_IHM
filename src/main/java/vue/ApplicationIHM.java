package vue;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


/**
 * Classe ApplicationIHM.
 *
 * Cette classe herite de la classe Application et permettra d'instancier des objets
 * contenant l'application finale voulue pour le projet RPG. Elle contient un champ ;
 *
 *  - HBoxRoot root         Sera l'element graphique qui contiendra tout les autres éléments
 *                          et permet d'avoir un affichege sur la scene.
 */
public class ApplicationIHM extends Application {
    HBoxRoot root = new HBoxRoot();

    /**
     * Methode start de la classe. Cette methode permet de demarer l'application (c'est à dire de la faire apparaitre a l'ecran)
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    public void start(Stage stage) {
        Scene scene = new Scene(root, 1050, 400);
        File feuilleCSS = new File("css"+File.separator+"application.css");

        scene.getStylesheets().add(feuilleCSS.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Role Playing Game");
        stage.show();
    }

    /**
     * Methode main qui ressemble à celle des classes clientes (algo).
     * Elle permet de lancer l'application.
     * @param args
     */
    public static void main (String [] args ){
        Application.launch(args);
    }
}
