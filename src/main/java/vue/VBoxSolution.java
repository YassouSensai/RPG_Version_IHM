package vue;


import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.Position;
import modele.Quete;

import java.util.ArrayList;

public class VBoxSolution extends VBox {

    public Label labelSolution;
    public TableView<Quete> tableDesQuetes;
    private String efficace_ou_exhaustive;

    public VBoxSolution(String par_eff_ou_exh) {
        efficace_ou_exhaustive = par_eff_ou_exh;
        if (efficace_ou_exhaustive == "eff") {
            labelSolution = new Label("Solution efficace du scenario ");
        }
        else {
            labelSolution = new Label("Solution exhaustive du scenario ");
        }


        tableDesQuetes = new TableView<>();
        TableColumn <Quete, Integer> numColumn = new TableColumn<>("Numero");
        TableColumn <Quete, String> intituleColums = new TableColumn<>("Intitule");
        TableColumn <Quete, Position> positionColum = new TableColumn<>("Position");

        numColumn.setCellValueFactory(new PropertyValueFactory<>("chNumero"));
        intituleColums.setCellValueFactory(new PropertyValueFactory<>("chIntitule"));
        positionColum.setCellValueFactory(new PropertyValueFactory<>("chPosition"));

        tableDesQuetes.getColumns().add(numColumn);
        tableDesQuetes.getColumns().add(intituleColums);
        tableDesQuetes.getColumns().add(positionColum);




        this.getChildren().add(labelSolution);
        this.getChildren().add(tableDesQuetes);
    }


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
