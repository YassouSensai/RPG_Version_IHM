package modele;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe solutionTest.
 *
 * Cette classe contient des methode de test pour certaines methodes de la classe Solution.
 *  - solutionEfficace()
 *  - solutionExhaustive()
 */
class SolutionTest {


    /**
     * Methode de test pour la methode solutionEfficace de la classe Solution.
     * Cette methode va verifier ;
     *  - si la quete finale est bien presente dans la solution.
     *  - si la taille de la solution est bien inferieure ou egale au nombre de solutions.
     */
    @Test
    void solutionEfficace() {
        System.out.println("Test de la methode solutionEfficace");

        File[] tabFichierScenario = {new File("scenarios"+File.separator+"scenario_0.txt"),
                new File("scenarios"+File.separator+"scenario_1.txt"),
                new File("scenarios"+File.separator+"scenario_2.txt"),
                new File("scenarios"+File.separator+"scenario_3.txt"),
                new File("scenarios"+File.separator+"scenario_4.txt")};
        Scenario[] tabScenario = new Scenario[5];
        Solution[] tabSolution = new Solution[5];

        for (int i = 0; i < tabFichierScenario.length; i++) {
            System.out.println("\n\nScenario "+i);
            tabScenario[i] = new LectureFichierTexte().lecture(tabFichierScenario[i]);
            tabSolution[i] = new Solution(tabScenario[i], 0, 0);
            ArrayList<Quete> solution = tabSolution[i].solutionEfficace();

            assertEquals(solution.get(solution.size()-1),tabScenario[i].getListeQuetes().get(tabScenario[i].getListeQuetes().size()-1));
            System.out.println("La quete finale a bien été réalisée !");

            assertTrue(solution.size() <= tabScenario[i].getListeQuetes().size());
            System.out.println("La taille de la solution est bien cohérente avec le nombre de quetes disponibles !");
        }
    }


    /**
     * Methode de test pour la methode solutionEfficace de la classe Solution.
     * Cette methode va verifier ;
     *  - si la quete finale est bien presente dans la solution.
     *  - si la taille de la solution est bien egale au nombre de solutions.
     *  - si toutes les quetes ont bien ete effectuee.
     */
    @Test
    void solutionExhaustive() {
        System.out.println("Test de la methode solutionExhaustive");

        File[] tabFichierScenario = {new File("scenarios"+File.separator+"scenario_0.txt"),
                                     new File("scenarios"+File.separator+"scenario_1.txt"),
                                     new File("scenarios"+File.separator+"scenario_2.txt"),
                                     new File("scenarios"+File.separator+"scenario_3.txt"),
                                     new File("scenarios"+File.separator+"scenario_4.txt")};
        Scenario[] tabScenario = new Scenario[5];
        Solution[] tabSolution = new Solution[5];

        for (int i = 0; i < tabFichierScenario.length; i++) {
            System.out.println("\n\nScenario "+i);
            tabScenario[i] = new LectureFichierTexte().lecture(tabFichierScenario[i]);
            tabSolution[i] = new Solution(tabScenario[i], 0, 0);
            ArrayList<Quete> solution = tabSolution[i].solutionExhaustive();

            assertEquals(solution.get(solution.size()-1),tabScenario[i].getListeQuetes().get(tabScenario[i].getListeQuetes().size()-1));
            System.out.println("La quete finale a bien été réalisée !");

            assertEquals(solution.size(), tabScenario[i].getListeQuetes().size());
            System.out.println("La taille de la solution est bien cohérente avec le nombre de quetes disponibles !");

            for (Quete quete : tabScenario[i].getListeQuetes()){
                assertTrue(solution.contains(quete));
            }
            System.out.println("Toutes les quetes ont été réalisée !");
        }
    }
}