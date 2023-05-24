package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.LectureFichierTexte;
import modele.NiveauUNParametre;

import java.io.File;

public class HBoxRoot extends HBox {

    static Controleur controleur;
    static GridPaneFormulaire formulaire;
    static NiveauUNParametre realisationScenario;

    public HBoxRoot() {
        controleur = new Controleur();
        formulaire = new GridPaneFormulaire();
        realisationScenario = new NiveauUNParametre(LectureFichierTexte.lecture(new File("scenarios"+File.separator+"scenario_0.txt")));

        this.getChildren().add(formulaire);
    }


    /**
     * Accesseur sur le champ formulaire.
     * @return GridPaneFormulaire
     */
    public static GridPaneFormulaire getFormulaire() {
        return formulaire;
    }

    /**
     * Accesseur sur le champ controleur.
     * @return Controleur
     */
    public static Controleur getControleur() {
        return controleur;
    }

}
