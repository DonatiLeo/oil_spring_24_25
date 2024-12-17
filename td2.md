# TD2 - Architecture Microservices avec Spring Boot

## Objectif

Ce TD a pour but de vous initier à la mise en place d’une architecture microservices en construisant un écosystème autour du service **"dice"** développé lors du premier TD. Vous ajouterez deux nouveaux services (**player** et **discovery**) tout en respectant les principes exposés dans le cours.

## Contexte

-   **dice** : Service existant permettant de simuler des lancés de dés et de gérer un historique des résultats.
-   **player** : Nouveau service représentant un joueur, permettant de lancer des dés via le service **dice**.
-   **discovery** : Nouveau service à développer pour centraliser les informations sur les services disponibles. Ce service proposera deux endpoints simples :
    -   Un endpoint permettant aux services **dice** et **player** de s'enregistrer.
    -   Un endpoint permettant au client d’obtenir la liste des services en ligne ainsi que leur adresse.

## Instructions

### 1. Préparation de l’environnement

-   Réutilisez le service **dice** développé lors du TD1.
-   Créez deux nouveaux projets par l'intermédiaire des **modules** (comme précisé dans le cours), avec les dépendances suivantes :
    -   **Feign Client** pour le service **player**.
    -  **Spring Web** pour les services **player** et **discovery**.
    -   Aucune dépendance spécifique pour le service **discovery**.
-   Assurez-vous que chaque service utilise un port distinct (e.g., `8081` pour **dice**, `8082` pour **player**, et `8083` pour **discovery**).

### 2. Service `player`

1.  **Objectif** : Permettre à un joueur de lancer des dés via le service **dice**.
2.  **Instructions** :
    -   Implémentez une classe `Player` (pas de structure imposée, vous êtes libres dans sa conception).
    -   Configurez **Feign Client** pour interagir avec le service **dice** :
        -   Créez une interface Feign pour consommer les endpoints du service **dice**.
        -   Ajoutez une méthode permettant de lancer un ou plusieurs dés en appelant le service **dice**.
    -   Exposez un endpoint REST dans le contrôleur **player** :
        -   **`GET /player/rollDice`** : Lancer un dé.
        -   **`GET /player/rollDices/{X}`** : Lancer X dés.
    -   Implémentez une méthode permettant au service **player** de s’enregistrer dynamiquement auprès du service **discovery** au démarrage.

### 3. Service `discovery`

1.  **Objectif** : Centraliser la découverte des services en ligne pour faciliter leur interaction.
2.  **Instructions** :
    -   Implémentez un service **discovery** contenant :
        -   Une structure en mémoire (par exemple, une `Map` ou une `List`) pour stocker les informations des services enregistrés (nom du service et adresse/port).
        -   Un endpoint REST permettant aux services **dice** et **player** de s’enregistrer :
            -   **`POST /register`** :
                -   Reçoit un objet JSON contenant le nom du service et son URL/port.
                -   Ajoute l’entrée à la liste des services enregistrés.
        -   Un endpoint REST permettant au client de récupérer la liste des services enregistrés :
            -   **`GET /services`** :
                -   Retourne la liste des services actuellement enregistrés avec leurs informations (nom et adresse/port).
    -   Implémentez un mécanisme basique de nettoyage pour supprimer les services qui ne se sont pas réenregistrés après un certain délai (optionnel).

### 4. Interaction entre services

1.  Configurez le service **player** pour s’enregistrer dynamiquement auprès de **discovery** au démarrage.
2.  Configurez le service **dice** pour s’enregistrer dynamiquement auprès de **discovery** au démarrage.
3.  Ajoutez des logs dans le service **discovery** pour afficher les enregistrements entrants et les requêtes des clients.

### 5. Tests et Validation

1.  Démarrez les trois services (**dice**, **player**, et **discovery**).
2.  Vérifiez que :
    -   Les services **dice** et **player** s’enregistrent correctement auprès de **discovery**.
    -   Les appels au service **discovery** retournent la liste des services enregistrés.
    -   Les appels au service **player** permettent de déclencher des lancés de dés via le service **dice**.
    -   Les interactions entre services sont visibles dans les logs.

## Livrables

-   Les codes sources des trois services (**dice**, **player**, et **discovery**) dans un même dépôts GitHub (versionnez le dossier les contenant).
-   Un fichier `README.md` décrivant pour chaque service :
    -   Les endpoints exposés.
    -   La procédure pour démarrer et tester le service.
-   Une capture d’écran des logs démontrant les interactions entre les services.
-   (Optionnel) Une vidéo démontrant le fonctionnement des services.

## Technologies

-   **Framework principal** : Spring Boot
-   **Client HTTP** : Feign Client
-   **Base de données** : H2 (pour le service dice)

Bon dèv ! 🎲
