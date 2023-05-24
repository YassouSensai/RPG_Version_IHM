package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {

    static Controleur controleur;
    static GridPaneFormulaire formulaire;

    public HBoxRoot() {
        controleur = new Controleur();
        formulaire = new GridPaneFormulaire();

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
