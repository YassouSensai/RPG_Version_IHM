# <p align="center">RPG_Version_IHM : *SAE Exploration Algorithmique*</p>
![Page_Acueil.png](Images%2FPage_Acueil.png)  

>### But du RPG
>>Dans ce RPG simplifié, un joueur reçoit une liste de quêtes que l'on appelle scenario.
>Le but est donc de réaliser la quête finale du scenario. Mais pour cela, il faut avoir rempli
>des préconditions ainsi qu'avoir accumulé suffisament de points d'experience.  
>Il faut donc proposer la meilleure solution pour finir le scenario !  
> 
>*Note : afin de consulter la/les solution(s), une IHM (Interface Homme Machine) a été réalisée.*


## 🛠️ Sommaire
1. **Brève présentation de l'application réalisée**
2. **Gestion de la qualité de développement**
    - **Repartition des tâches**
    - **Outils utilisés**
    - **Notre méthode de développement**
3. **Conception génerale du projet**
    - **Diagramme des classes de haut niveau**
    - **Diagramme des classes par package**
    - **Présentation des structures de données + des stratégies**
4. **Conclusion**
5. **Annexe**

## 1 -🧑🏻‍💻 L'application  
![Application.png](Images%2FApplication.png)

>Dans l'application réalisée, une proposition de solution correspon à une simulation.
> Ainsi, dans la partie qui se trouve à gauche de l'application, nous avons la possibilité
> de "parametrer la simulation", c'est à dire ;  
> - Choisir le scenario.
> - Choisir les coordonées de départ.  
>  
> Une fois que l'on clique sur le bouton simuler, les quêtes s'affichent dans l'ordre de la solution
> (efficace ou exhaustive) dans les deux tableaux qui se trouvent à droite.  
> 
> *Exemple avec le scenario 0 et les coordonnées de départ suivantes : (0,0)*

![Scenario_0.png](Images%2FScenario_0.png)

>Nous pouvons également consulter les détails d'une solution en cliquant sur le bouton 
> *"Afficher les details"*  
> 
> *Exemple pour la solution efficace de l'exemple si dessus :*

![Detail_Scenario_0.png](Images%2FDetail_Scenario_0.png)

*Note : Notre groupe n'est allé que jusqu'au premier niveau de réalisation, c'est à dire, 
de proposer une solution efficace et exhaustive gloutonne.*  

#### Important : Afin de lancer l'application, il faut éxecuter la classe ApplicationIHM du package vue.

# 2 - 🙇 Qualité de développement
### *Répartition des tâches*
>Suite à la *SAE 2.05 - Gestion d'un projet*, l'organisation du travail entre les deux
> membres du groupe était la suivante :  
> 
> Les deux membres du groupe devaient participer à la réalisation de la plus part des tâches.
> Et voici à quoi ressemblait notre organisation :

![Organisation.png](Images%2FOrganisation.png)

> ***Egalement, Mohamed Lamine tient à mentionner quelque chose d'important :***
>
> ***Le projet n'a pas pu être réalisé selon nos souhaits initiaux, et nous n'avons pas pu utiliser tous les outils de collaboration
> prévus pour la SAE Gestion de Projet.  
> Mes absences ont ralenti la progression du projet, et je n'ai pas non plus disposé de toutes les compétences
> et connaissances nécessaires.  
> Yassine a dû consacrer beaucoup de temps à m'expliquer des choses et à relire mon travail. Ces facteurs ont contribué à la non
> réalisation du projet dans son ensemble.***

