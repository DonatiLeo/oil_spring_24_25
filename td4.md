
# TD4 - Conteneurisation du projet avec Docker et Docker Compose

## Objectif

L’objectif de ce TD est d’apprendre à conteneuriser vos services avec Docker et de les orchestrer à l’aide de Docker Compose. Vous allez créer un environnement conteneurisé pour vos services **dice**, **player** et **discovery**, tout en vous assurant que votre projet fonctionne de manière transparente, que ce soit en local ou dans un environnement Dockerisé.

---

## Étapes à suivre

### 1. Création des Dockerfiles

* **But** : Créer un fichier Dockerfile pour chaque service (**dice**, **player**, **discovery**) afin de définir leur environnement.
* **Instructions** :
    - Basez vos Dockerfiles sur une image **Java OpenJDK 17** (ou la version compatible avec votre projet).
    - Copiez le fichier `JAR` généré par Gradle dans l’image Docker.
    - **Vous trouverez un exemple de Dockerfile applicable dans le cours associé**
* **Remarques** :
    - Les fichiers JAR devront être générés avec Gradle avant de construire l’image Docker (`./gradlew build`).
    - Si vous modifiez le code, vous devrez régénérer les fichiers JAR avant de reconstruire l’image Docker (`docker build`).


### 2. Construction et exécution des images Docker

* **Construction** :
    - Depuis le terminal, construisez vos images Docker pour chaque service en utilisant la commande suivante :
      ```bash
      docker build -t <nom-image>:<version> .
      ```
* **Test des conteneurs** :
    - Exécutez vos images pour vérifier leur fonctionnement :
      ```bash
      docker run -p <port-hôte>:<port-conteneur> <nom-image>:<version>
      ```
    - Vérifiez que chaque service répond correctement à ses endpoints.

---

### 3. Création du fichier Docker Compose

* **But** : Orchestrer vos services avec Docker Compose pour simplifier leur lancement.
* **Instructions** :
    - Créez un fichier `docker-compose.yml` à la racine de votre projet.
    - Définissez les services **discovery**, **dice**, et **player**.
    - Ordonnez vos services pour garantir que **discovery** démarre en premier.
    - **Vous trouverez un exemple de docker compose dans votre support de cours**

* **Test** :
    - Lancez tous les services simultanément avec :
      ```bash
      docker compose up (-d pour lancer en tâche de fond)
      ```
    - Arrêtez les services avec :
      ```bash
      docker compose down
      ```

---

### 4. Gestion des liens entre les services

* **Problème** : Les services ne fonctionneront plus avec `localhost`, car chaque conteneur dispose de son propre réseau.
* **Solution** :
    - Configurez les URLs des services en fonction des noms des conteneurs définis dans `docker-compose.yml` (e.g., `http://discovery:8083`).
    - Utilisez des variables d’environnement pour gérer dynamiquement les URLs en fonction de l’environnement (local ou Docker).
    - Vous devrez modifier légèrement votre code afin que votre client REST déclaratif (Feign) ne prenne pas directement l'url du service auquel il doit s'adresser en dur

---

### 5. Script optionnel

Pour simplifier les tâches répétitives (build des projets, des images Docker, lancement de Docker Compose), créez un script bash automatisé. Exemple pour le service discovery :
```bash
#!/bin/bash
./gradlew build
docker build -t discovery-service:1.0 ./discovery
docker compose up
```
Vous devrez produire un script qui fera ça pour tous les services (avec une boucle ou en faisant tout séquentiellement).

## Livrables

*  **Code source complet** : Incluez les Dockerfiles et le fichier `docker-compose.yml`.
*  **README** :
    -   Liste des commandes nécessaires pour :
        -   Générer les fichiers JAR.
        -   Construire les images Docker.
        -   Exécuter les conteneurs avec `docker run`.
        -   Utiliser Docker Compose.
    -   Instructions claires pour tester le projet.
    -   Assurez-vous que toutes les commandes dans le README sont exécutables directement, **comme ceci** :
    ```bash
    ./gradlew build
    ```
*  **Fonctionnalité** :
    -   Le projet doit fonctionner à la fois en local et dans un environnement Dockerisé, sans modifications de code ou de configuration.

----------

## Technologies

-   **Conteneurisation** : Docker
-   **Orchestration** : Docker Compose
-   **Langage** : Java / Spring Boot

----------

## Évaluation

-   **Fonctionnement** : Les services fonctionnent comme prévu dans Docker.
-   **Clarté** : Les instructions dans le README sont faciles à suivre et a exécuter.
-   **Automatisation** : Utilisation d’un script pour simplifier les tâches répétitives (optionnel).
-   **Modularité** : Respect des bonnes pratiques pour Docker et Docker Compose.