# P3-OCR-Developpez-le-back-end-en-utilisant-Java-et-Spring

Ce projet est une application Spring Boot 3 développée en Java 17. Elle utilise plusieurs dépendances clés pour la gestion de la base de données, la documentation de l'API, et l'authentification. Ce document fournit des informations sur la manière de configurer et de démarrer l'application, ainsi que sur les principales fonctionnalités et dépendances.

Prérequis :

Java 17 : Assurez-vous d'avoir Java 17 installé sur votre machine.
Maven : Utilisé pour la gestion des dépendances et la compilation.
MySQL : Base de données relationnelle utilisée par l'application.


L'application utilise un fichier application.properties pour la configuration. 
Exceptionnellement, ce fichier est inclus dans le dépôt pour faciliter les tests et la soutenance.
Veuillez noter que ce fichier contient des informations sensibles, telles que les identifiants de base de données et le secret du token. 

L'application sera accessible sur le port 3001.
http://localhost:3001

Documentation de l'API
La documentation de l'API est disponible à l'adresse suivante :
http://localhost:3001/swagger-ui/index.html


Dépendances
L'application utilise les dépendances suivantes :

Spring MVC : Framework pour la création d'applications web.
MySQL Driver : Connecteur JDBC pour MySQL.
Spring Data JPA : Facilite les opérations CRUD avec JPA.
jsonwebtoken (JWT) : Pour la gestion des jetons d'authentification.
springdoc-openapi : Génère automatiquement la documentation OpenAPI pour votre API REST.


Pour lancer l'application il vous suffit de:
git clone le projet, lancer l'application simplement sur intelliJ en cliquant sur play