package vue;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Constantes_IHM;

import java.io.File;

public class GridPaneFormulaire extends GridPane implements Constantes_IHM {

    ComboBox<String> comboBoxChoisDuScenario;

    public GridPaneFormulaire() {
        this.setHgap(20);
        this.setVgap(20);

        Label labelTitle = new Label("Veuillez paramétrer votre simulation !");
        this.add(labelTitle, 2, 1, 5, 1);

        Label labelCombo = new Label("Choix du scenario : ");
        comboBoxChoisDuScenario = peupleComboBox(LISTE_SCENARIOS);
        comboBoxChoisDuScenario.setValue("scenario 0");

        this.add(labelCombo, 2, 3);
        this.add(comboBoxChoisDuScenario, 3, 3);

        Label labelCoordonnee = new Label("Choix des coordonnées :");
        Label labelX = new Label("x :");
        Label labelY = new Label("y :");
        TextField textFieldPositionX = new TextField();
        TextField textFieldPositionY = new TextField();


        this.add(labelCoordonnee, 2, 4);
        this.add(labelX, 3, 4);
        this.add(textFieldPositionX, 4, 4);

        this.add(labelY, 3, 5);
        this.add(textFieldPositionY, 4, 5);


        Button bouttonSimuler = new Button("Simuler");
        bouttonSimuler.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());

        this.add(bouttonSimuler, 2, 6);




    }

    /**
     * Méthode peupleComboBox de la classe GridPaneFormulaire.
     *
     * Cette méthode permet de créer, de remplir un comboBox.
     * Elle est utile pour mettre la comboBox pour le choix du scenarios.
     * @param strings
     * @return
     */
    private ComboBox<String> peupleComboBox (String[]strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for (String string : strings) {
            comboBox.getItems().add(string);
        }
        return comboBox;
    }

    /**
     * Méthode getScenarioSelectionne.
     *
     * Cette méthode permer de retourner le scenario séléctionné pour la simulation.
     * @return File
     */
    public File getScenarioSelectionne() {
        String nomfichier = "scenario_";
        nomfichier += comboBoxChoisDuScenario.getSelectionModel().getSelectedIndex();
        nomfichier +=".txt";

        return new File("scenarios" + File.separator + nomfichier);
    }

}
