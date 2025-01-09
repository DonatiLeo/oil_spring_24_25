

# TD3 - Mise en place de tests pour les services `dice`, `player`, et `discovery`

## Objectif

L’objectif de ce TD est de vous initier à la mise en place de tests pour vos services en respectant la pyramide des tests. Vous devrez maximiser les tests unitaires, limiter les tests d’intégration et minimiser les tests end-to-end. Vous testerez les classes et méthodes avec des traitements conditionnels ainsi que les interactions entre les différents services.

Pour les étudiants qui souhaitent aller plus loin, une activité bonus vous propose de mettre en place du **contract testing** avec **Pact**.

## Contexte

Vous travaillerez sur les services développés lors des TD1  et TD2  :

* **dice** : Service de gestion des lancés de dés.
* **player** : Service représentant un joueur capable de lancer des dés via le service **dice**.
* **discovery** : Service permettant l’enregistrement et la découverte des services disponibles.

Un projet template vous est fourni pour démarrer. Il contient des exemples de tests et les dépendances nécessaires.

## Instructions

### 1.   Configuration initiale

* Clonez ou téléchargez le projet template associé à cet assignement, vous pourrez vous appuyer sur ce projet pour réaliser les tests de votre projet
* Ajoutez les dépendances nécessaires pour les tests si elles ne sont pas déjà incluses (JUnit, Mockito, Spring Boot Test, etc.).

### 2.    Création des tests

#### A. **Tests unitaires**

* Testez chaque méthode avec un traitement conditionnel ou une logique métier non triviale. Voici une liste d'exemples, **cette liste n'est pas exhaustive !**
    * **Service `dice`** :
        * Testez les méthodes pour générer des lancés de dés.
        * Vérifiez que l’enregistrement des résultats en base de données fonctionne correctement.
    * **Service `player`** :
        * Testez les appels au service **dice** via le client Feign.
        * Vérifiez la gestion des cas particuliers (e.g., mauvais paramètres ou erreurs dans le service appelé).
    * **Service `discovery`** :
        * Testez les méthodes d’enregistrement des services.
        * Vérifiez que la liste des services en ligne est correctement retournée.
* Utilisez des mocks pour simuler les dépendances.

#### B. **Tests d’intégration**

* Testez les interactions entre les couches d’un même service (e.g., contrôleur ↔ service ↔ repository).
* Vérifiez que les services peuvent s’interfacer correctement avec leurs bases de données respectives.

#### C. **Tests end-to-end**

* Testez un scénario complet impliquant plusieurs services :
  * Exemple : Le client appelle le service **player** pour lancer un dé, le service **player** interagit avec **dice**, et les résultats sont enregistrés.
* Utilisez des ports spécifiques pour éviter les conflits.

### 3. Bonus : Contract Testing avec Pact

* Mettez en place du **contract testing** pour les interactions entre les services :
    * Exemple : Définissez un contrat entre **player** et **dice**, puis validez que chaque service respecte le contrat défini.
* Suivez la documentation de [Pact](https://pact.io/) pour configurer vos tests.

### 4. Livrables

* **Code source complet** : Incluez tous vos tests dans les projets des services **dice**, **player**, et **discovery**.
* **README** :
  * Liste des tests avec une brève description de ce qui est testé.
  * Instructions pour exécuter les tests.
  * **Rapport de tests** :  Capture d’écran ou export des résultats de tests (succès/échecs).

## Technologies

* **Framework principal** : Spring Boot
* **Framework de tests** : JUnit, Mockito
* **Contract Testing** : Pact (optionnel)

## Évaluation

* Pertinence et exhaustivité des tests créés.
* Respect des bonnes pratiques de la pyramide des tests.
* Qualité du code et clarté des explications fournies dans le README.

Bon testing ! 