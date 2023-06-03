package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.LectureFichierTexte;
import modele.Solution;
import modele.Quete;
import vue.GridPaneFormulaire;
import vue.HBoxRoot;
import vue.SceneDetailSolution;
import vue.VBoxSolution;


import java.io.File;
import java.util.ArrayList;

/**
 * Classe Controleur.
 *
 * Cette classe implemente l'interface EventHandler et permet de gérer les evenements sur l'IHM du RPG.
 * Elle contient 2 champs ;
 *  - String solutionStringEfficace, solutionStringExhaustive       qui sont initialisé à null et permettrons de changer
 *                                                                  à chaque simulation le contenu des details
 */
public class Controleur implements EventHandler {
    String solutionStringEfficace = null;
    String solutionStringExhaustive = null;

    /**
     * Methode handle qui permet la detection d'evenement.
     * @param event
     */
    @Override
    public void handle(Event event) {

        // Creation + instanciation des trois champs de la classe HBoxRoot.
        GridPaneFormulaire formulaire = HBoxRoot.getFormulaire();
        VBoxSolution tableEfficace = HBoxRoot.getTableEfficace();
        VBoxSolution tableExhaustive = HBoxRoot.getTableExhaustive();

        // Instructions si l'evenement vient du bouton "simuler"
        if (((Button) event.getSource()).getUserData() == "Simuler") {
            System.out.println("vous avez cliqué sur le bouton");

            // Modification des Labels labelSolution appartenant aux objets tableEfficace et tableExhaustive
            tableEfficace.setLabelSolution(formulaire.getNumScenarioSelectionne());
            tableExhaustive.setLabelSolution(formulaire.getNumScenarioSelectionne());

            // Création du scenario sélectionné
            File fichierScenario = formulaire.getScenarioSelectionne();
            int posX = formulaire.getPosX();
            int posY = formulaire.getPosY();
            Solution scenarioEnCour = new Solution(LectureFichierTexte.lecture(fichierScenario), posX, posY);

            // Creation de la liste de quetes pour la solution Efficace + affichage dans la tableView correspondante
            ArrayList<Quete> solutionEfficaceEnCour = scenarioEnCour.solutionEfficace();
            tableEfficace.miseAJourTable(solutionEfficaceEnCour);

            // Consequence : changement du champ solutionStringEfficace
            solutionStringEfficace = scenarioEnCour.getSolutionString();

            // Creation de la liste de quetes pour la solution Exhaustive + affichage dans la tableView correspondante
            ArrayList<Quete> solutionExhaustiveEnCour = scenarioEnCour.solutionExhaustive();
            tableExhaustive.miseAJourTable(solutionExhaustiveEnCour);

            // Consequence : changement du champ solutionStringExhaustive
            solutionStringExhaustive = scenarioEnCour.getSolutionString();
        }

        // Instructions si l'evenement vient du bouton "Afficher les détails" de la colution efficace
        if (((Button) event.getSource()).getUserData() == "eff") {
            if (tableEfficace.tableDesQuetes.getItems().size() != 0) {

                // Creation + instanciation d'un objet de la classe SceneDetailSolution, Puis on l'affiche
                SceneDetailSolution afficheDetailEfficace = new SceneDetailSolution(solutionStringEfficace);
                afficheDetailEfficace.start(new Stage());
            }

        }

        // Instructions si l'evenement vient du bouton "Afficher les détails" de la colution exhaustive
        if (((Button) event.getSource()).getUserData() == "exh") {
            if (tableExhaustive.tableDesQuetes.getItems().size() != 0) {

                // Creation + instanciation d'un objet de la classe SceneDetailSolution, Puis on l'affiche
                SceneDetailSolution afficheDetailExhaustive = new SceneDetailSolution(solutionStringExhaustive);
                afficheDetailExhaustive.start(new Stage());
            }

        }

    }
}
