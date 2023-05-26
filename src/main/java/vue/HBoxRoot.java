package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {

    static Controleur controleur;
    static GridPaneFormulaire formulaire;
    static VBoxSolution tableEfficace;
    static VBoxSolution tableExhaustive;

    public HBoxRoot() {
        controleur = new Controleur();
        formulaire = new GridPaneFormulaire();
        tableEfficace = new VBoxSolution("eff");
        tableExhaustive = new VBoxSolution("exh");

        this.getChildren().add(formulaire);
        this.getChildren().add(tableEfficace);
        this.getChildren().add(tableExhaustive);
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


    /**
     * Accesseur sur le champ tableEfficace.
     * @return VBoxSolutionEfficace
     */
    public static VBoxSolution getTableEfficace() {
        return tableEfficace;
    }

    /**
     * Accesseur sur le champ tableExhaustive.
     * @return VBoxSolution
     */
    public static VBoxSolution getTableExhaustive() {
        return tableExhaustive;
    }

}
