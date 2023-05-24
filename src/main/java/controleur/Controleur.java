package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vue.GridPaneFormulaire;
import vue.HBoxRoot;

public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {
        GridPaneFormulaire formulaire = HBoxRoot.getFormulaire();

        if (event.getSource() instanceof Button) {
            System.out.println("vous avez cliqué sur le bouton");
        }

    }
}
