package modele;

import static java.lang.Math.abs;

/**
 * Classe Position.
 *
 * Cette classe permet d'instancier des position, c'est à dire des objets
 * avec des champs x et y qui correspondent aux coordonnées d'une quete.
 *
 * Cette methode contient les champs suivants :
 *  - int x,y   (coordonnee (abscisse et ordonnee)
 *
 */
public class Position {
    int x, y;


    /**
     * Constructeur de la classe Position a partir des coordonnées x et y.
     *
     * @param parX
     * @param parY
     */
    public Position(int parX, int parY) {
        x = parX;
        y = parY;
    }

    /**
     * Accesseur sur le champ x.
     * @return int
     */
    public int getX() {return x;}

    /**
     * Accesseur sur le champ y.
     * @return int
     */
    public int getY() {return y;}

    /**
     * Methode deplacement.
     *
     * La methode deplacement() renvoi le nombre d'unite de temps que necessite
     * le deplacement de la position appelante a la position en parametre.
     *
     * @param parPosition
     * @return int
     */
    public int deplacement(Position parPosition) {
        return abs(this.x - parPosition.getX()) + abs(this.y - parPosition.getY());
    }

    /**
     * Methode toString de la classe Position.
     * @return String
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
