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
    - **Présentation des structures de données**
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

>Malheureusement, suite à des problème que Mohamed Lamine a pu rencontrer, la totalité du travail
> a été fait par moi (Yassine).

### *Outils utilisés*
>Pour la réalisation de ce projet, nous avons utilisé plusieurs outils qui se sont
> montré indispensables.  
> 1. InteliJ : C'est l'IDE qui nous à permis de tout produire (code et compte-rendu).
> 2. GitHub : C'est le service qui nous a permis de versionner notre projet avec Git.
>>#### InteliJ + GitHub :
>>L'utilisation de GitHub avec InteliJ nous a grandement simplifié la réalisation du projet. 
> En effet, il nous a suffit de créer un dépot vide sur GitHub, puis de créer le projet sur InteliJ 
> à partir du dépot GitHub.    
> Cela nous a permis de mieux gérer les commits (Points de contrôles), les branches, les fusions, ...
> grâce à une interface (InteliJ) qui nous a permis de versionner notre projet.  
>   
> 
> 3. Junit : C'est un framework qui nous a permis de faire les tests unitaires en java pour les classe du package modèle.
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
> fichiers textes et de les utiliser comme scenario. Puis nous avons commencé par créer les méthodes
> dont nous aurions besoins (avec la doc, sans les compléter). Nous avons ensuite créé les tests de certaines méthodes
> pour finalement compléter l'algorithme des methodes.  
>   
> *A prendre en compte : A cause de la precipitation, certaines méthodes ont été complétée avant d'avoir créé les tests.* 
>   
> Finalement, nous avons créé le projet pour l'IHM, développé l'IHM et intégré (+ compléter) les classes de test.
>   
> *Important : Le liens vers les deux dépôts GitHub seront présents dans l'annexe puisque le premier dépôt contient la quasi-totalité
des commits concernant l'algortihme de notre RPG.*
> 
> Pour être plus précis par rapport à notre méthode de développement, nous avons d'abord créé les premières classes incomplètes sur la branche main
> de notre projet. Puis pour le niveau 1, nous avons créé une nouvelle branche à partir de la branche main. Ainsi, une fois le niveau 1 terminé
> nous avons fusionné la branche du niveau 1 avec la branche main, puis nous avons créé une branche pour le niveau 2.


## 3 - 🔧 Conception Generale 
*Note : Les différents diagrammes ont été réalisé avec la version gratuite du logiciel StarUML*
### *Diagramme des classes de haut niveau*

### *Diagramme des classes par package*

#### *package modele :*
![UML_modele.png](UMLs%2FUML_modele.png)

### *package vue :*
![UML_vue.png](UMLs%2FUML_vue.png)