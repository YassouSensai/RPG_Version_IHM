module com.example.rpg_version_ihm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.example.rpg_version_ihm to javafx.fxml;
    exports com.example.rpg_version_ihm;
    exports modele;
    exports vue;
    exports controleur;
    exports constantes;


}