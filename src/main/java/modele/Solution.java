package modele;

import java.util.ArrayList;

/**
 * Classe Solution.
 *
 * Cette classe contient les deux algorithmes permettant d'avoir une solution efficace et
 * exhaustive pour un scenario qui sera donné en parametre du constructeur de la classe.
 *
 * Cette classe contient les champs suivants :
 *  - ArrayList<Quete> quetesScenario       (liste des quetes du scenario en cours)
 *  - Quete queteFinale                     (quete finale du scenario)
 *  - int experienceAccumulee               (l'experience accumulee au fur et à mesure des solutions)
 *  - int experienceNecessaireQueteFinale   (l'experience necessaire pour realiser la quete finale)
 *  - ArrayList<Integer> quetesRealisee     (liste des quetes qui ont deja ete realisee)
 *  - Position positionDepart               (position de depart pour la realisation du scenario)
 *  - int x,y                               (coordonnées x et y pour la position de depart)
 *  - int dureeAccumulee                    (duree accumulee au fur et a mesure de la realisation du scenario)
 *  - String solutionString                 (details des solutions efficaces et exhaustive)
 *
 */
public class Solution {
    ArrayList<Quete> quetesScenario;
    Quete queteFinale;
    int experienceAccumulee = 0;
    int experienceNecessaireQueteFinale;
    ArrayList<Integer> quetesRealisee = new ArrayList<>();
    Position positionDepart;
    int x,y;
    int dureeAccumulee = 0;
    String solutionString = "\nDEPLACEMENTS\n";

    /**
     * Constructeur de la classe Solution.
     * Il reçoit en parametre un scenario ainsi que les coordonnee de depart.
     *
     * @param parScenario
     * @param parX
     * @param parY
     */
    public Solution(Scenario parScenario, int parX, int parY) {
        queteFinale = parScenario.queteFinale();
        experienceNecessaireQueteFinale = parScenario.queteFinale().getChExperience();
        quetesScenario = parScenario.getListeQuetes();
        x = parX;
        y = parY;
        positionDepart = new Position(parX,parY);
    }

    /**
     * Methode miseAJour.
     *
     * Cette methode sert a mettre a jour les differents champs afin de pouvoir
     * afficher une solution efficace et/ou exhaustive sans probleme.
     * C'est à dire à partir du même objet de la classe NiveauUNParametre.
     */
    private void miseAJour() {
        for (Quete quete : quetesScenario) {
            if (quete.chRealisee)
                quete.setChRealisee(false);
        }
        quetesRealisee = new ArrayList<>();
        dureeAccumulee = 0;
        experienceAccumulee = 0;
        positionDepart = new Position(x,y);
        solutionString = "DEPLACEMENTS\n";
    }

    /**
     * Methode estRealisee.
     *
     * Cette methode permet de verifier qu'une quete a bien ete realisee.
     * Plus precisement, elle verifie que le numero d'une quete se trouve bien dans la liste queteRealisee.
     *
     * @param precondition
     * @return boolean
     */
    private boolean estRealisee(int precondition) {
        return quetesRealisee.contains(precondition);
    }



    /**
     * Methode queteLaPlusProche_Efficace.
     *
     * Cette methode permet de retourner la quete la plus proche qui n'a pas encore ete effectuee
     * et dont les preconditions sont validees.
     *
     * Cette methode sera utilisée pour la solution efficace.
     *
     * @return Quete
     */
    private Quete queteLaPlusProche_Efficace() {
        Quete plusProche = queteFinale;
        int deplacementMin = 15000;
        for (Quete quete : quetesScenario) {
            if (!quete.estRealisee() && preconditionsValidee(quete)) {
                int deplacementEnCour = positionDepart.deplacement(quete.chPosition);
                if (deplacementEnCour <= deplacementMin)
                    plusProche = quete;
            }
        }
        return plusProche;
    }


    /**
     * Methode queteLaPlusProche_Exhaustive.
     *
     * Cette methode permet de retourner la quete la plus proche qui n'a pas encore ete effectuee,
     * dont les preconditions sont validees, mais qui n'est pas la queteFinale.
     *
     * Cette methode sera utilisee pour la solution exhaustive.
     *
     * @return Quete
     */
    private Quete queteLaPlusProche_Exhaustive() {
        Quete plusProche = queteFinale;
        int deplacementMin = 15000;
        for (Quete quete : quetesScenario) {
            if (!quete.estRealisee() && preconditionsValidee(quete) && !quete.estQueteFinale()) {
                int deplacementEnCour = positionDepart.deplacement(quete.chPosition);
                if (deplacementEnCour <= deplacementMin)
                    plusProche = quete;
            }
        }
        return plusProche;
    }


    /**
     * Methode scenarioFini.
     *
     * Cette methode permet de dire si toutes les quetes sont realisee.
     * Cette methode exclue la quete finale car elle sera utilisée pour la solution exhaustive.
     *
     * @return boolean
     */
    private boolean scenarioFini() {

        boolean reponse = true;
        for (Quete quete : quetesScenario) {
            if (!quete.estRealisee() && !quete.estQueteFinale()) {
                reponse = false;
                break;
            }
        }
        return reponse;
    }


