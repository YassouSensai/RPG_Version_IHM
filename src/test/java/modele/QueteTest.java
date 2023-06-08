package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe QueteTest.
 *
 * Cette classe contient des methodes de test pour certaines methodes de la classe Quete ;
 *  - estQueteFinale()
 *  - nbPreconditions()
 *  - estRealisee()
 *  - getChNumero()
 *  - getChExperience()
 *  - getChIntitule()
 *  - getChPosition()
 */
class QueteTest {
    
    void estQueteFinale() {
        System.out.println("Test de la methode estQuesteFinale");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"), new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim")};
        boolean [] tabReponses = {false, true};

        for (int i=0; i < tabQuetes.length; i++) {
            assertTrue(tabQuetes[i].estQueteFinale() == tabReponses[i]);
        }
    }


    @Test
    void nbPreconditions() {
        System.out.println("Test de la methode nbPreconditions");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"), new Quete("0|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire")};
        int [] tabReponses = {0,1};

        ArrayList<Quete> tabQuetesV2 = new LectureFichierTexte().lecture(new File("scenarios"+ File.separator+"scenario_1.txt")).getListeQuetes();
        int[] tabReponsesV2 = {1,2,2,0,0,1};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabReponses[i], tabQuetes[i].nbPreconditions());
        }

        for (int i=0; i<tabReponsesV2.length; i++) {
            assertEquals(tabReponsesV2[i], tabQuetesV2.get(i).nbPreconditions());
        }
    }

    @Test
    void estRealisee() {
        System.out.println("Test de la methode estRealisee()");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"), new Quete("0|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire")};
        tabQuetes[0].setChRealisee(true);
        boolean [] tabreponses = {true, false};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabQuetes[i].chRealisee, tabreponses[i]);
        }

    }



    @Test
    void getChNumero() {
        System.out.println("Test de la methode getChNumero");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"),
                              new Quete("0|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire"),
                              new Quete("3|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire"),
                              new Quete("9|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire"),
                              new Quete("15|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire")};
        int [] tabreponses = {1, 0, 3, 9, 15};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabreponses[i], tabQuetes[i].getChNumero());
        }
    }

    @Test
    void getChDuree() {
        System.out.println("Test de la methode getChDuree");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"),
                new Quete("0|(1, 1)|((3,4),)|4|350|vaincre Araignée lunaire"),
                new Quete("3|(1, 1)|((3,4),)|6|350|vaincre Araignée lunaire"),
                new Quete("9|(1, 1)|((3,4),)|9|350|vaincre Araignée lunaire"),
                new Quete("15|(1, 1)|((3,4),)|128|350|vaincre Araignée lunaire")};
        int [] tabreponses = {2, 4, 6, 9, 128};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabreponses[i], tabQuetes[i].getChDuree());
        }
    }

    @Test
    void getChExperience() {
        System.out.println("Test de la methode getChExperience");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"),
                new Quete("0|(1, 1)|((3,4),)|4|100|vaincre Araignée lunaire"),
                new Quete("3|(1, 1)|((3,4),)|6|250|vaincre Araignée lunaire"),
                new Quete("9|(1, 1)|((3,4),)|9|75|vaincre Araignée lunaire"),
                new Quete("15|(1, 1)|((3,4),)|128|575|vaincre Araignée lunaire")};
        int [] tabreponses = {100, 100, 250, 75, 575};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabreponses[i], tabQuetes[i].getChExperience());
        }
    }

    @Test
    void getChIntitule() {
        System.out.println("Test de la methode getChIntitule");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"),
                new Quete("0|(1, 1)|((3,4),)|4|100|saluer le grand mage"),
                new Quete("3|(1, 1)|((3,4),)|6|250|exterminer la sorciere"),
                new Quete("9|(1, 1)|((3,4),)|9|75|luter contre le chevalier reptilien"),
                new Quete("15|(1, 1)|((3,4),)|128|575|nourir des orphelins")};
        String [] tabreponses = {"explorer pic de Bhanborim", "saluer le grand mage", "exterminer la sorciere", "luter contre le chevalier reptilien", "nourir des orphelins"};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabreponses[i], tabQuetes[i].getChIntitule());
        }
    }

    @Test
    void getChPosition() {
        System.out.println("Test de la methode getChPosition");

        Quete [] tabQuetes = {new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim"),
                new Quete("0|(1, 1)|((3,4),)|4|100|saluer le grand mage"),
                new Quete("3|(6, 15)|((3,4),)|6|250|exterminer la sorciere"),
                new Quete("9|(256, 5)|((3,4),)|9|75|luter contre le chevalier reptilien"),
                new Quete("15|(3, 129)|((3,4),)|128|575|nourir des orphelins")};
        Position [] tabreponses = {tabQuetes[0].getChPosition(), tabQuetes[1].getChPosition(), tabQuetes[2].getChPosition(), tabQuetes[3].getChPosition(), tabQuetes[4].getChPosition()};

        for (int i=0; i < tabQuetes.length; i++) {
            assertEquals(tabreponses[i], tabQuetes[i].getChPosition());
        }
    }
}