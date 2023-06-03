package vue;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.Position;
import modele.Quete;

import java.util.ArrayList;


/**
 * Classe VBoxSolution.
 *
 * Cette classe herite de la classe VBox et permettra d'instancier des objet de la classe VBox.
 * Ces objets permettrons d'afficher les suites de quetes qui correspondent aux solutions.
 *
 * Cette classe possède 3 champs ;
 *  - Label labelSolution                   qui sera le "titre"
 *  - TableView<Quete> tableDesQuetes       qui contiendra les quetes dans l'ordre (c'est la solution)
 *  - String efficace_ou_exhaustive         qui permet de savoir s'il s'agit d'une solution efficace ou exhaustive
 */
public class VBoxSolution extends VBox {

    public Label labelSolution;
    public TableView<Quete> tableDesQuetes;
    private String efficace_ou_exhaustive;

    /**
     * Constructeur de la classe VBoxSolution.
     * @param par_eff_ou_exh
     */
    public VBoxSolution(String par_eff_ou_exh) {

        // Instanciation des champs efficace_ou_exhaustive et labelSolution
        efficace_ou_exhaustive = par_eff_ou_exh;
        if (efficace_ou_exhaustive == "eff") {
            labelSolution = new Label("Solution efficace du scenario ");
        }
        else {
            labelSolution = new Label("Solution exhaustive du scenario ");
        }

        // Instanciation du champ tableDesQuetes + cration des colonnes de la TableView
        tableDesQuetes = new TableView<>();
        TableColumn <Quete, Integer> numColumn = new TableColumn<>("Numero");
        TableColumn <Quete, String> intituleColums = new TableColumn<>("Intitule");
        TableColumn <Quete, Position> positionColum = new TableColumn<>("Position");

        numColumn.setCellValueFactory(new PropertyValueFactory<>("chNumero"));
        intituleColums.setCellValueFactory(new PropertyValueFactory<>("chIntitule"));
        positionColum.setCellValueFactory(new PropertyValueFactory<>("chPosition"));

        // Ajout des colonnes
        tableDesQuetes.getColumns().add(numColumn);
        tableDesQuetes.getColumns().add(intituleColums);
        tableDesQuetes.getColumns().add(positionColum);

        // Creation du bouton qui permettra d'afficher les details de la solution (objets de la classe SceneDetailSolution)
        Button boutonDetail = new Button("Afficher les détails");
        boutonDetail.setUserData(efficace_ou_exhaustive);
        boutonDetail.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());

        // Ajout des differents elements à la VBox
        this.getChildren().add(labelSolution);
        this.getChildren().add(tableDesQuetes);
        this.getChildren().add(boutonDetail);
    }


    /**
     * Méthode miseAJourTable.
     *
     * Cette méthode permet de mettre à jour la tableDesQuetes lorsque l'utilisateur appuis sur le bouton simuler.
     * @param solutionEfficaceEnCour
     */
    public void miseAJourTable(ArrayList<Quete> solutionEfficaceEnCour) {
        tableDesQuetes.getItems().clear();

        for (Quete quete : solutionEfficaceEnCour) {
            tableDesQuetes.getItems().add(quete);
        }
    }


    /**
     * Accesseur sur le champ labelSolution.
     * @return Label
     */
    public Label getLabelSolution() {
        return labelSolution;
    }



    /**
     * Muttateur sur le champ labelSolution.
     * @param numScenario
     */
    public void setLabelSolution(int numScenario) {

        if (efficace_ou_exhaustive == "eff") {
            labelSolution.setText("Solution efficace du scenario "+numScenario+". ");
        }
        else {
            labelSolution.setText("Solution exhaustive du scenario "+numScenario+". ");
        }
    }

}