    /**
     * Methode quetePreconditionsValidee.
     *
     * Cette methode permet de dire si les preconditions d'une quete sont validees ou non.
     *
     * Ici on parle des preconditions de quete, les verifications se font donc sur les champs
     * precond1,precond2,precond3 et precond4 du parametre parQuete.
     *
     * @param parQuete
     * @return boolean
     */
    private boolean quetePreconditionsValidee(Quete parQuete) {
        int nbPrecondition = parQuete.nbPreconditions();

        if (nbPrecondition == 2) {
            return ((estRealisee(parQuete.precond1) || estRealisee(parQuete.precond2)) && (estRealisee(parQuete.precond3) || estRealisee(parQuete.precond4)));
        }
        else if (nbPrecondition == 1) {
            return ((estRealisee(parQuete.precond1) || estRealisee(parQuete.precond2)));
        }
        else {
            return true;
        }
    }

    /**
     * Mehtode preconditionsValisee.
     *
     * Cette methode permet de dire si les preconditions de n'importe quelle quete sont validee ou non
     * (quete normale ou quete finale).
     *
     * Cette methode utilisera la methode quetePreconditionsValidee et comparera l'experience accumulee à l'experience nécessaire.
     *
     * @param parQuete
     * @return boolean
     */
    private boolean preconditionsValidee(Quete parQuete) {
        if (parQuete.estQueteFinale()) {
            return (experienceAccumulee >= experienceNecessaireQueteFinale && quetePreconditionsValidee(parQuete));
        }
        else {
            return quetePreconditionsValidee(parQuete);
        }
    }



    /**
     * Methode realisonLaQuete.
     *
     * Cette methode permet de realiser toutes les manipulations necessaires a la realisation d'une quete.
     * Cette methode va construire le champ solutionString et renvoyer ce champ qui est une chaîne de caractère qui representera l'historique des déplacement et des quetes realisée.
     *
     * @param parQuete
     * @param solution
     * @return String
     */
    private String realisonLaQuete(Quete parQuete, ArrayList<Quete> solution) {

        // ex : (+7 : deplacement de (0,0) a (4,3))
        String ligneDeplacement = "";

        // ex : (+2 : quete 1 (total xp : 100))
        String ligneQuete = "";

        if (preconditionsValidee(parQuete)) {

            // Ce bloc sert à mettre à jour la durée totale, mettre à jour la prochaine position de depart
            // ainsi que construire la chaîne de caractère ligneDeplacement
            int dureeDeplacement = positionDepart.deplacement(parQuete.chPosition);
            dureeAccumulee += dureeDeplacement + parQuete.getChDuree();
            Position positionDeplacement = parQuete.getChPosition();
            ligneDeplacement += "\n+" + dureeDeplacement + " : deplacement de " + positionDepart + " a " + positionDeplacement;
            positionDepart = positionDeplacement;

            // Dans ce bloc, on ajoute la quete à la solution et on déclare la solution comme étant réalisée
            solution.add(parQuete);
            quetesRealisee.add(parQuete.getChNumero());
            parQuete.setChRealisee(true);

            if (!parQuete.estQueteFinale())
                experienceAccumulee += parQuete.getChExperience();

            // Construction de la chaîne de caractère ligneQuete
            ligneQuete += "\n+" + parQuete.getChDuree() + " : quete " + parQuete.getChNumero() + " (total xp : " + experienceAccumulee + ")";
        }

        solutionString += ligneDeplacement + ligneQuete;
        return solutionString;
    }





    /**
     * La methode solutionEfficace() renvoie une ArrayList avec les quetes dans l'ordre pour une solution efficace ("gloutonne").
     *
     * @return ArrayList<Quete>
     */
    public ArrayList<Quete> solutionEfficace() {
        miseAJour();
        ArrayList<Quete> solution = new ArrayList<>();

        while (!queteFinale.estRealisee()) {
            Quete queteARealiser = queteLaPlusProche_Efficace();

            if (preconditionsValidee(queteFinale))
                solutionString = realisonLaQuete(queteFinale, solution);
            else
                solutionString = realisonLaQuete(queteARealiser, solution);
        }

        solutionString += "\n\nRAPPORT :\n\nDuree totale = " + dureeAccumulee + "\nexperience totale = " + experienceAccumulee + "\nNombre de quetes realisees = " + solution.size()+"/"+quetesScenario.size();
        return solution;

    }

    /**
     * la methode solutionexhaustive() renvoie une ArrayList avec les quetes dans l'ordre pour une solution exhaustive ("gloutonne")
     *
     * @return ArrayList<Quete>
     */
    public ArrayList<Quete> solutionExhaustive() {
        miseAJour();
        ArrayList<Quete> solution = new ArrayList<>();

        while (!scenarioFini()) {
            solutionString = realisonLaQuete(queteLaPlusProche_Exhaustive(), solution);
        }
        if (preconditionsValidee(queteFinale))
            solutionString = realisonLaQuete(queteFinale, solution);
        else
            System.out.println("Toutes les quêtes préalables ont ete realisee - Impossible de proposer une solution exhaustive ");

        solutionString += "\n\nRAPPORT :\nDuree totale = " + dureeAccumulee + "\nexperience totale = " + experienceAccumulee + "\nNombre de quetes realisees = " + solution.size()+"/"+quetesScenario.size();
        return solution;
    }

    /**
     * Accesseur sur le champ solutionString.
     * @return String
     */
    public String getSolutionString() {
        return solutionString;
    }

}
