package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.LectureFichierTexte;
import modele.NiveauUNParametre;
import modele.Quete;
import vue.GridPaneFormulaire;
import vue.HBoxRoot;
import vue.SceneDetailSolution;
import vue.VBoxSolution;


import java.io.File;
import java.util.ArrayList;

public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {
        GridPaneFormulaire formulaire = HBoxRoot.getFormulaire();
        VBoxSolution tableEfficace = HBoxRoot.getTableEfficace();
        VBoxSolution tableExhaustive = HBoxRoot.getTableExhaustive();

        String solutionStringEfficace = null;
        String solutioNStringExhaustive = null;


        if (((Button) event.getSource()).getUserData() == "Simuler") {
            System.out.println("vous avez cliqué sur le bouton");

            // Modification des Labels labelSolution appartenant aux objets tableEfficace et tableExhaustive
            tableEfficace.setLabelSolution(formulaire.getNumScenarioSelectionne());
            tableExhaustive.setLabelSolution(formulaire.getNumScenarioSelectionne());

            // Création du scenario sélectionné
            File fichierScenario = formulaire.getScenarioSelectionne();
            int posX = formulaire.getPosX();
            int posY = formulaire.getPosY();
            NiveauUNParametre scenarioEnCour = new NiveauUNParametre(LectureFichierTexte.lecture(fichierScenario), posX, posY);

            ArrayList<Quete> solutionEfficaceEnCour = scenarioEnCour.solutionEfficace();
            tableEfficace.miseAJourTable(solutionEfficaceEnCour);
            solutionStringEfficace = scenarioEnCour.getSolutionString();

            ArrayList<Quete> solutionExhaustiveEnCour = scenarioEnCour.solutionExhaustive();
            tableExhaustive.miseAJourTable(solutionExhaustiveEnCour);
            solutioNStringExhaustive = scenarioEnCour.getSolutionString();
        }




        if (((Button) event.getSource()).getUserData() == "eff") {
            SceneDetailSolution afficheDetailEfficace = new SceneDetailSolution(solutionStringEfficace);
            afficheDetailEfficace.start(new Stage());
        }

        if (((Button) event.getSource()).getUserData() == "exh") {
            SceneDetailSolution afficheDetailExhaustive = new SceneDetailSolution(solutioNStringExhaustive);
            afficheDetailExhaustive.start(new Stage());
        }

    }
}
