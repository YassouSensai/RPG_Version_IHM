package vue;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import constantes.Constantes_IHM;

import java.io.File;


/**
 * Classe GridPaneFormulaire.
 *
 * Cette classe herite de la classe GridPane et implemente l'interface Constantes_IHM. Elle permet
 * d'instancier des objets de la classe GridPane et qui permettrons de parametrer les solutions.
 *
 * Cette classe contient 3 champs ;
 *  - ComboBox<String> comboBoxChoisDuScenario              pour le choix du scenario
 *  - TextField textFieldPositionX, textFieldPositionY      pour le choix de la position de depart
 */
public class GridPaneFormulaire extends GridPane implements Constantes_IHM {

    ComboBox<String> comboBoxChoisDuScenario;
    TextField textFieldPositionX, textFieldPositionY;


    /**
     * Constructeur de la classe GridPaneFormulaire.
     */
    public GridPaneFormulaire() {

        // Parametrage de l'espacement entre les elements
        this.setHgap(10);
        this.setVgap(20);

        // Instanciation + ajout du titre
        Label labelTitle = new Label("Veuillez paramétrer votre simulation !");
        this.add(labelTitle, 2, 1, 5, 1);

        // Instanciation + ajout du champ comboBoxChoixDuScenario
        Label labelCombo = new Label("Choix du scenario : ");
        comboBoxChoisDuScenario = peupleComboBox(LISTE_SCENARIOS);
        comboBoxChoisDuScenario.setValue("scenario 0");
        this.add(labelCombo, 2, 3);
        this.add(comboBoxChoisDuScenario, 3, 3);

        // Instanciation des labels pour les coordonnées + des champs textFieldPositionX et textFieldPositionY
        Label labelCoordonnee = new Label("Choix des coordonnées :");
        Label labelX = new Label("x :");
        Label labelY = new Label("y :");
        textFieldPositionX = new TextField("0");
        textFieldPositionY = new TextField("0");

        // Ajout des labels pour les coordonnées + des champs textFieldPositionX et textFieldPositionY
        this.add(labelCoordonnee, 2, 4);
        this.add(labelX, 3, 4);
        this.add(textFieldPositionX, 4, 4);
        this.add(labelY, 3, 5);
        this.add(textFieldPositionY, 4, 5);

        // Instanciation + ajout du bouton pour la simulation des solutions
        Button boutonSimuler = new Button("Simuler");
        boutonSimuler.setUserData("Simuler");
        boutonSimuler.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());
        this.add(boutonSimuler, 2, 6);

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

    /**
     * Méthode getNumScenarioSelectionne
     *
     * Cette méthode renvoi le numéro du scenario séléctionné.
     * Cette méthode sera utilisée pour mettre à jour les labels pour l'affichage des solutions.
     * @return int
     */
    public int getNumScenarioSelectionne() {
        return comboBoxChoisDuScenario.getSelectionModel().getSelectedIndex();
    }

    /**
     * Methode qui permet de reccuperer ce qui a ete inséré dans le champ textFieldPositionX
     * @return int
     */
    public int getPosX() {
        return Integer.parseInt(textFieldPositionX.getText());
    }

    /**
     * Methode qui permet de reccuperer ce qui a ete inséré dans le champ textFieldPositionY
     * @return int
     */
    public int getPosY() {
        return Integer.parseInt(textFieldPositionY.getText());
    }

}
