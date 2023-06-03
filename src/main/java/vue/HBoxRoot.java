package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;


/**
 * Classe HBoxRoot.
 *
 * Cette classe herite de la classe HBox et permettra d'instancier des objets de type HBox qui contiendront
 * 3 elements apparents ;
 *  - GridPaneFormulaire formulaire                 qui permettra de parametrer l'affichage des deus solutions à l'ecran
 *                                                  (ex : choix du scenario)
 *  - VBoxSolution tableEfficace, tableExhaustive   qui permettront d'afficher la solution exhaustive et efficace à l'aide d'une TableView
 *
 * Cette classe contient également un champ de la classe controleur ;
 *  - Controleur controleur                         qui permettra de detecter les actions de l'utilisateur et par conséquent,
 *                                                  il permettra egalement de gerer l'affichage.
 */
public class HBoxRoot extends HBox {

    static Controleur controleur;
    static GridPaneFormulaire formulaire;
    static VBoxSolution tableEfficace, tableExhaustive;

    /**
     * Constructeur de la classe HBoxRoot.
     */
    public HBoxRoot() {
        // Instanciation des 4 champs
        controleur = new Controleur();
        formulaire = new GridPaneFormulaire();
        tableEfficace = new VBoxSolution("eff");
        tableExhaustive = new VBoxSolution("exh");

        // Ajout des champs formulaire, tableEfficace et tableExhaustive à la HBox
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
