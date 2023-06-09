package modele;

import java.util.ArrayList;

/**
 * Classe Scenario
 *
 *  Cette classe permet de créer un scenario, notemment a partir de la lecture d'un scenario
 *  au format txt grâce a la classe LectureFichierTexte. Cette classe contient 1 champ ;
 *
 *  - ArrayList<Quete> listeQuetes      liste des quetes, ce qui constitue le scenario
 */
public class Scenario {
    ArrayList<Quete> listeQuetes;

    /**
     * Constructeur de la classe Scenario.
     */
    public Scenario(){
        listeQuetes = new ArrayList<Quete>();
    }

    /**
     * La methode ajout de cette classe permet d'ajouter une quete au scenario (au champ listeQuetes).
     *
     * @param quete
     */
    public void ajout(Quete quete) {
        listeQuetes.add(quete);
    }

    /**
     * Cette methode est un accesseur, elle retourne la liste des quetes du scenario appelant.
     *
     * @return chQuetes
     */
    public ArrayList<Quete> getListeQuetes() {
        return listeQuetes;
    }

    /**
     * La methode queteFinale() renvoi la quete finale du scenario
     * c'est à dire la quete qui possède le numéro 0.
     *
     * @return Quete
     */
    public Quete queteFinale() {
        Quete queteZero = null;
        for (Quete quete : listeQuetes) {
            if (quete.estQueteFinale()) {
                queteZero = quete;
            }
        }
        return queteZero;
    }

    /**
     * Methode toString de la classe Scenario.
     * Elle permet d'afficher toutes les quêtes du scenario de la partie.
     *
     * @return String
     */
    public String toString() {
        return(listeQuetes.size() + " " + listeQuetes.toString());
    }
}
