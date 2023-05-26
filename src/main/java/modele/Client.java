package modele;

import java.io.File;

public class Client {
    public static void main (String [] args) {


        File fichierScenario0 = new File("scenarios"+ File.separator+"scenario_0.txt");

        LectureFichierTexte premiereLecture = new LectureFichierTexte();
        Scenario scenario0 = LectureFichierTexte.lecture(fichierScenario0);

        System.out.println("\ntest affichage 1");
        System.out.println(scenario0);

        System.out.println("\ntest affichage 2");
        System.out.println(scenario0.listeQuetes.get(0).estQueteFinale());


        System.out.println("\ntest affichage 3");
        System.out.println(new NiveauUNParametre(scenario0, 0, 0));



        System.out.println("\ntest affichage 6");
        Quete test1 = scenario0.getListeQuetes().get(1);
        Quete test2 = scenario0.getListeQuetes().get(1);
        System.out.println(test1 == test2);


        System.out.println("\ntest affichage 7");
        NiveauUNParametre niveauUNTest = new NiveauUNParametre(scenario0, 0, 0);
        System.out.println(niveauUNTest.solutionEfficace());
        System.out.println(niveauUNTest.solutionExhaustive());


    }
}
