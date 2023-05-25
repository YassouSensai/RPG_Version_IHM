package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modele.LectureFichierTexte;
import modele.NiveauUNParametre;
import modele.Quete;
import vue.GridPaneFormulaire;
import vue.HBoxRoot;
import vue.VBoxSolution;

import java.io.File;
import java.util.ArrayList;

public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {
        GridPaneFormulaire formulaire = HBoxRoot.getFormulaire();
        VBoxSolution tableEfficace = HBoxRoot.getTableEfficace();
        VBoxSolution tableExhaustive = HBoxRoot.getTableExhaustive();

        if (event.getSource() instanceof Button) {
            System.out.println("vous avez cliqué sur le bouton");

            // Modification des Labels labelSolution appartenant aux objets tableEfficace et tableExhaustive
            tableEfficace.setLabelSolution(formulaire.getNumScenarioSelectionne());
            tableExhaustive.setLabelSolution(formulaire.getNumScenarioSelectionne());

            // Création du scenario sélectionné
            File fichierScenario = formulaire.getScenarioSelectionne();
            NiveauUNParametre scenarioEnCour = new NiveauUNParametre(LectureFichierTexte.lecture(fichierScenario));

            ArrayList<Quete> solutionEfficaceEnCour = scenarioEnCour.solutionEfficace();
            tableEfficace.miseAJourTable(solutionEfficaceEnCour);

            ArrayList<Quete> solutionExhaustiveEnCour = scenarioEnCour.solutionExhaustive();
            tableExhaustive.miseAJourTable(solutionExhaustiveEnCour);



        }

    }
}