### *Outils utilisés*
>Pour la réalisation de ce projet, nous avons utilisé plusieurs outils qui se sont
> montré indispensables.  
> 1. InteliJ : C'est l'IDE qui nous à permis de tout produire (code et compte-rendu).
> 2. GitHub : C'est le service qui nous a permis de versionner notre projet avec Git.
>>#### InteliJ + GitHub :
>>L'utilisation de GitHub avec InteliJ nous a grandement simplifié la réalisation du projet. 
> En effet, il nous a suffi de créer un dépot vide sur GitHub, puis de créer le projet sur InteliJ 
> à partir du dépot GitHub.    
> Cela nous a permis de mieux gérer les commits (Points de contrôles), les branches, les fusions, ...
> grâce à une interface (InteliJ) qui nous a permis de versionner notre projet.  
>   
> 
> 3. Junit : C'est un framework qui nous a permis de faire les tests unitaires en java pour les classes du package modèle.
>>#### Intégration de Junit dans notre projet :
>>Afin de pouvoir utiliser Junit pour réaliser nos tests unitaires, nous avons
> ajouté les dépendances de Junit dans le fichier *pom.xml* (voir ci-dessou)  
>  
> 
> ![dependance_1.png](Images%2Fdependance_1.png)
> ![properties_dependance_1.png](Images%2Fproperties_dependance_1.png)
> 
> *Note : [En savoir plus sur le fichier pom.xml](https://chat.openai.com/share/d48ef608-722c-4d0a-b9a0-690941cf651c)*

### *Méthode de développement*
>Tout d'abord, suite au TP5 de Qualité de Développement, nous avons décidé de créer un 
> projet pour la partie algorithmique du RPG aisni que la production de tests, puis créer un
> projet pour la partie IHM du RPG.  
>   
> Ainsi, nous avons d'abord commencé par développer les classes qui nous ont permis de lire les 
> fichiers textes et de les utiliser comme scenario. Puis, nous avons commencé par créer les méthodes
> dont nous aurions besoins (avec la doc, sans les compléter). Nous avons ensuite créé les tests de certaines méthodes
> pour finalement compléter l'algorithme des methods.  
>   
> *A prendre en compte : A cause de la precipitation, certaines méthodes ont été complétée avant d'avoir créé les tests.* 
>   
> Finalement, nous avons créé le projet pour l'IHM, développé l'IHM et intégré (+ compléter) les classes de test.
>   
> *Important : Le liens vers les deux dépôts GitHub seront présents dans l'annexe puisque le premier dépôt contient la quasi-totalité
des commits concernant l'algorithme de notre RPG.*
> 
> Pour être plus précis par rapport à notre méthode de développement, nous avons d'abord créé les premières classes incomplètes sur la branche main
> de notre projet. Puis pour le niveau 1, nous avons créé une nouvelle branche à partir de la branche main. Ainsi, une fois le niveau 1 terminé
> nous avons fusionné la branche du niveau 1 avec la branche main, puis nous avons créé une branche pour le niveau 2.  
>
> Egalement, nous tenons à mentionner qu'à cause d'un manque de reflexion, la procédure entamée au départ afin de résoudre les problèmes algorithmiques
> nous a fait perdre énormément de temps, puisque celle-ci n'était pas cohérente avec les différents niveaux de réalisation, et elle n'était pas éfficace.


## 3 - 🔧 Conception Generale 
*Note : Les différents diagrammes ont été réalisé avec la version gratuite du logiciel StarUML*
### *Diagramme des classes de haut niveau*
![UML_projet.png](UMLs%2FUML_projet.png)
### *Diagramme des classes par package*

#### *package modele :*
![UML_modele.png](UMLs%2FUML_modele.png)

#### *package vue :*
![UML_vue.png](UMLs%2FUML_vue.png)

#### *package controleur :*
![UML_controleur.png](UMLs%2FUML_controleur.png)  

### *Présentation des structures de données et de nos stratégies*
#### *Structures de données :*

> Pour pouvoir proposer des solutions, il faut pouvoir stocker les suites de quêtes dans une structure de données.
> Ainsi, compte tenu du niveau de réalisation que nous avons atteint, afin de stocker les suites de quêtes correspondant aux solutions,
> nous avons opté pour l'utilisation des ArrayList !
> 
> La manipulation des ArrayList est très simple et permet de pouvoir stocker au fur et à mesure les différentes quêtes qui constituent les solutions.
> 
> Nous avons également choisi d'utiliser les ArrayList car cela nous simplifie l'affichage des quêtes dans notre IHM. En effet, pour afficher nos quêtes
> nous avons choisi d'utiliser des TableView. Ainsi pour afficher nos solutions dans les deux TableView, nous avons juste à parcourir notre ArrayList et
> ajouter les quêtes aux TableView.  
> *(Note : Cette opération est réalisée par l'appel de la méthode miseAJour() de la classe VBoxSolution dans le contrôleur)*  
> 
> En plus des ArrayList, les détails des solutions (déplacements, xp, durée, ...) est stocké dans une String (champ solutionString de la classe Solution).
> Cette String est affichée lorsque l'on clique sur le bouton *"Afficher les details"*.

#### *Stratégies algorithmiques :*
*Note : La proposition de solution se fait grâce à la classe Solution. Ainsi, toutes les méthodes qui constituent les algorithmes pour les solutions efficaces et exhaustives
se trouvent dans cette classe.*

##### *Solution Efficace :*

>Afin de pouvoir proposer une solution efficace, voici notre algorithme :  
> 1. Tant que la quête finale n'est pas réalisée :
>     1. Si les conditions de la quête finale sont validées -> on réalise la quête finale.
>     2. Aussi non, on réalise la quête la plus proche.

##### *Solution Exhaustive :*

>L'algorithme de la solution exhaustive n'est pas si différent que celui de la solution efficace. 
> Mais ici, on cherche à réaliser toutes les quêtes et il faut que la quête finale soit la dernière.
> Voici l'algorithme :  
> 1. Tant que toutes les quêtes (sauf la quête finale) ne sont pas réalisée :
>     1. On réalise la quête disponible la plus proche.
> 2. Si les conditions de la quête finale sont validées -> on réalise la quête finale
> 3. Aussi non, on affiche un message d'erreur.  


## 4 - 💡 Conclusion  

> ### Bilan :
>> En conclusion, nous avons réalisé une application (interface) qui permet de visionner les solutions demandées pour le RPG.
>Derrière l'interface, se trouve :  
> 1. L'utilisation d'un conteneur de classe HBox qui contient tous les éléments de l'application.
> 2. L'utilisation d'un GridPane pour pouvoir parameter nos solutions.
> 3. L'utilisation de deux TableView pour pouvoir visionner les quêtes de nos solutions.
> 4. L'utilisation d'une autre "mini-application" pour consulter les détails des solutions.  
>>Ainsi l'interface interragit avec l'algorithme grâce au controleur du projet. Derrière l'algorithme se trouve :  
> 1. L'utilisation de 4 classes qui permettent de lire les fichiers textes, de manipuler les scenarios et les quêtes.
> 2. L'utilisation d'une classe (Solution) qui contient les algorithmes pour les solutions efficaces et exhaustives.  
>>Ainsi, pour la réalisation du projet RPJ_Version_IHM, nous avons utiliser le modèle de conception MVC (Modèle-Vue-Contrôleur).    
> Le modèle contient toutes les classes qui constituent notre algorithme.  
> La vue contient toutes les classes qui constituent notre application.  
> Le controleur permet de gérer les actions utilisateurs, et donc de gérer l'affichage en conséquence.
> 
> [En savoir plus sur le modèle MVC](https://chat.openai.com/share/e488856e-b47e-43ca-9f4c-ba80e30ad4e8)
> ### Tâches non réalisées & points à améliorer :
>>Durant ce projet de groupe, quelques tâches n'ont pas été réalisées à temps. Notemment les niveaux de réalisation 2 et 3.
> Le niveau 2 a été commencé, mais aucun des aspects du niveau n'a abouti à cause d'un manque de reflexion. En effet, nous 
> n'avons pas pensée à utiliser les différentes méthodes algorithmiques vue dans la ressource IN2R07 (Graphes), comme les listes d'adjacences,
> les algorithmes de parcours, ...  
>   
>>Egalement en rapport avec les niveaux de réalisation, notre application n'est pas à la hauteur de nos compétences. En effet,
> plusieurs aspects auraient pu être modifiés et des fonctionnalités auraient pu être ajoutées afin de mettre en place plus interactions
> entre la vue et le modèle avec l'utilisation du contrôleur.
>
> ### Ce que nous avons retenus :
>> Finalement, notre application permet de visionner les solutions dans leur ensemble, et elle permet de visionner les détails des solutions.  
> 
>> Ce projet nous à permis d'améliorer et d'alimenter notre expérience en ce qui concerne la conception et la réalisation d'application.  
> 
>> Ce projet est un projet complet, qui explore la quasi-totalité des aspects du développement informatiques, dont ; la gestion de projet, la planification, la collaboration,
> la conception, le développement de tests et d'algorithmes, ...


## 5 - 🔗 Annexe

* [Cliquez ici pour consulter le dépôt git du projet dans son entièreté](https://github.com/YassouSensai/RPG_Version_IHM.git) (dépôt final)
* [Cliquez ici pour consulter le premier dépôt git du projet](https://github.com/YassouSensai/RPG_Version.git) (dépôt initial - à prendre en compte pour les premiers commits)
* [Cliquez ici pour consulter le dossier de test]()